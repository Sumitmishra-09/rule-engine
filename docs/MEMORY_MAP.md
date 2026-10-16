# Rule engine quick memory map

Active review: 16 October 2026. Start with [the main-based map](MAIN_BRANCH_MAP.md), then [the function walkthrough](FUNCTION_REGISTRATION_WALKTHROUGH.md) and cited current source. The older redmine architecture remains a historical reference; do not assume its parser/type conclusions apply to main.

## Active repositories

| Worktree | Branch | Pushed commit | Main base |
|---|---|---|---|
| `main-worktrees/rule-engine/` | `feature/registered-functions-direct-calls` | `b39c51646627dc4c532d1bf20a0d9a9ef60e52b5` | `ff9aa7a11d34c3ee3bae9bbed547c3af1f625e19` |
| `main-worktrees/rule-engine-expression-parser/` | `feature/registered-functions-direct-calls` | `4e2829465f61d9761a0995dc50413948fc2b5755` | `e3abbe0050d9f3d63ca3974bdb583319a97dd083` |

Both feature heads were pushed and remote-verified after the direct-only cleanup and coordinated version bump; see [latest push evidence](evidence/direct-only-version-push-check.json). Main remains unchanged. The earlier user-requested rollback restored both local and remote redmine-19600 refs to engine f694d31bea1b6ac93db61760fe1be62348dec1ff and parser e4614287f57b5565d01ab01c60dd8d7e14871896; those refs remain unchanged. Both original folders and main-worktrees now use the feature commits above. Original classpath edits and the engine POM whitespace edit were preserved; the main-worktrees checkouts are clean. Historical rollback backups retain the removed redmine feature commits and earlier standalone parser experiment; see [rollback evidence](evidence/redmine-rollback-check.json).

The user requested the active main bases instead of redmine and explicitly requested deletion of the duplicate plural root `com.act21.rule.engine.dsl.expressions.parent`. The singular `com.act21.rule.engine.dsl.expression.parent` remains. No broad redmine type-system changes were imported. Feature versions are now engine **13.0.94** and parser **1.0.44**; the engine dependency matches parser 1.0.44. All parser parent/module POMs and bundle versions were updated. No Maven artifacts were published.

Committed follow-up: the user selected **direct calls only**. Current feature worktrees remove `FunctionRegistry.invoke` and reflective argument packing/conversion. Custom generation now requires bindings and compiler-visible public declarations; unsupported cases fail generation. The pushed commits above include this cleanup and the version changes.

## First lookup

```powershell
python tools/memory_map.py check
python tools/memory_map.py find 'FunctionCallBindings|compileRegisteredFunction'
python tools/memory_map.py excel 'main-worktrees/rule-engine/src/test/resources/registered-functions/CleanAndGetCodes.xlsx' --rows 1:4
```

`docs/WORKSPACE.json` selects the active repositories. On drift, review changed source/workbooks and update conclusions before `python tools/memory_map.py build`; refreshing indexes alone does not validate prose. Source indexes provide SHA-256 and method/line hints. Excel indexes preserve saved cell evidence, not formula recalculation or POI display formatting.

| Need | Read / inspect |
|---|---|
| Which checkout, versions and main differences | [MAIN_BRANCH_MAP.md](MAIN_BRANCH_MAP.md) |
| Register functions once, explicit arguments, types and List outputs | [Current walkthrough](FUNCTION_REGISTRATION_WALKTHROUGH.md) |
| Every feature source addition with current line links | [Added-line ledger](FUNCTION_REGISTRATION_LINES.md) |
| Direct invocation, helper-versus-custom routing, eligibility errors | Walkthrough source steps 4?8; `FunctionCallBindings`, `ExpressionGenerator.xtend`, engine `Generator` |
| Test workbooks and expected results | [Fixture guide](../main-worktrees/rule-engine/src/test/resources/registered-functions/README.md); `RegisteredFunctionsTest`, `DirectFunctionCallsTest` |
| Current tests/build evidence | [69 passing tests after direct-only cleanup](evidence/main-direct-only-check.json); [earlier 66-test run](evidence/main-direct-calls-check.json) |
| Historical pre-cleanup warmed-grid performance | [Benchmark metadata/results](evidence/main-direct-grid-performance.json), [raw JMH](evidence/main-direct-grid-jmh.json) |
| Excel reader/match/batch structure | Historical [architecture sections 3?5](ARCHITECTURE.md#3-architectural-blueprint), then corresponding main source; layout/matching algorithms were not changed in the port |
| Business examples and inferred schemas | `Grid-3.0/Grid-3.0/`, architecture section 7, [field evidence](evidence/sample-fields.json); inferred contracts remain unapproved |
| Earlier branch-specific explanations | `docs/history/REDMINE_*`, [archived indexes](evidence/redmine-before-main/snapshot.json), historical evidence files |

## Semantics to preserve

- A retained GridFactory owns one immutable registry and caches compiled rules by name/version. Registration is not per grid. Entity fields are read at execution time.
- Custom functions always use explicit arguments. Built-ins retain main's existing header behavior. Main's grammar/type system differ from the historical redmine branch; inspect main before answering detailed built-in compatibility questions.
- Custom functions use typed generated bridges and retained target objects only. Missing bindings, inaccessible declaring/enclosing classes, unavailable or incompatible loader/bytecode, and more than 254 bridge arguments fail generation. Registration still inspects Java methods once; reflective custom execution and `FunctionRegistry.invoke` are removed. Built-in snippets need no bindings. Varargs still allocate a typed tail array.
- Main's String-based type system is unchanged. Full generic custom signatures come from RegisteredFunctionTypes and registry metadata. Synthetic List-return declarations use the raw List name.
- List output appends elements through internal HelperFunctions.appendList, initializes null targets and avoids self-append when a function returns the same list it modified. Existing lists must be mutable; element types match exactly. Scalar/array addAll behavior remains.
- Null reference values reach the function. Primitive nulls fail. Integer-to-Long and Integer/Long-to-BigDecimal widening are supported; narrowings are not.
- Only the first Excel sheet executes. Exact yellow `FFFFFF00` and blue `FF00B0F0` fills, merges, blank-row termination, match policy and output order remain significant. Active adapter: StatefulExpressionParser, not the older engine-local ExpressionParser.
- Generated later batch objects are still constructed during execute. Their targets bind during construction; batch-object reuse was not part of this optimization.
- Use grid name `Dates3` with filename `Dates-3.xlsx`; the expected test result is 38. Grid names become Java class names. The compile helper extracts stored compiler diagnostics; expected invalid-function tests print validation details.
- Independent applications can use different registries. Shared function target objects must support the application's concurrency; facts/statistics/output lists remain execution-owned.

## Executed verification and limits

The current-source direct-only build passed **69 tests: 35 unchanged main tests + 22 registration tests + 12 direct-call tests**, no failures/errors/skips. Xtend generated Java was regenerated in staging from the edited source; the earlier Xtext 2.28 grammar outputs are unchanged. No generated parser Java was manually edited. Current production source bytes matched the tested staging copies. See evidence/main-direct-only-check.json. The cleanup is committed and pushed. The subsequent version bump changed metadata only; tested Java/Xtend source bytes were verified unchanged, and all version references were checked.

Historical pre-cleanup JDK 17/JMH measurements for a 100-row all-matching grid averaged about 8.1 microseconds/direct versus 16.9 microseconds/registry, and 2.5 KB versus 7.3 KB allocated per execution. This is a simple-function single-thread experiment, not a production speedup guarantee. Both paths used the then-current cached parameter metadata and excluded compilation. The comparison script requires matching pre-cleanup checkouts/builds because its legacy path calls the removed invoke API.

Reproduction commands are in MAIN_BRANCH_MAP. The full Tycho/UI release reactor remains unverified. Root docs/tools remain outside both Git histories; preserve them with the workspace. Historical redmine evidence (44+22 tests and the earlier 75-test optimization run) is distinct from the 66-test main result.
