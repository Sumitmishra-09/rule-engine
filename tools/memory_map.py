"""Read-only source/XLSX inventory for this workspace; Python standard library only.

Build: python tools/memory_map.py build
Check freshness: python tools/memory_map.py check
Inspect cells: python tools/memory_map.py excel PATH --rows 1:12
Find symbols: python tools/memory_map.py find PATTERN

This is an evidence extractor, not a reimplementation of the Java rule engine.
It never edits source files or workbooks. Excel cached values are not recalculated.
"""
from __future__ import annotations

import argparse
import collections
import hashlib
import json
import posixpath
import re
import subprocess
import sys
import zipfile
from datetime import datetime, timezone
from pathlib import Path
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / "docs" / "evidence"
REPOS = ("rule-engine", "rule-engine-expression-parser")
WORKSPACE = ROOT / "docs" / "WORKSPACE.json"
if WORKSPACE.exists():
    REPOS = tuple(json.loads(WORKSPACE.read_text(encoding="utf-8"))["repositories"])
NS = "{http://schemas.openxmlformats.org/spreadsheetml/2006/main}"
REL = "{http://schemas.openxmlformats.org/officeDocument/2006/relationships}"
SKIP = {".git", "target", "node_modules", "bin", ".settings"}
SOURCE_SUFFIXES = {".java", ".xtend", ".xtext", ".xml", ".mwe2", ".MF", ".tpd", ".target", ".properties", ".txt"}


def sha(path):
    h = hashlib.sha256()
    with path.open("rb") as f:
        for chunk in iter(lambda: f.read(1024 * 1024), b""):
            h.update(chunk)
    return h.hexdigest()


def git(repo, *args):
    p = subprocess.run(["git", "-C", str(ROOT / repo), *args], capture_output=True, text=True)
    return p.stdout.strip() if p.returncode == 0 else None


def source_files():
    for repo in REPOS:
        for p in sorted((ROOT / repo).rglob("*")):
            if p.is_file() and not SKIP.intersection(p.relative_to(ROOT).parts):
                if p.suffix in SOURCE_SUFFIXES or p.name in {"README.md", ".gitignore", ".classpath", ".project"}:
                    yield p


def source_entry(p):
    content = p.read_text(encoding="utf-8-sig", errors="replace")
    symbols = []
    for number, line in enumerate(content.splitlines(), 1):
        s = line.strip()
        # Navigation hints only: deliberately not represented as a Java AST.
        if re.match(r"(?:public |private |protected |static |final |abstract |synchronized |override |def |dispatch )+", s):
            if "(" in s or re.search(r"\b(class|interface|enum)\b", s):
                symbols.append({"line": number, "text": s})
        elif p.suffix == ".xtext" and re.match(r"\w+.*:\s*$", s):
            symbols.append({"line": number, "text": s})
    return {"path": p.relative_to(ROOT).as_posix(), "sha256": sha(p),
            "lines": len(content.splitlines()), "symbols": symbols,
            "imports": re.findall(r"^import\s+(.+?);?\s*$", content, re.M)}


def xml(z, name):
    return ET.fromstring(z.read(name))


def xlsx_parts(z):
    strings = []
    if "xl/sharedStrings.xml" in z.namelist():
        with z.open("xl/sharedStrings.xml") as f:
            for _, e in ET.iterparse(f, events=("end",)):
                if e.tag == NS + "si":
                    strings.append("".join(t.text or "" for t in e.iter(NS + "t")))
                    e.clear()
    style_root = xml(z, "xl/styles.xml")
    fills = []
    for fill in style_root.find(NS + "fills"):
        pat = fill.find(NS + "patternFill")
        fg = pat.find(NS + "fgColor") if pat is not None else None
        fills.append({"pattern": pat.get("patternType") if pat is not None else None,
                      "foreground": dict(fg.attrib) if fg is not None else {}})
    formats_node = style_root.find(NS + "numFmts")
    formats = {e.get("numFmtId"): e.get("formatCode") for e in formats_node} if formats_node is not None else {}
    styles = []
    for e in style_root.find(NS + "cellXfs"):
        fmt = e.get("numFmtId", "0")
        styles.append({"fill": fills[int(e.get("fillId", "0"))], "number_format_id": fmt,
                       "custom_number_format": formats.get(fmt)})
    relationships = {e.get("Id"): e.get("Target") for e in xml(z, "xl/_rels/workbook.xml.rels")}
    sheets = []
    for e in xml(z, "xl/workbook.xml").find(NS + "sheets"):
        target = relationships[e.get(REL + "id")]
        name = target.lstrip("/") if target.startswith("/") else posixpath.normpath("xl/" + target)
        sheets.append((e.get("name"), name))
    return strings, styles, sheets


def cell_record(e, strings, styles):
    kind = e.get("t", "n")
    raw = e.findtext(NS + "v")
    if kind == "s" and raw is not None:
        value = strings[int(raw)]
    elif kind == "inlineStr":
        value = "".join(t.text or "" for t in e.iter(NS + "t"))
    else:
        value = raw
    style_id = int(e.get("s", "0"))
    style = styles[style_id]
    return {"ref": e.get("r"), "type": kind, "value": value,
            "formula": e.findtext(NS + "f"), "style": style_id,
            "foreground": style["fill"]["foreground"], "number_format_id": style["number_format_id"]}


def inspect_excel(p, row_range=None):
    result = {"path": p.relative_to(ROOT).as_posix(), "sha256": sha(p), "bytes": p.stat().st_size, "sheets": []}
    with zipfile.ZipFile(p) as z:
        strings, styles, sheets = xlsx_parts(z)
        result["styles"] = styles
        for sheet_name, part in sheets:
            rec = {"name": sheet_name, "xml_part": part, "dimension": None, "merges": [],
                   "rows": 0, "serialized_cells": 0, "nonempty_cells": 0, "formulas": 0,
                   "cell_types": {}, "header_candidates": [], "rows_preview": [], "distinct_values_preview": []}
            types, unique = collections.Counter(), {}
            with z.open(part) as f:
                # Clear rows, rather than cells, to keep values until a row is complete.
                for _, e in ET.iterparse(f, events=("end",)):
                    if e.tag == NS + "dimension":
                        rec["dimension"] = e.get("ref")
                    elif e.tag == NS + "mergeCell":
                        rec["merges"].append(e.get("ref"))
                    elif e.tag == NS + "row":
                        rownum = int(e.get("r"))
                        cells = [cell_record(c, strings, styles) for c in e if c.tag == NS + "c"]
                        rec["rows"] += 1
                        rec["serialized_cells"] += len(cells)
                        for c in cells:
                            types[c["type"]] += 1
                            if c["value"] is not None:
                                rec["nonempty_cells"] += 1
                                if len(unique) < 60:
                                    unique.setdefault(c["value"], c["ref"])
                            if c["formula"] is not None:
                                rec["formulas"] += 1
                            rgb = c["foreground"].get("rgb", "").upper()
                            if c["value"] is not None and rgb in {"FFFFFF00", "FF00B0F0", "FFFF00", "00B0F0"}:
                                rec["header_candidates"].append(c)
                        keep = row_range[0] <= rownum <= row_range[1] if row_range else rownum <= 12
                        if keep:
                            rec["rows_preview"].append({"row": rownum, "cells": cells})
                        e.clear()
            rec["cell_types"] = dict(types)
            rec["distinct_values_preview"] = [{"value": v, "first_cell": c} for v, c in unique.items()]
            result["sheets"].append(rec)
    return result


def save(name, value):
    OUT.mkdir(parents=True, exist_ok=True)
    (OUT / name).write_text(json.dumps(value, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")


def build():
    sources = [source_entry(p) for p in source_files()]
    books, ignored = [], []
    for base in (ROOT / "Grid-3.0", ROOT / REPOS[0] / "src" / "test" / "resources"):
        for p in sorted(base.rglob("*.xlsx")):
            if p.name.startswith("~$"):
                ignored.append(p.relative_to(ROOT).as_posix())
            else:
                # Business examples are small: retain every serialized cell, including
                # auxiliary sheets. Large test fixtures retain a 12-row preview.
                books.append(inspect_excel(p, (1, 1048576) if base.name == "Grid-3.0" else None))
    repos = []
    for repo in REPOS:
        remote = git(repo, "remote", "get-url", "origin")
        repos.append({"path": repo, "head": git(repo, "rev-parse", "HEAD"),
                      "branch": git(repo, "branch", "--show-current"),
                      "origin": re.sub(r"(https?://)[^/@\s]+@", r"\1[REDACTED]@", remote or "")})
    save("source-index.json", {"symbol_index_kind": "line-based navigation hints, not a parsed AST", "files": sources})
    save("workbook-index.json", {"value_semantics": "raw OOXML values; numeric/date/percentage formatting is not applied; formulas are cached values only", "ignored_lock_files": ignored, "workbooks": books})
    save("sample-fields.json", sample_fields(books))
    save("snapshot.json", {"generated_utc": datetime.now(timezone.utc).isoformat(), "repositories": repos,
                           "source_files": len(sources), "workbooks": len(books), "lock_files_ignored": len(ignored),
                           "files": [{"path": x["path"], "sha256": x["sha256"]} for x in sources + books]})
    print(json.dumps({"source_files": len(sources), "workbooks": len(books), "lock_files_ignored": len(ignored)}))


def sample_fields(books):
    """Find schema candidates without pretending to resolve the Xtext language."""
    fields = {}
    grids = []
    def add(name, role, path, cell):
        if not re.fullmatch(r"[A-Za-z_][A-Za-z_0-9]*", name):
            return
        info = fields.setdefault(name, {"roles": set(), "occurrences": []})
        info["roles"].add(role)
        info["occurrences"].append({"workbook": path, "cell": cell, "role": role})
    for book in books:
        if not book["path"].startswith("Grid-3.0/"):
            continue
        sheet = book["sheets"][0]
        heads = sheet["header_candidates"]
        blue = [h for h in heads if h["foreground"].get("rgb", "").upper() == "FF00B0F0"]
        header_row = min(int(re.search(r"\d+", h["ref"])[0]) for h in blue)
        grid = {"path": book["path"], "sheet": sheet["name"], "header_row": header_row,
                "horizontal_inputs": [], "vertical_inputs": [], "outputs": [], "expression_references": []}
        headrefs = {h["ref"] for h in heads}
        for h in heads:
            role = "output" if h in blue else "vertical_input" if int(re.search(r"\d+", h["ref"])[0]) == header_row else "horizontal_input"
            grid[{"output": "outputs", "vertical_input": "vertical_inputs", "horizontal_input": "horizontal_inputs"}[role]].append(h["value"])
            add(h["value"], role, book["path"], h["ref"])
        refs = set()
        for row in sheet["rows_preview"]:
            for c in row["cells"]:
                if c["ref"] in headrefs or c["value"] is None:
                    continue
                expr = re.sub(r'"(?:\\.|[^"\\])*"|\'(?:\\.|[^\'\\])*\'', "", str(c["value"]))
                for match in re.finditer(r"\b[A-Za-z_][A-Za-z_0-9]*\b", expr):
                    name = match[0]
                    if name in {"true", "false", "null", "ALL", "PASS", "upto"} or re.match(r"\s*\(", expr[match.end():]):
                        continue
                    refs.add(name)
                    add(name, "expression_reference_candidate", book["path"], c["ref"])
        grid["expression_references"] = sorted(refs)
        grid["referenced_without_header"] = sorted(refs - set(grid["horizontal_inputs"] + grid["vertical_inputs"] + grid["outputs"]))
        grids.append(grid)
    for info in fields.values():
        info["roles"] = sorted(info["roles"])
    return {"confidence": "INFERRED lexical schema candidates, not an executable or business-approved schema; first sheets only", "grids": grids, "fields": dict(sorted(fields.items()))}


def check():
    snap = json.loads((OUT / "snapshot.json").read_text(encoding="utf-8"))
    changes = []
    for item in snap["files"]:
        p = ROOT / item["path"]
        if not p.is_file() or sha(p) != item["sha256"]:
            changes.append(item["path"])
    tracked = {x["path"] for x in snap["files"]}
    current = {p.relative_to(ROOT).as_posix() for p in source_files()}
    current.update(p.relative_to(ROOT).as_posix() for base in (ROOT / "Grid-3.0", ROOT / REPOS[0] / "src" / "test" / "resources") for p in base.rglob("*.xlsx") if not p.name.startswith("~$"))
    changes.extend(sorted(current - tracked))
    for repo in snap["repositories"]:
        if git(repo["path"], "rev-parse", "HEAD") != repo["head"]:
            changes.append(repo["path"] + " HEAD changed")
    print(json.dumps({"fresh": not changes, "changed_missing_or_new": changes}, indent=2))
    return 1 if changes else 0


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    commands = parser.add_subparsers(dest="command", required=True)
    commands.add_parser("build")
    commands.add_parser("check")
    ex = commands.add_parser("excel")
    ex.add_argument("path")
    ex.add_argument("--rows", default="1:12")
    find = commands.add_parser("find")
    find.add_argument("pattern")
    args = parser.parse_args()
    if args.command == "build":
        build()
    elif args.command == "check":
        return check()
    elif args.command == "excel":
        p = (ROOT / args.path).resolve()
        p.relative_to(ROOT)
        record = inspect_excel(p, tuple(map(int, args.rows.split(":"))))
        for sheet in record["sheets"]:
            print("SHEET", sheet["name"], "MERGES", ", ".join(sheet["merges"]))
            for row in sheet["rows_preview"]:
                print(" | ".join(f"{c['ref']}={c['value']!r} fill={c['foreground']}" for c in row["cells"] if c["value"] is not None))
    else:
        index = json.loads((OUT / "source-index.json").read_text(encoding="utf-8"))
        pattern = re.compile(args.pattern, re.I)
        for item in index["files"]:
            if pattern.search(item["path"]):
                print(item["path"], "lines=", item["lines"])
            for symbol in item["symbols"]:
                if pattern.search(symbol["text"]):
                    print(f"{item['path']}:{symbol['line']}: {symbol['text']}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
