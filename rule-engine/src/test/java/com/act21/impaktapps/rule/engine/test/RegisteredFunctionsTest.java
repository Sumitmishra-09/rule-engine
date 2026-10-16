package com.act21.impaktapps.rule.engine.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

import com.act21.impaktapps.rule.engine.api.DecisionMatchType;
import com.act21.impaktapps.rule.engine.api.Rule;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.api.RuleStatistics;
import com.act21.impaktapps.rule.engine.api.RuleStream;
import com.act21.impaktapps.rule.engine.api.Schema;
import com.act21.impaktapps.rule.engine.cache.GridFactory;
import com.act21.impaktapps.rule.engine.cache.GridIdentifier;
import com.act21.impaktapps.rule.engine.commons.Commons;
import com.act21.impaktapps.rule.engine.commons.Constants;
import com.act21.impaktapps.rule.engine.exception.ParsingException;
import com.act21.java.compiler.CompilationException;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.google.common.util.concurrent.UncheckedExecutionException;

public class RegisteredFunctionsTest {
    public static class Functions {
        private final String prefix;
        public Functions(String prefix) { this.prefix = prefix; }
        public Long diffMonth(Date later, Date earlier) {
            return ChronoUnit.MONTHS.between(earlier.toInstant().atZone(ZoneOffset.UTC).toLocalDate(),
                    later.toInstant().atZone(ZoneOffset.UTC).toLocalDate());
        }
        public Boolean positive(Long value) { return value != null && value > 0; }
        public boolean primitive(long value) { return value > 0; }
        public String tag(String value) { return prefix + value; }
        public Long constant() { return 42L; }
        public String join(String... values) { return String.join("", values); }
        public BigDecimal decimal(BigDecimal value) { return value; }
        public Long size(List<String> values) { return (long) values.size(); }
        public Long fail(Long value) { throw new IllegalStateException("deliberate failure"); }
        public double unsupported(double value) { return value; }
        public List<String> getCodes() { return List.of("a", "b"); }
        public List<String> cleanAndGetCodes(List<String> codes) {
            if (codes == null) {
                codes = new ArrayList<>();
            }
            codes.clear();
            codes.addAll(getCodes());
            return codes;
        }
        public List<String> emptyCodes() { return List.of(); }
        public List<String> nullCodes() { return null; }
        public List<Long> getNumbers() { return List.of(1L, 2L); }
        @SuppressWarnings("rawtypes")
        public List unsupportedRawListResult() { return List.of("a"); }
        public static Long twice(Long value) { return value * 2; }
        public  Date toDate(String date) {
            LocalDate localDate = LocalDate.parse(date, Constants.RULE_ENGINE_DEFAULT_DATE_FORMAT);
			return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }

    private FunctionRegistry registry(String prefix) {
        Functions functions = new Functions(prefix);
        return FunctionRegistry.builder()
                .register("diffMonth", functions, "diffMonth", Date.class, Date.class)
                .register("positive", functions, "positive", Long.class)
                .register("primitive", functions, "primitive", long.class)
                .register("tag", functions, "tag", String.class)
                .register("constant", functions, "constant")
                .register("join", functions, "join", String[].class)
                .register("decimal", functions, "decimal", BigDecimal.class)
                .register("size", functions, "size", List.class)
                .register("fail", functions, "fail", Long.class)
                .register("toDate", functions, "toDate", String.class)
                .register("getCodes", functions, "getCodes")
                .register("cleanAndGetCodes", functions, "cleanAndGetCodes", List.class)
                .register("emptyCodes", functions, "emptyCodes")
                .register("nullCodes", functions, "nullCodes")
                .register("getNumbers", functions, "getNumbers")
                .registerStatic("twice", Functions.class, "twice", Long.class).build();
    }

    @Test
    void dateFieldsAndNestedStaticFunctionExecute() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        fact.setStartDate(date("2026-01-15"));
        fact.setEndDate(date("2026-08-15"));
        Rule rule = compile(new GridFactory(registry("")), "Dates3", "Dates-3", 300);
        rule.execute(fact, new RuleStatistics());
        System.out.println(fact.getResult());
        assertEquals(38L, fact.getResult());
    }

    @Test
    void booleanCallsNeverReceiveTheYellowTextHeader() throws Exception {
        for (String fixture : List.of("Predicate", "PredicateParenthesized", "PredicateNegated",
                "PredicateAnd", "PredicateOr", "PredicateQualified")) {
            Rule rule = compile(new GridFactory(registry("")), "Predicate", fixture, 300);
            RegisteredFunctionFact fact = new RegisteredFunctionFact();
            boolean negated = fixture.equals("PredicateNegated");
            rule.execute(fact, new RuleStatistics());
            assertEquals(negated ? null : "matched", fact.getOutput(), fixture);
            fact.setNumber(-1L);
            fact.setOutput(null);
            rule.execute(fact, new RuleStatistics());
            assertEquals(negated ? "matched" : null, fact.getOutput(), fixture);
        }
    }

    @Test
    void outputBooleanAndQualifiedCallsUseExplicitArguments() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        compile(new GridFactory(registry("")), "BooleanOutput", 300)
                .execute(fact, new RuleStatistics());
        assertEquals(Boolean.TRUE, fact.getFlag());
    }

    @Test
    void zeroArgumentsAndEmptyVarargsExecute() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        GridFactory factory = new GridFactory(registry(""));
        compile(factory, "Zero", 300)
                .execute(fact, new RuleStatistics());
        assertEquals(42L, fact.getResult());
        compile(factory, "EmptyVarargs", 300)
                .execute(fact, new RuleStatistics());
        assertEquals("", fact.getOutput());
        compile(factory, "Varargs", 300)
                .execute(fact, new RuleStatistics());
        assertEquals("abcxabc", fact.getOutput());
    }

    @Test
    void numericWideningIsTheSameInValidationAndInvocation() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        GridFactory factory = new GridFactory(registry(""));
        compile(factory, "WidenLong", 300)
                .execute(fact, new RuleStatistics());
        assertEquals(4L, fact.getResult());
        compile(factory, "WidenDecimal", 300)
                .execute(fact, new RuleStatistics());
        assertEquals(new BigDecimal("100"), fact.getDecimal());
    }

    @Test
    void typedListParameterExecutes() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        fact.setValues(List.of("a", "b"));
        compile(new GridFactory(registry("")), "ListArgument", 300).execute(fact, new RuleStatistics());
        assertEquals(2L, fact.getResult());
    }

    @Test
    void listResultsAppendElementsToExistingAndNullTargets() throws Exception {
        for (String fixture : List.of("ListResult", "QualifiedListResult")) {
            Rule rule = compile(new GridFactory(registry("")), fixture, 300);
            RegisteredFunctionFact fact = new RegisteredFunctionFact();
            List<String> existing = new ArrayList<>(List.of("old"));
            fact.setValues(existing);
            rule.execute(fact, new RuleStatistics());
            assertEquals(List.of("old", "a", "b"), fact.getValues(), fixture);
            assertSame(existing, fact.getValues());
            rule.execute(fact, new RuleStatistics());
            assertEquals(List.of("old", "a", "b", "a", "b"), fact.getValues(), fixture);
            fact.setValues(null);
            rule.execute(fact, new RuleStatistics());
            assertEquals(List.of("a", "b"), fact.getValues(), fixture);
        }
    }

    @Test
    void cleanAndGetCodesDoesNotAppendTheSameListTwice() throws Exception {
        Rule rule = compile(new GridFactory(registry("")), "CleanAndGetCodes", 300);
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        List<String> existing = new ArrayList<>(List.of("old"));
        fact.setValues(existing);
        rule.execute(fact, new RuleStatistics());
        //assertSame(existing, fact.getValues());
        fact.getValues().forEach(c -> System.out.println(c));
        assertEquals(List.of("a", "b"), fact.getValues());
        fact.setValues(null);
        rule.execute(fact, new RuleStatistics());
        assertEquals(List.of("a", "b"), fact.getValues());
    }

    @Test
    void emptyAndNullListResultsAddNoElements() throws Exception {
        for (String fixture : List.of("EmptyListResult", "NullListResult")) {
            Rule rule = compile(new GridFactory(registry("")), fixture, 300);
            RegisteredFunctionFact fact = new RegisteredFunctionFact();
            List<String> existing = new ArrayList<>(List.of("old"));
            fact.setValues(existing);
            rule.execute(fact, new RuleStatistics());
            assertSame(existing, fact.getValues());
            assertEquals(List.of("old"), fact.getValues(), fixture);
            fact.setValues(null);
            rule.execute(fact, new RuleStatistics());
            assertEquals(List.of(), fact.getValues(), fixture);
        }
    }

    @Test
    void listResultCanBePassedToAnotherFunction() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        compile(new GridFactory(registry("")), "NestedListResult", 300)
                .execute(fact, new RuleStatistics());
        assertEquals(2L, fact.getResult());
    }

    @Test
    void longListResultsKeepTheirElementType() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        fact.setNumbers(new ArrayList<>(List.of(0L)));
        compile(new GridFactory(registry("")), "LongListResult", 300)
                .execute(fact, new RuleStatistics());
        assertEquals(List.of(0L, 1L, 2L), fact.getNumbers());
    }

    @Test
    void listResultTypeMismatchesFailWithAndWithoutValidation() throws Exception {
        for (String fixture : List.of("WrongListElement", "ListResultToScalar")) {
            byte[] excel = workbook("invalid/" + fixture);
            for (boolean validate : List.of(true, false)) {
                UncheckedExecutionException failure = assertThrows(UncheckedExecutionException.class,
                        () -> new GridFactory(registry("")).get(new GridIdentifier(fixture, 1L),
                                key -> request(key, excel, 300, validate)), fixture);
                if (validate) {
                    assertTrue(failure.getCause() instanceof ParsingException, fixture);
                } else {
                    Throwable root = failure;
                    while (root.getCause() != null) root = root.getCause();
                    assertTrue(root instanceof IllegalArgumentException, fixture);
                    assertTrue(root.getMessage().contains("List result type does not match output"), fixture);
                }
            }
        }
    }

    @Test
    void listResultsAppendAcrossGeneratedBatches() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        fact.setValues(new ArrayList<>(List.of("old")));
        compile(new GridFactory(registry("")), "BatchedListResult", 1)
                .execute(fact, new RuleStatistics());
        assertEquals(List.of("old", "a", "b", "a", "b"), fact.getValues());
    }

    @Test
    void wrongNamesCountsAndTypesFailDuringGridCompilation() {
        for (String fixture : List.of("UnknownFunction", "MissingArgument", "ExtraArgument",
                "WrongType", "UnexpectedArgument", "PrimitiveNull", "QualifiedWrongType")) {
            IllegalStateException failure = assertThrows(IllegalStateException.class,
                    () -> compile(new GridFactory(registry("")),
                    "Invalid", "invalid/" + fixture, 300), fixture);
            System.out.println("Expected validation failure: " + failure.getMessage());
        }
    }

    @Test
    void nullReferenceIsPassedToTheFunction() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        compile(new GridFactory(registry("")), "NullArgument", 300).execute(fact, new RuleStatistics());
        assertEquals(Boolean.FALSE, fact.getFlag());
    }

    @Test
    void registryIsReusedAcrossGridsAndFactoriesRemainIsolated() throws Exception {
        GridFactory first = new GridFactory(registry("A:"));
        GridFactory second = new GridFactory(registry("B:"));
        Rule firstRule = compile(first, "SharedName", "Tag", 300);
        Rule secondRule = compile(second, "SharedName", "Tag", 300);
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        firstRule.execute(fact, new RuleStatistics());
        assertEquals("A:abc", fact.getOutput());
        secondRule.execute(fact, new RuleStatistics());
        assertEquals("B:abc", fact.getOutput());
        firstRule.execute(fact, new RuleStatistics());
        assertEquals("A:abc", fact.getOutput());
        compile(first, "AnotherGrid", "Tag", 300)
                .execute(fact, new RuleStatistics());
        assertEquals("A:abc", fact.getOutput());
    }

    @Test
    void differentSignaturesWithTheSameNameRemainIsolatedDuringConcurrentCompilation() throws Exception {
        GridFactory strings = new GridFactory(FunctionRegistry.builder()
                .register("choice", new Functions("chosen:"), "tag", String.class).build());
        GridFactory numbers = new GridFactory(FunctionRegistry.builder()
                .registerStatic("choice", Functions.class, "twice", Long.class).build());
        var executor = java.util.concurrent.Executors.newFixedThreadPool(2);
        try {
            var stringRule = executor.submit(() -> compile(strings, "Concurrent", "ChoiceText", 300));
            var numberRule = executor.submit(() -> compile(numbers, "Concurrent", "ChoiceNumber", 300));
            RegisteredFunctionFact fact = new RegisteredFunctionFact();
            stringRule.get().execute(fact, new RuleStatistics());
            numberRule.get().execute(fact, new RuleStatistics());
            assertEquals("chosen:abc", fact.getOutput());
            assertEquals(12L, fact.getResult());
        } finally {
            executor.shutdownNow();
        }
    }

    @Test
    void cacheHitDoesNotRebuildTheRequest() throws Exception {
        GridFactory factory = new GridFactory(registry(""));
        AtomicInteger loads = new AtomicInteger();
        byte[] excel = workbook("Tag");
        GridIdentifier id = new GridIdentifier("Cached", 1L);
        Rule first = factory.get(id, key -> { loads.incrementAndGet(); return request(key, excel, 300); });
        Rule second = factory.get(id, key -> { throw new AssertionError("Cache hit ran loader"); });
        assertSame(first, second);
        assertEquals(1, loads.get());
    }

    @Test
    void everyGeneratedBatchReceivesTheRegistry() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        compile(new GridFactory(registry("batch:")), "Batched", 1)
                .execute(fact, new RuleStatistics());
        assertEquals(List.of("batch:one", "batch:two"), fact.getValues());
    }

    @Test
    void functionFailureRetainsCauseAndGridCellContext() throws Exception {
        Rule rule = compile(new GridFactory(registry("")), "Failing", 300);
        RuntimeException failure = assertThrows(RuntimeException.class,
                () -> rule.execute(new RegisteredFunctionFact(), new RuleStatistics()));
        assertTrue(failure.getMessage().contains("Failing"));
        assertTrue(failure.getMessage().contains("last Cell Executed"));
        assertEquals("Function fail failed", failure.getCause().getMessage());
        assertEquals("deliberate failure", failure.getCause().getCause().getMessage());
    }

    @Test
    void oldFactoryAndBuiltInHeaderShorthandStillExecute() throws Exception {
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        compile(new GridFactory(), "BuiltIn", 300)
                .execute(fact, new RuleStatistics());
        assertEquals(100L, fact.getResult());
    }

    @Test
    void invalidRegistrationsFailBeforeAnyGridIsLoaded() {
        Functions functions = new Functions("");
        assertThrows(IllegalArgumentException.class, () -> FunctionRegistry.builder()
                .register("max", functions, "constant"));
        assertThrows(IllegalArgumentException.class, () -> FunctionRegistry.builder()
                .register("bad-name", functions, "constant"));
        assertThrows(IllegalArgumentException.class, () -> FunctionRegistry.builder()
                .register("unknown", functions, "unknown"));
        assertThrows(IllegalArgumentException.class, () -> FunctionRegistry.builder()
                .register("unsupported", functions, "unsupported", double.class));
        assertThrows(IllegalArgumentException.class, () -> FunctionRegistry.builder()
                .register("listResult", functions, "unsupportedRawListResult"));
        FunctionRegistry.Builder builder = FunctionRegistry.builder().register("tag", functions, "tag", String.class);
        assertThrows(IllegalArgumentException.class, () -> builder.register("tag", functions, "tag", String.class));
        FunctionRegistry snapshot = builder.build();
        builder.register("constant", functions, "constant");
        assertThrows(IllegalArgumentException.class, () -> snapshot.getDefinition("constant"));
        assertThrows(UnsupportedOperationException.class, () -> snapshot.getDefinitions().clear());
    }

    private Rule compile(GridFactory factory, String name, int batchSize) throws Exception {
        return compile(factory, name, name, batchSize);
    }

    private Rule compile(GridFactory factory, String name, String fixture, int batchSize) throws Exception {
        byte[] excel = workbook(fixture);
        try {
            return factory.get(new GridIdentifier(name, 1L), key -> request(key, excel, batchSize));
        } catch (Exception failure) {
            failure.printStackTrace();
            for (Throwable cause = failure; cause != null; cause = cause.getCause()) {
                if (cause instanceof ParsingException) {
                    String messages = ((ParsingException) cause).getValidationMessage().stream()
                            .map(message -> message.getCellNum() + ": " + message.getDescription())
                            .collect(java.util.stream.Collectors.joining("; "));
                    throw new IllegalStateException(name + " [" + fixture + ".xlsx]: " + messages, failure);
                }
                if (cause instanceof CompilationException) {
                    CompilationException compilation = (CompilationException) cause;
                    String messages = compilation.getErrorSources().stream()
                            .map(source -> source.getBinaryName() + ": "
                                    + String.join("; ", compilation.getErrorMessage(source)))
                            .collect(java.util.stream.Collectors.joining(System.lineSeparator()));
                    throw new IllegalStateException(name + " [" + fixture + ".xlsx]: "
                            + compilation.getMessage() + System.lineSeparator() + messages, failure);
                }
            }
            throw failure;
        }
    }

    private RuleCreationRequest request(GridIdentifier key, byte[] excel, int batchSize) {
        return request(key, excel, batchSize, true);
    }

    private RuleCreationRequest request(GridIdentifier key, byte[] excel, int batchSize, boolean validate) {
        ByteArrayInputStream input = new ByteArrayInputStream(excel);
        RuleStream stream = new RuleStream() {
            public InputStream getInputStream() { return input; }
            public void close() { }
        };
        return RuleCreationRequest.getRuleRequestBuilder().withName(key.getName()).withVersion(key.getVersion())
                .withModelClassName(RegisteredFunctionFact.class.getName()).withRuleStream(stream)
                .withSchema(new Schema(Commons.getPropertySchemaMap(RegisteredFunctionFact.class.getName()), false))
                .withDecisionMatchType(DecisionMatchType.MATCH_ALL).withRulesPerFile(batchSize)
                .withDoValidate(validate).build();
    }

    private byte[] workbook(String fixture) throws Exception {
        String resource = "/registered-functions/" + fixture + ".xlsx";
        try (InputStream input = RegisteredFunctionsTest.class.getResourceAsStream(resource)) {
            assertNotNull(input, "Missing Excel test resource: " + resource);
            return input.readAllBytes();
        }
    }

    private Date date(String iso) {
        return Date.from(LocalDate.parse(iso).atStartOfDay().toInstant(ZoneOffset.UTC));
    }
}
