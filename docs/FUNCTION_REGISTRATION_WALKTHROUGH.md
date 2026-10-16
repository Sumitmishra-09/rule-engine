# Plain Java function registration and direct calls

Current implementation: 16 October 2026, main-based `feature/registered-functions-direct-calls` in both repositories. See [checkout locations and main differences](MAIN_BRANCH_MAP.md). The earlier redmine walkthrough is preserved under `docs/history/REDMINE_FUNCTION_REGISTRATION_WALKTHROUGH.md`.

## Application usage stays the same

```java
DateFunctions target = new DateFunctions();
FunctionRegistry functions = FunctionRegistry.builder()
    .register("diffMonth", target, "diffMonth", Date.class, Date.class)
    .build();
GridFactory factory = new GridFactory(functions);
Rule rule = factory.get(gridIdentifier, this::createGridRequest);
rule.execute(entity, statistics);
```

The first line creates your application object; its constructor may receive services. Registration resolves the exact public method and retains this same object. The alias may differ from the Java method name. `build()` freezes a snapshot; later builder changes cannot alter it. The factory retains one registry for all its grids. Individual grid requests are unchanged. Keep the factory and compiled rule outside the fact-processing loop.

Use `registerStatic(alias, Owner.class, methodName, parameterClasses...)` for static methods. Register `String...` using `String[].class`; Excel supplies separate arguments. Application initialization can be plain Java or called from Spring. New supported functions require application deployment after this initial library upgrade; they do not require subsequent engine/parser source changes.

Custom arguments are **always explicit**. Under a blue months field, write `diffMonth(endDate,startDate)`. For a condition, write `diffMonth(endDate,startDate) >= 6`, or a registered Boolean call such as `positive(number)`. A custom call never receives the yellow header automatically, including inside NOT, AND/OR, parentheses or another function. Blue headers still select the destination. Built-in shorthand retains main's existing behavior.

## What executes now

Previously a custom cell emitted:

```java
((Long) registeredFunctions.invoke("diffMonth",
    new Object[]{requestData.getEndDate(), requestData.getStartDate()}))
```

Custom functions now require an accessible application class and emit a typed bridge call. The user explicitly selected direct-only execution on 16 October 2026; the previous `invoke` API and reflection fallback shown above have been removed:

```java
__gridFunction0(requestData.getEndDate(), requestData.getStartDate())
```

The generated rule binds the existing target in its constructor and includes a method equivalent to:

```java
private final com.example.DateFunctions __gridFunctionTarget0;

// Inside the generated constructor:
this.__gridFunctionTarget0 = (com.example.DateFunctions)
    registeredFunctions.getDefinition("diffMonth").getTarget();

private Long __gridFunction0(Date arg0, Date arg1) {
    Date value0 = arg0;
    Date value1 = arg1;
    try {
        return __gridFunctionTarget0.diffMonth((Date) value0, (Date) value1);
    } catch (Error failure) {
        throw failure;
    } catch (Throwable failure) {
        throw new IllegalStateException("Function diffMonth failed", failure);
    }
}
```

The field preserves object identity. The constructor resolves the alias once for this generated instance. The bridge receives each argument value once, in Java's left-to-right evaluation order. Its local values perform any required widening or primitive-null checks. Exact Java casts ensure the registered overload is selected. The call itself is an ordinary Java invocation. Errors propagate unchanged; other function failures retain the original cause and alias. The engine's existing outer wrapper adds grid/version/last-cell information. Checked Java exceptions can therefore be registered too.

There is no per-call alias lookup, reflection or generic Object array on this direct path. Java varargs still need a typed tail array; boxing and the function's own allocations may remain. A small private bridge gives the JVM an inlining opportunity; it is not a guarantee that every call will be inlined.

## Source walkthrough

Paths below are relative to the active worktrees. The [line ledger](FUNCTION_REGISTRATION_LINES.md) links the exact current source lines for the complete feature and lists the explicit duplicate-root removal separately.

1. **Parser DSL: `expression/functions/FunctionRegistry.java`.** The immutable definitions still retain alias, target, reflected method and DSL signature. `javaParameterTypes` now caches the actual parameter classes at registration. The new getters expose target, declaring class, method name, static status and scalar parameter class. Varargs expose their component type. No mutable reflection Method is exposed. Reflection is used to inspect the method during registration, not invoke it during rule execution. The public/private `invoke` methods, reflective argument packing and runtime conversion helper were removed. Conversions and exception handling now live in generated wrappers only.

2. **Parser DSL: `expression/functions/RegisteredFunctionTypes.java`.** `argumentTypes` describes supplied arguments. `typeOf` follows arguments, parentheses, field references and qualified calls; variables/parameters retain their generic TypeReference metadata. For custom return values it finds the parser's registry and reads the full return descriptor. Other expressions use main's unchanged String-based TypeSystem. `isListType` and `describe` support exact List result checks. This avoids importing redmine's type-system relocation and grammar changes.

3. **Parser DSL: `expression/util/InBuiltLibrary.java`.** Each parser owns its declaration maps and registry. Synthetic custom declarations belong to DSL class `RegisteredFunctions`, while built-ins belong to `HelperFunctions`. Main's grammar permits raw return names, so a custom List return is declared as `java.util.List` and its element type stays in registry metadata. Resource-set lookup prevents retained EMF validators from using another application's registry, including when validating detached expression copies.

4. **Engine: `compiler/Generator.java`.** Each `generate` call creates one `FunctionCallBindings` for the batch using the compiler's context class loader. Every horizontal condition, vertical condition and output passes this same object through `StatefulExpressionParser.generateCode`. After all cells are generated, the class receives only the fields and bridge methods it actually uses. Its registry constructor assigns the registry and binds those target fields. Subsequent batch objects still receive that registry. No registration is repeated per request or batch.

5. **Engine: `table/StatefulExpressionParser.java`.** The new three-argument `generateCode(cell, request, bindings)` puts the binding session in GeneratorContext's additional-data map. The old two-argument overload delegates with no session and remains available for built-in-only snippets. Custom snippets must use the three-argument overload and supply bindings. The runtime ExpressionParser keeps its legacy constructor and adds a registry-aware constructor. RuleCreationRequest creates a fresh registry-aware parser for compilation; direct legacy access remains lazy and built-in-only.

6. **Parser DSL: `generator/ExpressionGenerator.xtend`.** Both `compileElementReferenceExpression` and `compileFeatureCall` first ask `getRegisteredFunction` about the resolved declaration. A custom call goes to `compileRegisteredFunction`; an ordinary helper goes through the existing owner/name path, such as `HelperFunctions.max`. Classification happens during grid compilation, not during execution, and uses the DSL declaration owner rather than a function-name string test. Nested arguments recursively choose their own routes. `compileRegisteredFunction` requires a binding session, infers/compiles its arguments and delegates to `compileCall`, which validates their signature before generation. The duplicate generation-time validation/inference was removed. With no session, custom generation throws a function-specific error instead of producing an invocation snippet.

7. **Parser DSL: `expression/functions/FunctionCallBindings.java`.** `compileCall` validates the signature and requires direct-call eligibility. It caches a bridge by alias plus inferred argument types/arity, and retains a target field per used instance-function definition. `directCallProblem` checks a named public declaring class and all enclosing classes, an exported package, matching class identity through the compilation loader, and available class bytecode. Null/incompatible loaders, inaccessible owners, unavailable bytecode and calls requiring more than 254 bridge parameters fail generation with a reason naming the function. Only supported declared scalar/List parameter types occur here. Public inherited declarations can bind a non-public subclass through the public declaring type. If the declaring type itself cannot satisfy the compiler checks, generation fails; there is no fallback.

8. **`FunctionCallBindings.appendMethod`.** Boxed bridge parameters preserve nullable input fields. Integer-to-Long and Integer/Long-to-BigDecimal conversions keep null for reference parameters. Primitive parameters reject null before entering the function-failure try/catch, preserving the earlier conversion error. Fixed arguments are cast to the exact registered Java types; varargs are packed into one correctly typed array. Static methods name the declaring class directly and need no target field. `declarations` emits fields/methods; `initializers` reads each retained target during construction.

9. **Custom linking/validation and list output.** The custom branch in ExpressionLinkingService validates argument counts/types before the existing built-in header logic. Qualified calls receive an additional ExpressionValidator check. DecideExpressionConverter returns custom Boolean calls without inserting a header. AssignExpressionConverter preserves List expressions. Both ExpressionValidator and ExpressionGenerator compare full generic result/destination types, so disabling grid validation does not allow a List type mismatch through generation.

## Compatibility and List behavior

The direct-only cleanup intentionally removes the public `FunctionRegistry.invoke` API and standalone custom generation without bindings. The ordinary GridFactory path already provides bindings. Direct-call eligibility is checked for functions actually used by a grid, so an unused registered function does not block other grids.

Supported Java scalars remain Integer/int, Long/long, Boolean/boolean, String, BigDecimal and java.util.Date. Parameters/results may be exactly `List<supported scalar reference type>`. Raw/wildcard/nested lists, arbitrary objects, double and void remain unsupported. Custom aliases cannot replace built-ins/reserved DSL names; each alias selects one signature.

Scalar widening is limited to Integer to Long and Integer/Long to BigDecimal. Lists require exactly matching element types. Reference nulls reach your function; null literals are rejected for primitive parameters during validation, and nullable field values are checked at runtime. The function defines its own date/timezone and reference-null policy.

For a blue `List<String> values` output and `getCodes()`, the generated setter is equivalent to:

```java
requestData.setValues(HelperFunctions.appendList(
    requestData.getValues(), __gridFunction0()));
```

`appendList` initializes a null destination with an ArrayList, appends a non-null different result, and skips self-append when a function mutates and returns the destination itself. Existing destinations must be mutable. Empty/null results add no elements. Scalar/array appends retain main's existing `addAll` behavior. This helper is internal and is not a new Excel built-in.

The default GridFactory and parser constructors still work for existing built-in grids. Custom generated classes should be constructed through GridFactory/Compiler with their registry; the generated zero-argument constructor is for built-in-only use. Each factory keeps its own cache and targets; update the grid version when workbook/schema/options change. Custom functions and their shared target objects must support the application's concurrency. Facts, output lists and statistics remain per execution.

## Scope and verification

All **69 current-source tests passed** after cleanup: 35 unchanged engine tests, 22 registration tests and 12 direct-call tests; see [evidence](evidence/main-direct-only-check.json). Coverage includes real saved Excel files, nested/qualified functions, dates, static/instance aliases, overload selection, primitive nulls, widening, varargs, checked exceptions, Error identity, target identity, list append/clear-and-return, multiple batches, cache/factory isolation, concurrent compilation, and inaccessible-owner/class-loader rejection, unavailable class bytecode, missing bindings and the generated-argument limit. A built-in snippet still generates without bindings. The new tests inspect generated source to verify direct invocation and absence of generic argument arrays for fixed-arity calls.

The registration fixtures remain under engine `src/test/resources/registered-functions`. `Dates3` is the grid name, `Dates-3.xlsx` is its file, and the expected result is 38. The user's separate Dates.xlsx experiment and test edits were preserved. `CleanAndGetCodes.xlsx` covers clear-and-return without duplicate self-append. The negative-function test prints captured validation details; an expected ParsingException does not mean that test failed. The compile helper extracts source compiler diagnostics in addition to the generic wrapper message.

The exact build and benchmark commands are in [MAIN_BRANCH_MAP.md](MAIN_BRANCH_MAP.md). Full Tycho/UI release verification remains outstanding. The feature commits now use engine 13.0.94 and parser/runtime 1.0.44, with matching engine dependency and parser module/bundle versions. No Maven artifacts were published; build/publish the matching parser/runtime artifacts before deploying the engine. See [version/push evidence](evidence/direct-only-version-push-check.json). Eclipse must regenerate/build the parser and resolve the updated runtime/DSL outputs before running the engine tests.

Batch-instance reuse was not added: later batches are still constructed during execute, so their target binding occurs when each batch instance is constructed. The first cached rule binds once. Grid result memoization is not safe by default because facts/lists/custom targets can be mutable.

## Performance evidence

The earlier tiny-function experiment compared registry/reflection/typed handles/direct calls; it is historical call-overhead evidence only. See [its metadata](evidence/function-invocation-performance.json). The pre-cleanup full-grid benchmark uses real generated MATCH_ALL grids with 1 or 100 PASS rows and a small add function. Compilation is outside timing. Both paths used the then-current registry metadata, so cached parameter classes benefit the comparison path too. It measures repeated execution, matching, output assignment and statistics with thread-owned fact/statistics objects. The main-based run completed with two forks, three one-second warmups and three one-second measurements per case, JDK 17.0.9, one thread and the GC profiler:

| Grid rows | Direct ns/execution | Registry ns/execution | Direct bytes/execution | Registry bytes/execution |
|---|---:|---:|---:|---:|
| 1 | 38.0 | 96.5 | 72 | 120 |
| 100 | 8,085 | 16,892 | 2,481 | 7,281 |

These are local averages with timing variation, simple functions and one generated batch; no concurrent or business-workbook throughput claim follows. [Metadata and confidence errors](evidence/main-direct-grid-performance.json), [raw JMH](evidence/main-direct-grid-jmh.json), [benchmark source](../tools/DirectGridBenchmark.java).

The historical direct-versus-registry benchmark requires the earlier registry API and matching builds. Its script now rejects direct-only workspaces with an explanatory message; saved results describe the pre-cleanup implementation.
