"""Refresh the feature's source-line ledger against each active repository's origin/main.

This is a navigation aid. Review source conclusions before refreshing the ledger.
"""
from pathlib import Path
import hashlib
import json
import re
import subprocess

ROOT = Path(__file__).resolve().parents[1]
repos = json.loads((ROOT / 'docs/WORKSPACE.json').read_text(encoding='utf-8'))['repositories']
historical = (ROOT / 'docs/history/REDMINE_FUNCTION_REGISTRATION_LINES.md').read_text(encoding='utf-8')
explanations = {}
for line in historical.splitlines():
    match = re.match(r'\| \[\d+\].*? \| `(.*)` \| (.*) \|$', line)
    if match:
        explanations[match[1]] = match[2]

contexts = {
    'FunctionCallBindings': 'Create generation state for one batch using its compilation class loader.',
    'compileCall': 'Require direct-call eligibility and reuse/create a typed bridge for this alias and argument signature.',
    'directCallProblem': 'Explain any inaccessible owner, class-loader mismatch or missing bytecode before generating Java.',
    'appendMethod': 'Generate typed parameters/conversions, exact-overload invocation and preserved exception behavior.',
    'declarations': 'Emit only the target fields and bridge methods collected from this batch.',
    'initializers': 'Bind the existing application targets in the generated constructor.',
    'typeOf': 'Read full custom/field signature metadata while retaining main scalar inference for other expressions.',
    'describe': 'Retain generic arguments from main TypeReference metadata.',
    'isListType': 'Recognize raw or parameterized List descriptors for assignment checks.',
    'argumentTypes': 'Infer each explicitly supplied argument descriptor for validation and bridge generation.',
    'getTarget': 'Expose the retained application object for generated constructor binding.',
    'getDeclaringType': 'Expose the public Java declaration owner, which can differ from the target runtime class.',
    'getMethodName': 'Expose the actual registered method name independently of its Excel alias.',
    'isStatic': 'Distinguish class invocation from instance target binding.',
    'getJavaParameterType': 'Read cached Java parameter metadata, using the scalar component for varargs.',
}


def git(repo, *args):
    return subprocess.check_output(['git', '-C', str(ROOT / repo), *args], text=True, encoding='utf-8')


def explain(code, context, filename):
    if code.startswith('package '): return 'Declare the source package.'
    if code.startswith('import '): return 'Import the referenced type used below.'
    if code in ['}', '};', '});']: return 'Close the preceding block or declaration.'
    if code.startswith(('//', '/**', '*', '*/')): return 'Document the adjacent implementation contract.'
    if 'registeredFunctions.invoke' in code: return 'Verify that generated expressions do not contain the removed registry invocation.'
    if 'FunctionCallBindings' in code or 'functionCalls' in code: return 'Share the per-batch binding session with generated expressions and emit its members.'
    if 'javaParameterTypes' in code: return 'Cache/read Java parameter classes for validation and typed call generation.'
    if code in explanations: return explanations[code]
    if context in contexts: return contexts[context]
    if filename == 'DirectFunctionCallsTest.java':
        return 'Exercise ' + (context or 'the direct-call test setup') + ' using real grid compilation and generated-source checks.'
    if 'RegisteredFunctionTypes' in code or 'resultType' in code or 'genericStart' in code:
        return 'Use full custom generic metadata without changing main\'s scalar type system or grammar.'
    if code.startswith(('assert', '@Test')): return 'Verify the stated expected result or exception in this scenario.'
    return 'Continue ' + (context or 'the surrounding declaration') + '; see the source walkthrough for its contract.'


output = ['# Current main-based function feature: added-line ledger', '',
          'Generated from reviewed current source against origin/main. Read [the walkthrough](FUNCTION_REGISTRATION_WALKTHROUGH.md) first. '
          'Every nonblank added/replaced Java/Xtend line is shown; continuation lines belong to the surrounding statement. '
          'The deleted duplicate root is listed separately. Generated parser artifacts are excluded.', '']
removed = []
for repo in repos:
    files = set(git(repo, 'diff', '--name-only', 'origin/main').splitlines())
    files.update(git(repo, 'ls-files', '--others', '--exclude-standard').splitlines())
    for relative in sorted(files):
        path = ROOT / repo / relative
        if not path.exists():
            removed.append(repo + '/' + relative)
            continue
        if path.suffix not in ['.java', '.xtend', '.MF']: continue
        content = path.read_text(encoding='utf-8').splitlines()
        diff = git(repo, 'diff', '--unified=0', 'origin/main', '--', relative)
        if not diff:
            added = set(range(1, len(content) + 1))
        else:
            added = set()
            number = 0
            for line in diff.splitlines():
                hunk = re.match(r'@@ -\d+(?:,\d+)? \+(\d+)(?:,\d+)? @@', line)
                if hunk:
                    number = int(hunk[1])
                elif line.startswith('+') and not line.startswith('+++'):
                    added.add(number)
                    number += 1
                elif line.startswith(' '): number += 1
        output += ['## ' + repo + '/' + relative, '', '| Line | Added/replaced code | Explanation |', '|---|---|---|']
        context = ''
        for number, line in enumerate(content, 1):
            code = line.strip()
            method = re.match(r'(?:public|private|protected|static|final|synchronized|def)\s+.*?\b(\w+)\([^;]*', code)
            if method: context = method[1]
            if number not in added or not code: continue
            escaped = code.replace('|', '&#124;')
            output.append(f'| [{number}]({path.as_posix()}:{number}) | `{escaped}` | {explain(escaped, context, path.name)} |')
        output += ['', 'Source SHA-256: `' + hashlib.sha256(path.read_bytes()).hexdigest() + '`.', '']
output += ['## Explicitly requested duplicate-root removal', '',
           'The following ' + str(len(removed)) + ' tracked files under the obsolete plural root are deleted. '
           'The active singular expression.parent reactor remains.', '']
output.extend('- `' + path + '`' for path in removed)
(ROOT / 'docs/FUNCTION_REGISTRATION_LINES.md').write_text('\n'.join(output) + '\n', encoding='utf-8')
print('Wrote docs/FUNCTION_REGISTRATION_LINES.md')
