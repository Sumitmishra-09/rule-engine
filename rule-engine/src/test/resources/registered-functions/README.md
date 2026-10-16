# Registered function Excel examples

These workbooks support [RegisteredFunctionsTest](../../java/com/act21/impaktapps/rule/engine/test/RegisteredFunctionsTest.java). There are now 39 files: the original 28, the user's `Dates-3.xlsx`, and 10 list-return fixtures. The date test loads `Dates-3.xlsx`; the separately edited `Dates.xlsx` is retained as an experiment. Tests read the other 38 files from the classpath; they do not regenerate them.

Every workbook has one `Rules` sheet. Cell A1 is the yellow input header `text` (`FFFFFF00`); B1 is the blue output header (`FF00B0F0`). Custom calls explicitly name their arguments, so they can read fields other than the yellow header. `BuiltIn.xlsx` demonstrates the existing built-in header shorthand.

Use [RegisteredFunctionFact](../../java/com/act21/impaktapps/rule/engine/test/RegisteredFunctionFact.java) as the entity/schema. Its defaults are `text="abc"`, `number=6`, `smallNumber=2`, empty `values` (List<String>) and `numbers` (List<Long>) lists, and null dates/scalar outputs. Function implementations and registration are in `RegisteredFunctionsTest.Functions` and `registry(prefix)`; they are examples owned by the test application, not new built-in functions.

| Workbook | Cell expression(s) / purpose | Expected result and additional setup |
|---|---|---|
| [Dates-3.xlsx](Dates-3.xlsx) | Condition `diffMonth(endDate,startDate) >= 6`; output `twice(diffMonth(endDate,toDate("15/01/2025")))` | Use Java grid name `Dates3` and this separate fixture filename. With startDate=2026-01-15 and endDate=2026-08-15 at UTC midnight, `result=38` (19 complete months doubled). The user-added `toDate(String)` parses dd/MM/yyyy using the application's date formatter and default timezone. |
| [Dates.xlsx](Dates.xlsx) | User-edited output `twice(diffMonth(endDate,'2025-01-15'))` | Not used by the current date test. The quoted value is a String, while diffMonth requires Date; use an explicit date conversion as in Dates-3.xlsx. The original version of this file used startDate and produced 14. |
| [Predicate.xlsx](Predicate.xlsx) | `positive(number)` | `output="matched"` for number=6; no match for -1. |
| [PredicateParenthesized.xlsx](PredicateParenthesized.xlsx) | `(positive(number))` | Same predicate result. |
| [PredicateNegated.xlsx](PredicateNegated.xlsx) | `!positive(number)` | No match for 6; `output="matched"` for -1. |
| [PredicateAnd.xlsx](PredicateAnd.xlsx) | `positive(number) && positive(number)` | Match for 6; no match for -1. |
| [PredicateOr.xlsx](PredicateOr.xlsx) | `positive(number) \|\| positive(number)` | Match for 6; no match for -1. |
| [PredicateQualified.xlsx](PredicateQualified.xlsx) | `RegisteredFunctions.positive(number)` | Match for 6; no match for -1. |
| [BooleanOutput.xlsx](BooleanOutput.xlsx) | Output `RegisteredFunctions.positive(number)` | `flag=true`. |
| [Zero.xlsx](Zero.xlsx) | `constant()` | `result=42`. |
| [EmptyVarargs.xlsx](EmptyVarargs.xlsx) | `join()` | `output=""`. |
| [Varargs.xlsx](Varargs.xlsx) | `join(text,"x",tag(text))` | `output="abcxabc"` with empty tag prefix. |
| [WidenLong.xlsx](WidenLong.xlsx) | `twice(smallNumber)` | Integer argument widens to Long; `result=4`. |
| [WidenDecimal.xlsx](WidenDecimal.xlsx) | `decimal(100)` | Long literal widens to BigDecimal; `decimal=100`. |
| [ListArgument.xlsx](ListArgument.xlsx) | `size(values)` | `result=2` after setting values to `["a","b"]`. |
| [NullArgument.xlsx](NullArgument.xlsx) | `positive(null)` | `flag=false`; null reference reaches the function. |
| [Tag.xlsx](Tag.xlsx) | `tag(text)` | `A:abc` or `B:abc`, depending on the factory's registered prefix. Reused for grid/cache isolation tests. |
| [ChoiceText.xlsx](ChoiceText.xlsx) | `choice(text)` | Register alias `choice` to `tag(String)` with prefix `chosen:`; `output="chosen:abc"`. |
| [ChoiceNumber.xlsx](ChoiceNumber.xlsx) | `choice(number)` | In a separate factory, register alias `choice` to static `twice(Long)`; `result=12`. |
| [Batched.xlsx](Batched.xlsx) | Two PASS rows: `tag("one")`, `tag("two")` | Use MATCH_ALL, rulesPerFile=1 and prefix `batch:`; `values=["batch:one","batch:two"]`. |
| [Failing.xlsx](Failing.xlsx) | `fail(number)` | Compiles successfully, then deliberately throws during execution; test checks original cause and grid/cell context. |
| [BuiltIn.xlsx](BuiltIn.xlsx) | Condition `contains("b")`; output `max(number,100)` | With an ordinary empty-registry GridFactory, `result=100`. |

List-return examples:

| Workbook | Blue output / cell | Expected result |
|---|---|---|
| [ListResult.xlsx](ListResult.xlsx) | `values` / `getCodes()` | Starting with `["old"]`, appends to produce `["old","a","b"]`; a null destination becomes `["a","b"]`. |
| [QualifiedListResult.xlsx](QualifiedListResult.xlsx) | `values` / `(RegisteredFunctions.getCodes())` | Same behavior with parentheses and a qualified call. |
| [CleanAndGetCodes.xlsx](CleanAndGetCodes.xlsx) | `values` / `cleanAndGetCodes(values)` | Clears the supplied mutable list, adds a and b, then returns that same list. Result is `["a","b"]` without duplication. A null destination is also supported. |
| [EmptyListResult.xlsx](EmptyListResult.xlsx) | `values` / `emptyCodes()` | Adds no elements; existing list is preserved, null destination becomes an empty mutable list. |
| [NullListResult.xlsx](NullListResult.xlsx) | `values` / `nullCodes()` | Same no-element behavior for a null function result. |
| [NestedListResult.xlsx](NestedListResult.xlsx) | `result` / `size(getCodes())` | Condition also uses `size(getCodes()) == 2`; result is 2. |
| [LongListResult.xlsx](LongListResult.xlsx) | `numbers` / `getNumbers()` | Starting with `[0]`, produces `[0,1,2]` with Long elements. |
| [BatchedListResult.xlsx](BatchedListResult.xlsx) | `values` / two rows calling `getCodes()` | With MATCH_ALL and rulesPerFile=1, `["old"]` becomes `["old","a","b","a","b"]`. |

List outputs append returned elements; they do not replace the destination automatically. Existing destinations must be mutable. The runtime helper initializes a null destination and skips adding a list to itself. `cleanAndGetCodes` intentionally mutates its argument, so the example uses it in an output cell. Exact list element types must match; there is no element-by-element numeric conversion. `appendList` is an internal Java helper emitted by the generator, not a newly exposed Excel function.

The nine fixtures under `invalid/` are expected to fail during grid compilation:

| Workbook | Invalid call | Reason |
|---|---|---|
| [UnknownFunction.xlsx](invalid/UnknownFunction.xlsx) | `missing(number)` | Function is not registered. |
| [MissingArgument.xlsx](invalid/MissingArgument.xlsx) | `positive()` | Missing explicit argument; header is not inserted. |
| [ExtraArgument.xlsx](invalid/ExtraArgument.xlsx) | `positive(number,number)` | Too many arguments. |
| [WrongType.xlsx](invalid/WrongType.xlsx) | `positive(text)` | String supplied for Long parameter. |
| [UnexpectedArgument.xlsx](invalid/UnexpectedArgument.xlsx) | `constant(number)` | Function accepts zero arguments. |
| [PrimitiveNull.xlsx](invalid/PrimitiveNull.xlsx) | `primitive(null)` | Null cannot be passed to Java primitive long. |
| [QualifiedWrongType.xlsx](invalid/QualifiedWrongType.xlsx) | `RegisteredFunctions.positive(text)` | Qualified calls also validate parameter types. |
| [WrongListElement.xlsx](invalid/WrongListElement.xlsx) | `getNumbers()` into List<String> `values` | List<Long> cannot be appended to List<String>; tested with validation enabled and disabled. |
| [ListResultToScalar.xlsx](invalid/ListResultToScalar.xlsx) | `getCodes()` into String `output` | List result cannot be written to a scalar; tested with validation enabled and disabled. |

Run `RegisteredFunctionsTest` as a JUnit test in the configured project. The focused current-source build can also be run from the containing workspace folder:

```powershell
python tools/registration_check.py --workspace main-worktrees --output output/main-function-registration --offline --test 'RegisteredFunctionsTest,DirectFunctionCallsTest,DecisionParserTests'
```

This test build compiles the local engine and parser sources together. The ordinary release build still requires the configured parser dependencies and Eclipse/Tycho environment.

The main-based function extension uses typed direct Java calls for public, compiler-visible registered methods. Existing application objects are bound in generated constructors. The user-requested direct-only cleanup removes `FunctionRegistry.invoke` and its reflection fallback: inaccessible declaring/enclosing classes, missing or incompatible compilation loaders/bytecode, and calls requiring more than 254 wrapper parameters now fail during generation. Custom expressions require a `FunctionCallBindings` context; built-in-only expressions still work without it. The registration API and explicit arguments stay the same. `DirectFunctionCallsTest` reuses WidenLong.xlsx as an in-memory template to check generated source, overloads, conversions, nulls, varargs, checked exceptions, target identity and rejection of unsupported direct calls. It also checks custom generation with/without bindings and built-in compatibility.

Grid names become generated Java class names. A filename may contain a hyphen, but a grid name such as `Dates-3` currently generates invalid Java (`Dates-31`). The test helper accepts the grid name and workbook filename separately. It also extracts `CompilationException.getErrorSources()` / `getErrorMessage(source)` so failures show the detailed compiler diagnostics as well as the generic exception summary.
