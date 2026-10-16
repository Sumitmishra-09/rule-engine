> Historical redmine documentation saved before the main port. Paths/line numbers describe that earlier snapshot; use ../MEMORY_MAP.md for active code.

# Plain Java function registration

Implementation review, 15 October 2026. The user chose **explicit arguments for every custom function**. Register once during application initialization, retain one `GridFactory`, and reuse it for all grids. No Spring integration is required. These are local source changes, not a published engine/parser release.

## Application code, line by line

```java
DateFunctions dateFunctions = new DateFunctions();                       // 1
FunctionRegistry functions = FunctionRegistry.builder()                 // 2
    .register("diffMonth", dateFunctions, "diffMonth",                   // 3
              Date.class, Date.class)                                  // 4
    .build();                                                          // 5
GridFactory factory = new GridFactory(functions);                       // 6
Rule rule = factory.get(gridIdentifier, this::createGridRequest);        // 7
rule.execute(entity, statistics);                                       // 8
```

1. The application creates its ordinary Java function object. Its constructor can receive any application services it needs.
2. Create a registration builder. Import `com.act21.rule.engine.dsl.expression.functions.FunctionRegistry`.
3. Bind the Excel name `diffMonth` to the public Java method `diffMonth` on this object. They may have different names. No method is called during registration.
4. Select the exact Java overload with two `java.util.Date` parameters. The registry reads the method's return type, so it is not separately supplied.
5. Freeze a snapshot of the registered names, signatures, methods and target objects. Further changes to this builder do not change that registry.
6. Give the application-level registry to a retained factory. Each factory owns its own cache. The zero-argument factory constructor remains available for built-ins only.
7. Build or retrieve any grid using the existing request-builder callback. Its workbook, schema, match policy and other settings remain per grid. There is no registry option to repeat on each request.
8. Execute using the existing API. Arguments are read from this entity on each invocation; registration does not capture entity values.

For a public static method, use `registerStatic("nameInExcel", Owner.class, "methodName", Parameter.class, ...)`. For a Java varargs method such as `join(String... values)`, select it with `String[].class` at registration; Excel supplies individual arguments. Zero-argument functions are called with `()`.

An application-owned date implementation can be:

```java
public class DateFunctions {
    public Long diffMonth(Date later, Date earlier) {
        LocalDate end = later.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
        LocalDate start = earlier.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
        return ChronoUnit.MONTHS.between(start, end);
    }
}
```

This example chooses complete months and UTC, with first date minus second date. Business timezone, month-boundary rules and null policy belong to the application's function implementation. The registry does not prescribe them. `Date`, `LocalDate`, `ZoneOffset`, and `ChronoUnit` are standard Java imports.

## Excel arguments and header semantics

| Cell | Meaning |
|---|---|
| Blue `monthsWorked`: `diffMonth(endDate, startDate)` | Calls with the two supplied dates and assigns the result to `monthsWorked`. |
| Yellow condition: `diffMonth(endDate, startDate) >= 6` | Calls with the two supplied dates and uses the explicit comparison as the predicate. |
| Yellow condition: `positive(number)` | Passes only `number`; uses the Boolean result directly. |
| Yellow condition: `!positive(number)` | Passes only `number`; negates its Boolean result. |
| Yellow condition: `positive(number) && positive(otherNumber)` | Each call gets its own explicitly supplied field. |
| Nested: `twice(diffMonth(endDate, startDate))` | The inner result becomes the outer function's supplied argument. |
| Qualified: `RegisteredFunctions.positive(number)` | Same custom-function behavior using its internal namespace explicitly. |

There is no automatic first argument and no custom-function header mode. Write the yellow-header field explicitly if the function needs it. A non-Boolean function used by itself under a yellow header still participates in the existing decision-table value-comparison semantics; write a complete Boolean comparison when that is what you intend. Blue headers still choose the output field. Existing built-in `contains`/`in` header shorthand is unchanged.

Only explicitly registered public methods are exposed. Supported scalar method types are `Integer`, `Long`, `Boolean`, `String`, `BigDecimal`, and `java.util.Date`; Java method types `int`, `long`, and `boolean` normalize to their wrappers. Typed `List<T>` parameters and return values are supported when `T` is one of these scalar reference types. Raw lists, arbitrary objects, `void`, `double`, wildcards and nested generic types are rejected during registration. List-valued outputs append elements using `HelperFunctions.appendList`; matching generic element types are required.

Integer-to-Long and Integer/Long-to-BigDecimal widening are supported consistently in validation and invocation. There is no implicit narrowing or conversion to String. A null literal is accepted for reference parameters and rejected for primitive parameters. A nullable entity field passed to a primitive parameter is checked at invocation. Null reference handling inside a method is the application's responsibility.

Names must be ordinary ASCII DSL identifiers and cannot replace built-ins or reserved DSL words. There is one custom signature per registered name; different aliases can expose different Java overloads. A field and function may share a name: `decimal` refers to the field, while `decimal(...)` selects the registered function.

## Source changes in execution order

Source links below point to the current working tree. The [detailed line ledger](FUNCTION_REGISTRATION_LINES.md) accompanying this document records each added or replaced source line; blank lines and braces are structural, not extra behavior.

### 1. Registration: FunctionRegistry.java

Location: parser DSL module, `src/com/act21/rule/engine/dsl/expression/functions/FunctionRegistry.java`.

| Lines | Explanation |
|---|---|
| 1, 3-18 | Declare the public API package and import only JDK reflection, numeric, date and collection types. The registry itself has no Spring, Xtext or engine dependency. |
| 20-25 | Document application ownership, explicit arguments and concurrency expectations; prevent subclassing the immutable registry. |
| 26 | Give generated DSL declarations the namespace `RegisteredFunctions`. |
| 27 | Retain one empty immutable registry for backward-compatible constructors. |
| 28-31 | Reserve existing helper names, grammar words and model namespaces. |
| 32, 34-35 | Store a private defensive map copy wrapped as unmodifiable. Target objects are retained by reference. |
| 38-43 | Expose the empty registry and a new builder. |
| 46-55 | Expose read-only signature metadata and fail clearly when an invocation names an unregistered function. |
| 58-60 | Dispatch by registered name using the stored definition; reject a null argument-array object. |
| 63-64 | Keep mutable registration state only inside the builder. |
| 66-68 | Require an instance target and use its public class API to resolve the requested method. |
| 71-72 | Offer static registration with an owner class and no target instance. |
| 75-82 | Validate the alias and reject duplicate names before modifying the builder. |
| 83-88 | Resolve the exact public Java method once; verify instance/static mode and accessibility without bypassing Java access checks. |
| 89-90 | Construct validated immutable metadata, insert it, and return the builder for chaining. |
| 91-92 | Explain a missing method/overload as a registration error with the original exception attached. |
| 96-98 | Create an immutable snapshot; the builder can later produce a separate snapshot. |
| 102-108 | Each definition retains its alias, target, Method, parameter descriptors, and return descriptor. |
| 110-115 | Save the binding and inspect generic Java parameter types. |
| 116-120 | Translate fixed parameters directly; for varargs translate the array element type used by each Excel argument. |
| 121-122 | Freeze parameter metadata and validate the scalar or typed List return descriptor. |
| 125-138 | Read-only accessors expose names, signatures and whether the Java method uses varargs. |
| 141-142 | Count required fixed arguments, excluding the trailing varargs array. |
| 145-148 | Reject incorrect argument counts. A pure varargs function can receive zero arguments. |
| 153-159 | Validate the inferred argument types; arguments beyond the fixed prefix use the final varargs parameter descriptor. |
| 160-164 | Accept exact matches, nullable reference arguments, and the two supported numeric widening paths. |
| 165-167 | Report the function name, one-based argument position, expected type and inferred type on a mismatch. |
| 172-174 | Recover the actual Java parameter class, or the varargs component class, for invocation and primitive-null checks. |
| 177-182 | Recheck arity and convert the fixed values into the method's Java invocation array. |
| 183-189 | Allocate a correctly typed trailing array, convert its values, and put that array into the final Java parameter slot. |
| 191-192 | Invoke the previously resolved method on the retained instance (or null for static methods). |
| 193-198 | Unwrap reflection's wrapper exception. Preserve fatal Java Errors; attach ordinary function failures as the cause of a named runtime exception. |
| 199-200 | Explain an unexpected access failure with the function name. |
| 204-211 | Normalize primitive target classes and accept null references or already compatible runtime values. |
| 212-216 | Perform the same numeric widening accepted by validation. |
| 218-219 | Reject incompatible runtime arguments, including null for primitives. |
| 223-227 | Map the supported Java primitives to their wrapper classes. |
| 230-236 | Translate supported scalar Java classes into DSL type names. |
| 237-241 | Translate exactly `List<supported scalar>` metadata, preserving its element type. |
| 244 | Reject every other signature type immediately. |

### 2. Factory and request lifecycle

`rule-engine/src/main/java/com/act21/impaktapps/rule/engine/cache/GridFactory.java` adds a final registry field, a delegating no-argument constructor, a constructor accepting the registry, and one extra argument to `Compiler.getRule`. Cache keys remain grid name/version **within that factory**. A cache hit does not invoke the request callback or open a workbook stream.

`api/RuleCreationRequest.java` captures restricted characters as request-owned data and delays parser creation. `forCompilation(functions)` makes a compilation copy with the factory's registry installed in a fresh parser. This avoids mutating the caller's request or creating a throwaway built-in-only parser for every request. The existing `getExpressionParser()` lazily creates a built-in parser for direct legacy callers. Capturing the character set also removes the previous accidental sharing of a mutable default set between builders; later builder changes cannot change an already built request.

`table/StatefulExpressionParser.java` keeps its existing constructor and adds an overload receiving the registry. Its schema-to-variable conversion is unchanged. It passes the registry into the runtime parser constructor. The existing cell conversion remains `if header: condition` or `assign header: value`.

`compiler/Compiler.java` keeps `getRule(request)` and delegates it to an overload with an empty registry. The new overload validates the registry and creates the compilation copy inside the stream's try-with-resources block, so initialization failures also close the workbook stream. After Java compilation it finds the entry batch by class name, rather than assuming the compiler's result collection iteration order, then invokes the constructor accepting `FunctionRegistry`.

### 3. Loading function signatures

Runtime `ExpressionParser.java` retains the old constructor and adds the registry overload. Initialization loads the schema first and then calls `builtInLibrary.initialize(resourceSet, functions)`. The user's existing experimental `main` method was preserved.

DSL `InBuiltLibrary.java` changes its static declaration maps to instance maps. Initialization attaches that library to its own resource set. `loadRegisteredFunctions()` writes a small in-memory DSL class using each definition's validated name, parameter descriptors, varargs marker and return descriptor. It assigns a unique resource URI and loads UTF-8 text into the same resource set as the entity schema. No Java implementation is stored in the expression text and no declaration file must be edited for each function.

`getRegisteredFunction(declaration)` distinguishes a custom function by its owning DSL class and gets the binding through the declaration's resource set. `forContext(...)` first checks a node's resource set. For detached validation copies, it follows the retained schema or function reference. This matters because EMF may reuse a validator from another injector. The added context-aware class/function lookup overloads keep built-in conversions isolated as well.

`RuleEngineImportedNamespaceAwareLocalScopeProvider.java` adds the `RegisteredFunctions.*` implicit import so Excel can use short names. `META-INF/MANIFEST.MF` exports the new Java API package for Eclipse/OSGi consumers.

### 4. Linking and validation

`RegisteredFunctionTypes.java` is the small Xtext-to-Java adapter. Lines 14-16 infer the type of every supplied argument and call the definition's shared checker. Lines 19-23 format scalar or generic descriptors; an unresolved type becomes `unknown`, which cannot silently satisfy a registered signature.

`ExpressionLinkingService.java` looks for custom function declarations when the syntax is an operation call. It checks the custom class before ordinary imported scopes, which prevents a same-named schema field hiding a function call. In overload matching, custom declarations take the registry's type/arity path and return before the old implicit-header logic. Built-ins continue through their previous path.

`ExpressionValidator.java` adds a check for qualified custom calls. Unqualified operation calls are checked by the linker. Qualified calls use the generic feature linker, so the extra check ensures `RegisteredFunctions.fn(...)` gets the same argument checks and visible validation issues. Code generation checks the signature again for callers that disable grid validation.

### 5. Decision conversion and Java generation

`DecideExpressionConverter.xtend` adds an early return for a custom Boolean call, in both unqualified and qualified branches. It returns that predicate unchanged, before the existing header insertion. A custom non-Boolean result still follows the ordinary value-comparison rules. Its synthesized built-in `in` calls now locate the library using the header's schema context.

`AssignExpressionConverter.xtend` changes the two helper lookups in collection append conversion to use the header's schema context. It now preserves expressions whose inferred type is List, allowing validation to compare the full generic result and destination types instead of treating the returned list as one scalar element. `TypeCastHandler.xtend` captures the correct library before reparenting the expression into a conversion call and then resolves its conversion helpers through that library. These changes preserve existing conversions while avoiding stale validator-owned declarations.

`ExpressionGenerator.xtend` detects a registered declaration before the old static-helper generation path, for both short and qualified calls. It requires call parentheses and delegates to `compileRegisteredFunction`. That method checks arguments, recursively emits each supplied expression, joins them into an `Object[]`, and casts the dispatcher result to the function's declared scalar or typed List return type. For example:

```java
((java.lang.Long) registeredFunctions.invoke("diffMonth", new Object[]{
    requestData.getEndDate(), requestData.getStartDate()
}))
```

`compiler/Generator.java` emits the registry field and constructors in each Java rule class. The default constructor delegates to the empty registry; the injection constructor retains the supplied registry. Every next-batch construction passes that same field. The `Rule.execute(Object, RuleStatistics)` signature remains unchanged, and existing runtime error wrapping still adds the grid/version/last-cell context around a custom function exception.

For a blue List<String> header `values` and cell `getCodes()`, the expression generator now emits the equivalent of:

```java
requestData.setValues(HelperFunctions.appendList(
    requestData.getValues(),
    (java.util.List<String>) registeredFunctions.invoke("getCodes", new Object[]{})));
```

`HelperFunctions.appendList` creates an ArrayList when the destination is null, appends the returned elements when the result is non-null and is a different object, then returns the destination. Existing destinations must be mutable. A null/empty result adds nothing. Returning the same list after `cleanAndGetCodes(values)` clears and repopulates it skips self-append, preserving the identity and avoiding duplicate entries. This helper is generated internally and is not added to `HelperFunctionModel.txt` as a callable Excel built-in. The generator checks exact List element-type equality even with `doValidate=false`; scalar/array append still uses the original `addAll` helper. List returns also work as arguments, for example `size(getCodes())`.

## Verification and delivery

`RegisteredFunctionsTest.java` loads 38 saved yellow/blue XLSX fixtures from `rule-engine/src/test/resources/registered-functions`, compiles them through `GridFactory`, and executes the resulting Java rules. These replace the original in-memory workbook construction. There are now 39 files: `Dates-3.xlsx` replaces `Dates.xlsx` in the active date test, while the user's edited original remains an experiment. The [fixture guide](../rule-engine/src/test/resources/registered-functions/README.md) lists each workbook, its inputs and expected result; nine deliberately invalid examples are under `invalid/`. Coverage includes dates, nesting, static/instance methods, explicit Boolean arguments, qualified calls, zero arguments, varargs, numeric widening, typed list parameters/results, append and clear-and-return behavior, invalid calls, nulls, repeated grids, cache hits, isolated applications, concurrent compilation with different signatures, multiple batches, error causes and built-in compatibility. `RegisteredFunctionFact.java` provides the public entity/getters/setters required by generated Java. A missing workbook fails the test instead of being accepted as an expected parsing failure.

The user's `Dates-3.xlsx` calls `twice(diffMonth(endDate,toDate("15/01/2025")))`, with their registered `toDate(String)` implementation. The corrected test uses `compile(factory, "Dates3", "Dates-3", 300)`: the Java grid name and filename are separate. Passing the hyphenated name as the grid name was reproduced as invalid generated Java `public class Dates-31`, with a compiler `'{' expected` diagnostic. The helper now extracts `CompilationException.getErrorSources()` and `getErrorMessage(source)` into its failure message; the dependency's ordinary exception text contains only error counts. January 2025 to August 2026 is 19 complete months, so the new expected output is 38. The original date-field-only expression expected 14.

`tools/registration_check.py` is a reproducible focused build. It stages exact copies of the current DSL/runtime/engine sources under `output/function-registration`, runs the real Xtend 2.28 compiler there, compiles Java, and runs the requested engine JUnit tests. It uses the existing generated Xtext grammar artifacts because the grammar was not changed. It never manually edits generated Java. This check is separate from the full Eclipse/Tycho release reactor.

Run from the containing workspace root:

```powershell
python tools/registration_check.py --offline --test 'RegisteredFunctionsTest,DecisionParserTests'
```

On 15 October 2026, **59 tests passed: 44 existing engine tests and 15 new registration tests, with zero failures/errors/skips**. See the [test summary](evidence/registration-check.txt), [case-by-case evidence](evidence/registration-check.json), and [original build log](../output/function-registration/registration-original-build.log). After moving the workbooks into resources, all 15 registration tests passed again using the saved XLSX files; see [fixture hashes and test evidence](evidence/registration-fixtures-check.json) and the [saved-fixture build log](../output/function-registration/registration-fixtures-build.log). These historical workbook hashes precede the user's date-workbook edits. The original 44 engine tests were not repeated for the fixture-only change. The original Tycho reactor attempt is logged under `output/registration-parser-build.log`; that attempt stopped while resolving Tycho's OSGi runtime dependencies, before compilation/tests.

No Maven versions were bumped and no artifacts were published. Before distributing this extension, publish coordinated new parser/runtime and engine versions and update the engine's parser dependency. Do not overwrite the existing 1.0.43/13.0.93 releases. Once that initial upgrade is installed, future functions using the supported signatures need only a scheme application deployment and registration during initialization.

The later Dates-3 follow-up reproduced the Java name error, then passed all 15 registration tests with output 38 and compiler-diagnostic extraction in the test helper. See [reproduction and verification evidence](evidence/date-grid-check.json). The user's workbook contents and toDate implementation were preserved.

The latest list-return follow-up passed **44 existing engine tests and 22 registration tests** across two commands. Seven new tests use ten new workbooks to exercise list appends, existing/null destinations, repeated execution, qualified calls, same-instance clear-and-return, empty/null results, nested calls, Long lists, generated batches, and rejected output types with validation enabled/disabled. The initial combined run passed all 44 existing tests but exposed an incorrect exception-wrapper expectation in one new test; correcting only that assertion/import produced a passing 22-test registration rerun. See [source, workbook and test evidence](evidence/list-return-check.json). The date test remains a passing `Dates3` grid loading `Dates-3.xlsx`.

### Eclipse reports that appendList cannot be found

On the same day, an Eclipse JUnit launch reported generated `CleanAndGetCodes1` calling `HelperFunctions.appendList` while the compiler could not find that method. This indicates the helper available to that compilation did not expose the new method. Subsequent inspection found the current runtime source and Eclipse `target/classes/HelperFunctions.class` both contain it, and m2e workspace resolution points runtime 1.0.43 to that output directory. The two newly regenerated Xtend Java files also match the focused-build output exactly.

The existing Eclipse-compiled `cleanAndGetCodesDoesNotAppendTheSameListTwice` passed when invoked with the engine test/main, runtime and DSL output directories plus dependencies from the saved focused-test report. The probe printed the runtime output as the helper's origin and found only one helper resource. This was an explicit-classpath probe, not a reproduction of the earlier Eclipse launch: its exact failed classpath was not captured. Stale build state or a different launch classpath remains the diagnosis, without claiming a particular old JAR was selected. [Probe evidence](evidence/runtime-classpath-check.json), [probe log](../output/runtime-classpath-probe.log).

For an Eclipse rerun, refresh the three projects, clean/build the parser DSL, runtime and engine projects, wait for builds to finish, then launch a new JUnit run. If the missing method persists, inspect `HelperFunctions.class.getProtectionDomain().getCodeSource().getLocation()` and `HelperFunctions.class.getMethod("appendList", java.util.List.class, java.util.List.class)` in that test JVM; enumerate the helper class resources to find duplicates. The runtime dependency must resolve to the updated workspace output or a newly built coordinated artifact. No production code or Eclipse configuration was changed in this diagnostic follow-up.

### Seeing the complete error in the invalid-function test

`wrongNamesCountsAndTypesFailDuringGridCompilation` deliberately rejects seven invalid workbooks. `ParsingException` stores details in `getValidationMessage()` rather than its ordinary exception message. The test's `compile(...)` helper extracts cell references/descriptions into an `IllegalStateException`, but its earlier `printStackTrace()` prints only the original exception. Previously, `assertThrows(...)` consumed the new detailed exception without displaying it. The test now captures that returned exception and prints `Expected validation failure: ` followed by its full message for each workbook. The expected errors still mean the negative test passes. This is a test-output change; production exception types and validation behavior are unchanged. The user's commented identity assertion and code-printing experiment in the clear-and-return test remain intact.

The focused run of this one test passed across all seven invalid workbooks. [Stored validation messages](evidence/invalid-function-diagnostics.txt) show the exact output, and [verification evidence](evidence/invalid-function-diagnostics-check.json) records the command and hashes. The unknown-function fixture supplies one empty description followed by a conversion diagnostic; this follow-up displays the existing diagnostics without rewriting their parser-side content.

### Performance and dispatch review, 16 October 2026

No production optimization has been implemented. Reflection lookup (`owner.getMethod`) happens once at registration. The current generated custom call constructs an Object array and invokes `FunctionRegistry.invoke(alias, arguments)`. Each invocation looks up its Definition, checks arity, constructs a second packed argument array, reads parameter metadata/converts arguments, packs Java varargs if needed, and calls the retained `Method.invoke`. The JIT may eliminate some allocations, so source-level allocation expressions alone do not establish actual allocation rates. Grid parsing/Xtext generation/Java compilation happen on a factory cache miss; ordinary repeated `Rule.execute` calls do not reparse cells.

Function classification also happens during generation. `InBuiltLibrary.loadRegisteredFunctions` builds synthetic DSL declarations inside class `RegisteredFunctions`; built-ins are declared inside `HelperFunctions`. `getRegisteredFunction` recognizes a resolved FunctionDeclaration whose containing DSL class is `RegisteredFunctions` and retrieves its Definition from the correct parser resource set. `ExpressionGenerator.compile` dispatches AST node kinds; both `compileElementReferenceExpression` (unqualified calls) and `compileFeatureCall` (qualified calls) check this classification first. Custom calls go through `compileRegisteredFunction`, which validates types and emits a cast around `registeredFunctions.invoke`. Other function declarations emit their owner/name directly, such as `HelperFunctions.max`. This DSL-class distinction is not the Java class of the application's target object. Nested arguments are recursively compiled, so each nested call selects its own route. List assignments separately wrap the generated value with direct `HelperFunctions.appendList`.

A short local JMH 1.35 experiment compiled the actual registry source with JDK 17.0.9 and compared one public instance `Long add(Long,Long)` using rotating preallocated inputs. Two forks each used three 500 ms warmups and three 500 ms measurement iterations, one thread, 256 MB heap and the GC profiler. These are exploratory call-overhead measurements, not grid throughput results; values below are rounded means and include the boxed result:

| Invocation path | ns/call | bytes/call |
|---|---:|---:|
| Current registry | 76.2 | 120 |
| Cached Method.invoke without registry packing/conversion | 16.6 | 48 |
| Bound MethodHandle.invokeExact | 7.8 | 24 |
| Direct Java call | 4.9 | 24 |
| Bound MethodHandle.invokeWithArguments | 215.5 | 248 |

See [metadata, limitations and source hashes](evidence/function-invocation-performance.json), [raw JMH results](evidence/function-invocation-jmh.json), [benchmark source](../output/function-performance/InvocationBenchmark.java), and [runner](../output/function-performance/run.py). Timing variation is material; the data is not a promised whole-grid speedup. The Python summary initially used the wrong GC-profiler key prefix; JMH itself completed and its saved results were read after correcting that post-processing.

The preferred optimization candidate for this Java-generating engine is to resolve registrations at initialization and emit direct typed calls to public, compiler-visible application methods. A typed, prebound MethodHandle is another candidate when directly naming the implementation is unsuitable. Avoid merely replacing Method.invoke with invokeWithArguments. Both designs must retain exact signature validation, supported numeric widening, primitive-null handling, target identity, factory isolation, varargs semantics and function/grid/cell exception context. Direct-call generation would require method/owner/target metadata from FunctionRegistry, target binding in engine Generator, and different invocation text in ExpressionGenerator; no new expression grammar is needed. Bind to the existing instance, not a newly constructed service. Benchmark complete warmed grids before selecting a default path.

Other source-derived candidates for large grids: retain the factory and compiled Rule outside fact loops, cache parameter metadata, avoid repeated lookup/packing, inspect per-execution batch construction (`Generator.java` line 121), and measure matching/output traversal and statistics allocations. Batch objects currently get created during execution; reusing immutable batch instances needs a separate state/concurrency review. Output lists/facts can be mutated, including by custom functions, so result memoization is not generally safe. Keep per-execution BitSets/statistics isolated. JMH and Java MethodHandle semantics are documented by [OpenJDK JMH](https://github.com/openjdk/jmh) and [Java SE 17 MethodHandle](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/invoke/MethodHandle.html).
