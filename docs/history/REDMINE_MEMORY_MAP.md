> Historical redmine documentation saved before the main port. Paths/line numbers describe that earlier snapshot; use ../MEMORY_MAP.md for active code.

# Rule engine quick memory map

Read this first, then open the relevant section of [ARCHITECTURE.md](ARCHITECTURE.md) and its cited source. This is a navigation aid, not a replacement for current code. Reviewed 16 October 2026, including function-registration dispatch and an exploratory performance comparison.

## Snapshot and scope

| Location | Recorded baseline |
|---|---|
| `rule-engine/` | `redmine-19600`, `f694d31bea1b6ac93db61760fe1be62348dec1ff`; engine 13.0.93 depends on parser 1.0.43 |
| `rule-engine-expression-parser/` | `redmine-19600`, `e4614287f57b5565d01ab01c60dd8d7e14871896`; parser 1.0.43 is the user-confirmed intended version |
| `Grid-3.0/Grid-3.0/` | 17 business workbooks; schemas inferred from cells and tests |
| Test resources | 87 XLSX fixtures: 48 existing + 39 registration/example files, of which 38 are loaded by the registration suite. The user's Dates-3.xlsx is the current date-test fixture; edited Dates.xlsx remains a separate experiment. Historical test results are recorded below. |

The engine branch was originally selected from the locally available tracking reference, after a remote pull failed through configured proxy `127.0.0.1:9`. That network limitation was resolved by the 15 October commit/push follow-up: both branches were fetched, pushed and verified against their remote heads. Current engine commit is `a6ba32ca1bbe2c2a1187d699512e9f3e61e0fc13`; parser commit is `126a95f62b712b7ba55d4138c90f284faf0391ba`, both on `redmine-19600`. The baseline table above remains historical. This containing folder and the memory pack are outside their Git repositories.

The authorized plain Java function-registration changes, typed list results, tests and 39 Excel examples are committed and pushed. The user's standalone parser experiment, Eclipse `.classpath` changes and Excel lock files remain local. Versions have not been bumped and Maven artifacts have not been published. Preserve those unrelated edits. Registration is application-wide on `GridFactory`, never repeated per grid, and **custom function arguments are always explicit** by the user's choice.

## First lookup

Run from the containing workspace root:

```powershell
python tools/memory_map.py check
python tools/memory_map.py find 'determineConditionType|createBatch'
python tools/memory_map.py excel 'Grid-3.0/Grid-3.0/SM/incentive/sm_wfylp_slab.xlsx' --rows 1:8
rg -n 'MATCH_UNTIL|MATCH_AND_EXIT' rule-engine/src/main
```

If `check` reports changes, inspect the changed sources/workbooks and revise the affected documentation. Then run `python tools/memory_map.py build` to refresh evidence. Rebuilding indexes alone does not validate the prose. Python's standard library is sufficient; the extractor does not execute rules, evaluate formulas or apply POI display formatting.

| Need | Read / inspect |
|---|---|
| How callers construct and execute a grid | [Architecture 2.3](ARCHITECTURE.md#23-calling-the-engine); `DecisionParserTests.testcase1`, request helper near line 1081; `RuleCreationRequest`, `GridFactory`, `Rule` |
| Register application functions once | [Architecture 6.9](ARCHITECTURE.md#69-application-registered-functions), [usage/source walkthrough](FUNCTION_REGISTRATION_WALKTHROUGH.md), [each changed line](FUNCTION_REGISTRATION_LINES.md); `FunctionRegistry`, `GridFactory(FunctionRegistry)`, `RegisteredFunctionsTest` |
| Reflection performance / Xtend helper-versus-registry routing | [Performance and dispatch review](FUNCTION_REGISTRATION_WALKTHROUGH.md#performance-and-dispatch-review-16-october-2026), [local JMH evidence](evidence/function-invocation-performance.json); no production optimization implemented; typed/direct invocation comparisons are not whole-grid speedup estimates |
| Open/edit custom-function test workbooks | [Fixture guide](../rule-engine/src/test/resources/registered-functions/README.md); 38 of 39 XLSX files loaded directly by `RegisteredFunctionsTest`, including nine expected compilation failures under `invalid/`; grid name `Dates3` loads file `Dates-3.xlsx`; `ListResult.xlsx` and `CleanAndGetCodes.xlsx` demonstrate list returns |
| Architecture and execution sequence | [Architecture 3](ARCHITECTURE.md#3-architectural-blueprint); `Compiler.getRule`, `DecisionTableParser`, `Generator.generate` |
| Eclipse target setup / repository PKIX errors | [Architecture 1.6](ARCHITECTURE.md#16-eclipse-target-setup-and-the-observed-certificate-failure); actual host JRE, Act21 CA trust issue, metadata checks and setup steps |
| Yellow/blue headers and 2D examples | [Architecture 4](ARCHITECTURE.md#4-excel-parser-and-table-semantics); `Constants`, `SheetHandler` |
| Merged cells, blank rows, sparse cells, formulas | [Architecture 4.3–4.5](ARCHITECTURE.md#43-reader-state-machine); `SheetHandler`, `RuleDataFormatter` |
| Match modes, output order and batches | [Architecture 5](ARCHITECTURE.md#5-compilation-and-execution-semantics); `Generator`, `Compiler.createBatch` |
| Grammar, ranges, operators and functions | [Architecture 6](ARCHITECTURE.md#6-expression-language-and-runtime); `Expression.xtext`, AST converters, `ExpressionGenerator.xtend` |
| Complete function/operator compatibility list | [Architecture 6.8](ARCHITECTURE.md#68-complete-grid-function-and-operator-checklist); all 10 declared function names, examples, supported operators and type limitations |
| Implicit field arguments / in / contains / NOT | [Architecture 6.4](ARCHITECTURE.md#64-function-arguments-and-implicit-headers); linker, `Utils.isParentLogicalExpression`, decide converter |
| Numeric types, coercion, lists, nulls | [Architecture 6.5–6.7](ARCHITECTURE.md#65-types-coercion-and-collection-assignments); `TypeSystem`, `TypeCastHandler`, `HelperFunctions`, validators |
| Business workbook meaning and candidate schema | [Architecture 7](ARCHITECTURE.md#7-business-sample-walkthrough-and-inferred-schemas); [field occurrences](evidence/sample-fields.json) |
| Table persistence/export and Excel writing | [Architecture 8](ARCHITECTURE.md#8-storage-adapters-and-migration-utilities); `RuleService`, `ExcelWriter`, migration utilities |
| Where to implement a future change | [Architecture 9.2](ARCHITECTURE.md#92-where-to-change-what); adjacent source, existing fixture and expected output |
| Known limitations and confidence | [Architecture 9.3–10](ARCHITECTURE.md#93-current-pitfalls-to-preserve-in-future-lookups) |

Engine source prefix: `rule-engine/src/main/java/com/act21/impaktapps/rule/engine/`.

Parser reactor prefix: `rule-engine-expression-parser/com.act21.rule.engine.dsl.expression.parent/`. Handwritten grammar/converters/generator live in module `com.act21.rule.engine.dsl.expression`; runtime API/helpers live in `com.act21.rule.engine.dsl.expression.Runtime`. The engine-local `table/ExpressionParser.java` is an older implementation; the active adapter is **StatefulExpressionParser**.

## Semantics to keep in working context

- Only the first worksheet executes. Exact header ARGB values are yellow `FFFFFF00` and blue `FF00B0F0`.
- The first blue header row separates horizontal conditions above it from vertical conditions below it. Merges encode parent/child coverage; repeating text in unmerged cells does not merge branches.
- Each batch computes horizontal and vertical matches, then executes their output intersections. Outputs execute in order on the same mutable Java fact; later outputs can read earlier assignments.
- `MATCH_AND_EXIT` chooses the first matching sibling branch at each level, without backtracking if its descendants fail. `MATCH_UNTIL` continues searching until a leaf is found. `MATCH_ALL` collects matching leaves. Read section 5 before mapping these to another engine's hit policy.
- Blank, `ALL` and `PASS` conditions can mean wildcard, but an all-blank input row terminates table parsing. Blank outputs have a generator/validator discrepancy.
- Scalar output setters overwrite earlier values; collection outputs append. Runtime metadata dates/active flags do not filter execution; the current code validates them and excludes their columns from predicates.
- `[1-7[` is inclusive 1, exclusive 7. `[1,7]` is membership, not a range. Integer literals infer Long; decimals infer BigDecimal.
- Arithmetic `+ - * / %` shares one left-associative grammar level. Parenthesize mixed operations. Function argument insertion depends on whether AND/OR surrounds the call; NOT alone does not suppress it.
- A retained `GridFactory` caches by grid name/version only. Change the version when compiled inputs change; different schema/options with the same key do not produce a new rule in that cache.
- Grid names become Java class names: `Dates-3` produces invalid `Dates-31`. Keep a valid grid name such as `Dates3` separate from the Excel filename. The registration-test helper now extracts the compiler's stored diagnostics, which are not included in its default exception message.
- Each factory retains one immutable custom-function registry. Custom calls never receive an implicit header, even when standalone or nested. Built-in shorthand remains unchanged. Names resolve using each parser's resources; compiled rules and subsequent batches retain the same registry.
- Custom functions may return `List<supported scalar>`. Blue list outputs append elements using internal `HelperFunctions.appendList`, initialize null destinations, and skip self-append when a function clears/repopulates and returns the same list. Existing destinations must be mutable; exact list element types must match. Scalar/array assignments to list outputs keep the existing `addAll` path.
- Requests capture restricted characters and create a registry-aware parser when compilation starts; direct legacy parser access remains available lazily with built-ins.
- Business types and cross-grid sequencing are inferred. Seven eligibility inputs are Boolean; numeric 0/1 output flags are not automatically Boolean. `current_gs_month`/`goalsheet_start_month` remain unresolved shared types.

Each statement is expanded and linked to source in the corresponding architecture section. Do not treat these notes as compatibility claims for Drools, ACTICO or Camunda.

## Durable evidence and verification

| Artifact | Contents / limit |
|---|---|
| [source-index.json](evidence/source-index.json) | Current source/config files, SHA-256, imports and line-based symbol hints; includes generated artifacts now present; not an AST |
| [workbook-index.json](evidence/workbook-index.json) | 104 XLSX files; colors, merged ranges, raw/cached cells, styles; full business sheets and first 12 rows of test sheets; nine Excel lock files ignored |
| [sample-fields.json](evidence/sample-fields.json) | 127 candidate fields; input/output/reference roles, workbook/cell occurrences, per-grid undeclared reference candidates |
| [snapshot.json](evidence/snapshot.json) | Local repository identities and source/workbook hashes for freshness checks |
| [HelperSemanticsProbe.java](../tools/HelperSemanticsProbe.java) / [result](evidence/helper-probe.txt) | 15 direct checks passed against actual HelperFunctions source; no full parser/engine execution |
| [Engine build log](evidence/engine-build.log) | Offline Maven stopped at unavailable cached internal runtime 1.0.43; no tests ran |
| [Parser build log](evidence/parser-build.log) | Offline Tycho/Equinox initialization failed with `Unable to create lock manager`; no tests ran |
| [Registration checks](evidence/registration-check.json) / [summary](evidence/registration-check.txt) | 15 October: 59 tests passed (44 existing + 15 new); current sources compiled together with real Xtend 2.28 generation |
| [Saved-fixture checks](evidence/registration-fixtures-check.json) | 15 October follow-up: all 15 registration tests passed using 28 saved XLSX files; includes workbook hashes and the new build log |
| [Date grid / compiler diagnostics](evidence/date-grid-check.json) | Later 15 October: reproduced invalid Java class Dates-31, corrected grid name to Dates3 while keeping file Dates-3.xlsx, and verified result 38; all 15 registration tests passed again |
| [List-return checks](evidence/list-return-check.json) | Latest 15 October: 44 existing engine tests and 22 registration tests passed across two commands; seven new list-return tests use ten new XLSX fixtures. The first run exposed a test's incorrect exception-wrapper expectation; only that assertion/import changed before the passing registration rerun. Includes source/workbook/report/log hashes. |
| [Eclipse runtime-classpath check](evidence/runtime-classpath-check.json) | Later missing-appendList report: current Eclipse runtime output has the helper; the existing compiled clear-and-return test passed using explicit project outputs/dependencies. Earlier failing Eclipse launch classpath was not captured. Two regenerated Xtend Java files match the verified focused output. See walkthrough troubleshooting section. |
| [Invalid-function diagnostics](evidence/invalid-function-diagnostics-check.json) / [messages](evidence/invalid-function-diagnostics.txt) | Latest test-output follow-up: the negative-function test now prints the detailed exception captured by assertThrows. One targeted test passed across seven invalid workbooks; production validation unchanged. User edits disabling the clear-and-return identity assertion and printing codes are preserved. |
| [Commit/push verification](evidence/push-check.json) | User-requested push completed for engine a6ba32c and parser 126a95f on redmine-19600; both remote heads verified. Includes scope, excluded local edits and prior validation evidence. |
| [Invocation performance comparison](evidence/function-invocation-performance.json) / [raw JMH](evidence/function-invocation-jmh.json) | 16 October: short local JDK 17/JMH experiment on actual registry plus tiny add function; current registry, cached reflection, typed/generic handles and direct calls compared. No production changes or full-grid performance claims. |
| [Focused verification tool](../tools/registration_check.py) | `python tools/registration_check.py --offline --test 'RegisteredFunctionsTest,DecisionParserTests'`; full Tycho release reactor remains unverified |

Build commands, source-dump directory requirements and probe reproduction are in [architecture 1.4](ARCHITECTURE.md#14-commands-and-verification-inventory). Preserve this pack with the workspace or intentionally version it in a documentation repository. Future sessions must read it; conversational memory is not the source of truth.
