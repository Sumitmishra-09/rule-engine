# Main-based implementation, 16 October 2026

The active work is on `feature/registered-functions-direct-calls` in both repositories, in these separate worktrees:

- [Engine](../main-worktrees/rule-engine): based on fetched `origin/main` at `ff9aa7a11d34c3ee3bae9bbed547c3af1f625e19`, version 13.0.91.
- [Parser](../main-worktrees/rule-engine-expression-parser): based on fetched `origin/main` at `e3abbe0050d9f3d63ca3974bdb583319a97dd083`, version 1.0.41.

The current feature commits are engine `b39c51646627dc4c532d1bf20a0d9a9ef60e52b5` (13.0.94) and parser `4e2829465f61d9761a0995dc50413948fc2b5755` (1.0.44); the engine depends on parser runtime 1.0.44. All parser parent/module POMs and bundle versions agree. Both heads were pushed and remote-verified; see [latest push evidence](evidence/direct-only-version-push-check.json). Main and restored redmine refs are unchanged. Original folders were synchronized to these same feature commits while preserving local classpath edits and the engine POM whitespace edit. The earlier [feature push](evidence/main-feature-push-check.json) and [redmine rollback](evidence/redmine-rollback-check.json) remain historical evidence.

Only our function-registration feature, typed List outputs, direct-call optimization and their tests/examples were carried across. The user also explicitly requested removal of the duplicate parser root `com.act21.rule.engine.dsl.expressions.parent`; its 51 tracked files are deleted in the new parser branch. The active singular `com.act21.rule.engine.dsl.expression.parent` remains.

The committed cleanup implements the user's explicit **direct-only** choice. `FunctionRegistry.invoke`, reflective execution/conversion and generated fallback expressions are removed. Missing bindings and unavailable direct calls now fail generation. The feature commits listed above include this cleanup and the coordinated version bump. Both checkout locations now contain these changes; local user edits remain uncommitted in the originals.

## What differs from the earlier architecture snapshot

Main uses a String-returning `TypeSystem.inferType`, a runtime `Type` class, and a grammar whose function return declaration is a qualified name. Redmine moved Type into the DSL module and changed several built-in conversions/linking rules. Those broad changes were not imported.

For custom functions on main, `RegisteredFunctionTypes.typeOf` reads full List element types from variable/parameter `TypeReference` nodes and the function registry. Synthetic function declarations contain the raw return name, while the registry supplies the full generic return type. The assignment converter, validator and generator use this metadata to enforce exact element types and generate `appendList`. Main's grammar, `TypeSystem`, runtime `Type`, `Utils`, `HelperFunctionModel.txt`, original engine tests and POM versions remain unchanged from main.

The Excel reader, colors, grid layout, matching policies and ordinary batch traversal are unchanged by this port. The earlier [architecture sections 3–5](ARCHITECTURE.md#3-architectural-blueprint) remain useful navigation for that shared engine structure. Treat the older parser/type/operator conclusions in sections 6 and 9 as redmine observations until checked against main's source. In particular, main's built-in header insertion does not acquire redmine's logical-parent handling. Custom calls remain explicit in either implementation.

## Code navigation

Engine prefix: `main-worktrees/rule-engine/src/main/java/com/act21/impaktapps/rule/engine/`.

Parser prefix: `main-worktrees/rule-engine-expression-parser/com.act21.rule.engine.dsl.expression.parent/`.

| Concern | Current location |
|---|---|
| Registration API and cached method metadata | DSL `expression/functions/FunctionRegistry.java` |
| Typed generated methods and binding the existing targets | DSL `expression/functions/FunctionCallBindings.java` |
| Main-compatible scalar/generic custom signature checks | DSL `expression/functions/RegisteredFunctionTypes.java` |
| Synthetic declarations and per-parser registry isolation | DSL `expression/util/InBuiltLibrary.java` |
| Built-in versus custom routing, output list helper | DSL `generator/ExpressionGenerator.xtend` |
| No implicit custom header | DSL `expression/converter/DecideExpressionConverter.xtend`, `linking/ExpressionLinkingService.java` |
| List-return preservation/type validation | DSL `expression/converter/AssignExpressionConverter.xtend`, `validation/ExpressionValidator.java` |
| Null-safe list append and self-append prevention | Runtime `expression/runtime/HelperFunctions.java` |
| Registry lifetime and cache | Engine `cache/GridFactory.java`, `api/RuleCreationRequest.java`, `compiler/Compiler.java` |
| Per-batch bindings and generated constructors | Engine `compiler/Generator.java`, `table/StatefulExpressionParser.java` |
| Saved grid coverage | `RegisteredFunctionsTest`, 39 XLSX files under engine `src/test/resources/registered-functions/` (38 loaded by that suite) |
| Direct-call behavior and unsupported-call rejection | `DirectFunctionCallsTest`, using the saved WidenLong workbook as a template in memory |

Read [the current walkthrough](FUNCTION_REGISTRATION_WALKTHROUGH.md) and [line ledger](FUNCTION_REGISTRATION_LINES.md) for the implementation. The `docs/history/REDMINE_*` copies preserve the previous explanations; their source line numbers are historical.

## Verification and reproduction

The current direct-only source run passed **69 tests: 35 unchanged main engine tests, 22 registration tests and 12 direct-call tests**, with no failures, errors or skips. See [current evidence](evidence/main-direct-only-check.json). Xtend was regenerated by the focused build using the previously regenerated main grammar. No generated parser Java was edited by hand. The earlier 66-test run remains historical evidence.

```powershell
python tools/generate_parser.py --workspace main-worktrees --output output/main-parser-generation --offline
python tools/registration_check.py --workspace main-worktrees --output output/main-direct-only-check --offline --test 'RegisteredFunctionsTest,DirectFunctionCallsTest,DecisionParserTests'
python tools/memory_map.py check
```

The saved direct-versus-registry benchmark describes the pre-cleanup implementation. Its script requires matching pre-cleanup source and build output; the direct-only API cannot execute the legacy comparison path.

The generator tool uses staging and copies only generated outputs back, preserving tracked Eclipse metadata. Its dependency resolution uses the Xtext 2.28 BOM; initial setup failures and successful logs are retained under `output/main-parser-generation`. The full Tycho/UI release reactor remains unverified. Versions are now 13.0.94/1.0.44; no Maven artifacts were published. The version metadata was checked after the passing source test run; Java/Xtend implementation bytes are unchanged.

`docs/WORKSPACE.json` selects the two active worktrees for memory indexing; business examples remain under `Grid-3.0`. Previous redmine indexes are under `docs/evidence/redmine-before-main/`. Root tools/docs are outside both Git repositories.
