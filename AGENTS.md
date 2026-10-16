# Active worktree override ? 16 October 2026

Active repositories remain main-worktrees/rule-engine and main-worktrees/rule-engine-expression-parser on feature/registered-functions-direct-calls, now committed and pushed at engine `b39c51646627dc4c532d1bf20a0d9a9ef60e52b5` (13.0.94) and parser `4e2829465f61d9761a0995dc50413948fc2b5755` (1.0.44). Main bases remain ff9aa7a/e3abbe0. Engine parser dependency and all parser module/bundle versions match 1.0.44. Both original folders also use these feature commits and were synchronized while preserving local classpath edits and the engine POM whitespace edit; main-worktrees are clean. Both checkout locations use the same branch, so future commits must account for the other worktree's index/files (temporarily detach then safely advance if needed). Do not overwrite user edits. Redmine refs remain restored to engine f694d31bea1b6ac93db61760fe1be62348dec1ff and parser e4614287f57b5565d01ab01c60dd8d7e14871896. Main/redmine remote heads were verified unchanged. See docs/evidence/direct-only-version-push-check.json; earlier rollback backups/evidence remain historical.

Start with docs/MEMORY_MAP.md and docs/MAIN_BRANCH_MAP.md. docs/WORKSPACE.json selects current repositories for tools/memory_map.py. The older architecture and text below are historical redmine context. Main's grammar, String-based TypeSystem, runtime Type and built-ins remain unchanged; full custom List metadata is handled by RegisteredFunctionTypes. Custom calls always require explicit arguments. The user subsequently selected direct-only custom execution: FunctionRegistry.invoke, reflective execution/conversion and generated fallback expressions are removed in the pushed feature commits. Missing FunctionCallBindings, inaccessible declaring/enclosing classes, missing/incompatible compiler loader/bytecode and more than 254 bridge arguments now fail generation. Registration still inspects method metadata; targets are bound per generated batch instance. Subsequent batch instances still get created during execute.

Latest direct-only verification: 35 original tests + 22 registration tests + 12 direct-call tests passed (69 total). The code is committed/pushed, with version metadata checked afterward and tested Java/Xtend source bytes unchanged; see docs/evidence/main-direct-only-check.json and direct-only-version-push-check.json. Run `python tools/registration_check.py --workspace main-worktrees --output output/main-direct-only-check --offline --test 'RegisteredFunctionsTest,DirectFunctionCallsTest,DecisionParserTests'`. Xtext generation tool: tools/generate_parser.py. See docs/evidence/main-direct-calls-check.json, main-direct-grid-performance.json and main-feature-push-check.json. Full Tycho release reactor remains unverified; no Maven artifacts were published. Root docs/tools are outside both repositories.

# Historical workspace context

This containing folder holds two independent repositories and sample Excel files:

- `rule-engine/`: Java decision-table compiler/runtime.
- `rule-engine-expression-parser/`: Xtext expression language and runtime helpers.
- `Grid-3.0/Grid-3.0/`: business decision-table samples.

Start with [docs/MEMORY_MAP.md](docs/MEMORY_MAP.md). Open only the relevant sections of [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md), then the cited current source. The JSON indexes under `docs/evidence/` support exact file, method, workbook-cell and inferred-field lookups.

Before relying on the snapshot, run `python tools/memory_map.py check` from this folder. On drift, review changed source/workbooks and update the relevant conclusions before refreshing indexes with `python tools/memory_map.py build`. An index refresh alone does not validate prose. Use `find PATTERN` for source hints and `excel PATH --rows START:END` for saved cell evidence.

The documented baseline is engine branch `redmine-19600` at `f694d31bea1b6ac93db61760fe1be62348dec1ff` (13.0.93) and parser branch `redmine-19600` at `e4614287f57b5565d01ab01c60dd8d7e14871896` (1.0.43). The user confirmed parser 1.0.43 as intended and requested this engine branch. The remote pull was network-blocked; verify current identities rather than assuming these remain latest.

Important distinctions:

- Active parser integration is `StatefulExpressionParser`, not the older engine-local `ExpressionParser`.
- Excel exact header fills, merges, match mode, blank-row termination and output order all affect semantics. Read the relevant sections before changing them.
- Supplied business schemas and cross-grid orchestration are inferred, not approved contracts. Existing engine tests show actual API usage.
- Source-derived conclusions, workbook observations and executed checks are separately labeled. Full engine/parser tests did not run during the documentation baseline; only 15 direct helper checks passed. Build blockers and logs are recorded.
- Check status in each repository separately. Documentation/tools at this containing root are outside both Git histories. Preserve unrelated user work and avoid editing generated parser artifacts by hand.

For a behavior change, follow the architecture change-location table, establish a focused expected input/output example, and run relevant available checks. Update affected documentation and evidence without silently changing unrelated business workbooks.

Local extension added 15 October 2026: plain Java `FunctionRegistry` is supplied once to `GridFactory`, with no per-grid registration and no Spring dependency. The user chose **always explicit arguments for custom functions**; preserve existing built-in shorthand separately. Read `docs/FUNCTION_REGISTRATION_WALKTHROUGH.md` and `docs/FUNCTION_REGISTRATION_LINES.md` for implementation details. The focused current-source build passed 44 existing engine tests plus 15 new registration tests; see `docs/evidence/registration-check.json`. Run it with `python tools/registration_check.py --offline --test 'RegisteredFunctionsTest,DecisionParserTests'`. The full Tycho release reactor remains unverified, and no release versions were bumped or artifacts published. Existing user edits to `.classpath` files and the parser experiment `main` must remain intact.

Latest follow-up supports typed List results: blue list outputs use internal `HelperFunctions.appendList`, initialize null targets and skip self-append if a function mutates and returns the same list. Existing targets must be mutable; element types must match exactly. Scalar/array `addAll` behavior is retained. Ten new Excel fixtures and seven new tests cover this behavior; 44 existing tests and all 22 registration tests passed across two commands (see `docs/evidence/list-return-check.json`). Keep the passing date-test grid name `Dates3` separate from its filename `Dates-3.xlsx`, as explicitly requested by the user.

Commit/push follow-up, 15 October 2026: authorized changes were committed and pushed to `redmine-19600` in both repositories: engine `a6ba32ca1bbe2c2a1187d699512e9f3e61e0fc13`, parser `126a95f62b712b7ba55d4138c90f284faf0391ba`. Both remote heads were verified; the earlier network failure is historical. `.classpath` edits, the standalone parser main experiment, and Excel lock files remain local and must be preserved. Root docs/tools remain outside both repositories. No Maven artifacts were published. See `docs/evidence/push-check.json`.
