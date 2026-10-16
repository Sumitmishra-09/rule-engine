package com.act21.impaktapps.rule.engine.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.act21.impaktapps.rule.engine.api.DecisionMatchType;
import com.act21.impaktapps.rule.engine.api.Rule;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.api.RuleStatistics;
import com.act21.impaktapps.rule.engine.api.RuleStream;
import com.act21.impaktapps.rule.engine.api.Schema;
import com.act21.impaktapps.rule.engine.cache.GridFactory;
import com.act21.impaktapps.rule.engine.cache.GridIdentifier;
import com.act21.impaktapps.rule.engine.commons.Commons;
import com.act21.rule.engine.dsl.expression.functions.FunctionCallBindings;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.act21.rule.engine.dsl.expression.runtime.ExpressionParser;
import com.act21.rule.engine.dsl.expression.runtime.Type;
import com.act21.rule.engine.dsl.expression.runtime.VariableSchema;

public class DirectFunctionCallsTest {
    @TempDir Path generated;
    private static final AtomicInteger NAMES = new AtomicInteger();

    public static class Functions {
        int calls;
        final IOException checkedFailure = new IOException("checked failure");
        final Error fatalFailure = new AssertionError("fatal failure");
        public Long overloaded(Long value) { return value == null ? -1L : value + ++calls; }
        public Long overloaded(long value) { throw new AssertionError("wrong overload"); }
        public long primitive(long value) { return value; }
        public Long sum(long... values) { long sum = 0; for (long value : values) sum += value; return sum; }
        public BigDecimal decimal(BigDecimal value) { return value == null ? BigDecimal.TEN : value; }
        public static Long staticTwice(Long value) { return value * 2; }
        public Long checked(Long value) throws IOException { throw checkedFailure; }
        public Long fatal(Long value) { throw fatalFailure; }
        public Long next() { return (long) ++calls; }
        public Long pair(Long first, Long second) { return first * 10 + second; }
    }

    @Test
    void bindsExistingObjectAndCallsTheRegisteredOverloadWithoutReflection() throws Exception {
        Functions target = new Functions();
        FunctionRegistry registry = FunctionRegistry.builder()
                .register("alias", target, "overloaded", Long.class)
                .register("unused", new HiddenFunctionOwner.Functions(), "value", Long.class).build();
        Compiled compiled = compile(registry, "result", "alias(smallNumber)");
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        compiled.rule.execute(fact, new RuleStatistics());
        assertEquals(3L, fact.getResult());
        compiled.rule.execute(fact, new RuleStatistics());
        assertEquals(4L, fact.getResult());
        assertEquals(2, target.calls);
        assertTrue(compiled.source.contains(".overloaded((java.lang.Long) value0)"));
        assertTrue(compiled.source.contains("getDefinition(\"alias\").getTarget()"));
        assertFalse(compiled.source.contains("unused"));
        assertFalse(compiled.source.contains("registeredFunctions.invoke"));
        assertFalse(compiled.source.contains("new Object[]"));
    }

    @Test
    void staticAliasCallsTheActualMethodWithoutBindingATarget() throws Exception {
        Compiled compiled = compile(FunctionRegistry.builder()
                .registerStatic("alias", Functions.class, "staticTwice", Long.class).build(),
                "result", "alias(smallNumber)");
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        compiled.rule.execute(fact, new RuleStatistics());
        assertEquals(4L, fact.getResult());
        assertTrue(compiled.source.contains("DirectFunctionCallsTest.Functions.staticTwice("));
        assertFalse(compiled.source.contains("getTarget()"));
    }

    @Test
    void nullableWideningKeepsNullForReferenceParameters() throws Exception {
        Functions target = new Functions();
        FunctionRegistry registry = FunctionRegistry.builder().register("longValue", target, "overloaded", Long.class)
                .register("decimalValue", target, "decimal", BigDecimal.class).build();
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        fact.setSmallNumber(null);
        compile(registry, "result", "longValue(smallNumber)").rule.execute(fact, new RuleStatistics());
        assertEquals(-1L, fact.getResult());
        compile(registry, "decimal", "decimalValue(smallNumber)").rule.execute(fact, new RuleStatistics());
        assertEquals(BigDecimal.TEN, fact.getDecimal());
        compile(registry, "result", "longValue(null)").rule.execute(fact, new RuleStatistics());
        assertEquals(-1L, fact.getResult());
    }

    @Test
    void primitiveNullReportsTheExpectedConversionError() throws Exception {
        Functions target = new Functions();
        FunctionRegistry registry = FunctionRegistry.builder().register("alias", target, "primitive", long.class).build();
        Compiled compiled = compile(registry, "result", "alias(smallNumber)");
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        fact.setSmallNumber(null);
        RuntimeException failure = assertThrows(RuntimeException.class,
                () -> compiled.rule.execute(fact, new RuleStatistics()));
        assertInstanceOf(IllegalArgumentException.class, failure.getCause());
        assertEquals("Function alias expects long, got null", failure.getCause().getMessage());
    }

    @Test
    void primitiveVarargsWidenAndAcceptZeroArguments() throws Exception {
        FunctionRegistry registry = FunctionRegistry.builder().register("total", new Functions(), "sum", long[].class).build();
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        Compiled compiled = compile(registry, "result", "total(smallNumber,number,3)");
        compiled.rule.execute(fact, new RuleStatistics());
        assertEquals(11L, fact.getResult());
        assertTrue(compiled.source.contains("new long[]{"));
        assertFalse(compiled.source.contains("new Object[]"));
        fact.setSmallNumber(null);
        RuntimeException failure = assertThrows(RuntimeException.class,
                () -> compiled.rule.execute(fact, new RuleStatistics()));
        assertEquals("Function total expects long, got null", failure.getCause().getMessage());
        compile(registry, "result", "total()").rule.execute(fact, new RuleStatistics());
        assertEquals(0L, fact.getResult());
    }

    @Test
    void checkedExceptionsKeepFunctionAndCellContextAndErrorsPropagateUnchanged() throws Exception {
        Functions target = new Functions();
        FunctionRegistry registry = FunctionRegistry.builder().register("checkedAlias", target, "checked", Long.class)
                .register("fatalAlias", target, "fatal", Long.class).build();
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        Compiled checked = compile(registry, "result", "checkedAlias(number)");
        RuntimeException failure = assertThrows(RuntimeException.class,
                () -> checked.rule.execute(fact, new RuleStatistics()));
        assertTrue(failure.getMessage().contains("last Cell Executed"));
        assertEquals("Function checkedAlias failed", failure.getCause().getMessage());
        assertSame(target.checkedFailure, failure.getCause().getCause());
        Compiled fatal = compile(registry, "result", "fatalAlias(number)");
        assertSame(target.fatalFailure, assertThrows(Error.class,
                () -> fatal.rule.execute(fact, new RuleStatistics())));
    }

    @Test
    void nestedArgumentsEvaluateOnceInOrderAndReuseTheSameBridge() throws Exception {
        Functions target = new Functions();
        FunctionRegistry registry = FunctionRegistry.builder().register("next", target, "next")
                .register("pair", target, "pair", Long.class, Long.class).build();
        Compiled compiled = compile(registry, "result", "pair(next(),next())");
        RegisteredFunctionFact fact = new RegisteredFunctionFact();
        compiled.rule.execute(fact, new RuleStatistics());
        assertEquals(12L, fact.getResult());
        assertEquals(2, target.calls);
        assertEquals(1, compiled.source.split("\\.next\\(\\)", -1).length - 1);
    }

    @Test
    void inaccessibleEnclosingClassFailsDuringGenerationWithAndWithoutValidation() {
        FunctionRegistry registry = FunctionRegistry.builder()
                .register("alias", new HiddenFunctionOwner.Functions(), "value", Long.class).build();
        for (boolean validate : List.of(true, false)) {
            RuntimeException failure = assertThrows(RuntimeException.class,
                    () -> compile(registry, "result", "alias(number)", validate));
            Throwable root = failure;
            while (root.getCause() != null) root = root.getCause();
            assertInstanceOf(IllegalArgumentException.class, root);
            assertTrue(root.getMessage().contains("Function alias cannot be generated as a direct call"));
            assertTrue(root.getMessage().contains("class must be public: " + HiddenFunctionOwner.class.getName()));
        }
    }

    @Test
    void missingOrIncompatibleCompilationLoaderRejectsTheCall() {
        FunctionRegistry registry = FunctionRegistry.builder().register("alias", new Functions(), "overloaded", Long.class).build();
        for (ClassLoader loader : new ClassLoader[]{null, new ClassLoader(null) { }}) {
            FunctionCallBindings bindings = new FunctionCallBindings(loader);
            IllegalArgumentException failure = assertThrows(IllegalArgumentException.class,
                    () -> bindings.compileCall(registry.getDefinition("alias"), List.of(Long.class.getName()), List.of("1L")));
            assertTrue(failure.getMessage().contains("Function alias cannot be generated as a direct call"));
            assertTrue(failure.getMessage().contains("compilation class loader"));
            assertEquals("", bindings.declarations());
            assertEquals("", bindings.initializers());
        }
    }

    @Test
    void unavailableClassBytecodeRejectsTheCall() {
        FunctionRegistry registry = FunctionRegistry.builder().register("alias", new Functions(), "overloaded", Long.class).build();
        ClassLoader loader = new ClassLoader(Functions.class.getClassLoader()) {
            @Override public java.net.URL getResource(String name) { return null; }
        };
        FunctionCallBindings bindings = new FunctionCallBindings(loader);
        IllegalArgumentException failure = assertThrows(IllegalArgumentException.class,
                () -> bindings.compileCall(registry.getDefinition("alias"), List.of(Long.class.getName()), List.of("1L")));
        assertTrue(failure.getMessage().contains("class bytecode is unavailable to the compiler"));
        assertEquals("", bindings.declarations());
        assertEquals("", bindings.initializers());
    }

    @Test
    void customGenerationRequiresBindingsButBuiltInsDoNot() throws Exception {
        FunctionRegistry registry = FunctionRegistry.builder().register("alias", new Functions(), "overloaded", Long.class).build();
        ExpressionParser parser = new ExpressionParser(Map.of("number",
                new VariableSchema(new Type(Long.class.getName(), null), null, null)), Set.of(), registry);
        parser.parse("assign number:alias(number)");
        IllegalStateException failure = assertThrows(IllegalStateException.class, () -> parser.generateCode(null));
        assertEquals("Generating custom function alias requires FunctionCallBindings in GeneratorContext", failure.getMessage());
        FunctionCallBindings bindings = new FunctionCallBindings(Functions.class.getClassLoader());
        String source = parser.generateCode(Map.of(FunctionCallBindings.CONTEXT_KEY, bindings));
        assertTrue(source.contains("__gridFunction0(requestData.getNumber())"));
        assertFalse(source.contains("registeredFunctions.invoke"));
        assertTrue(bindings.declarations().contains(".overloaded((java.lang.Long) value0)"));
        parser.parse("assign number:max(number,100)");
        assertTrue(parser.generateCode(null).contains("HelperFunctions.max("));
    }

    @Test
    void oversizedVarargsCallFailsBeforeEmittingAnInvalidBridge() {
        FunctionRegistry registry = FunctionRegistry.builder().register("total", new Functions(), "sum", long[].class).build();
        FunctionCallBindings bindings = new FunctionCallBindings(Functions.class.getClassLoader());
        IllegalArgumentException failure = assertThrows(IllegalArgumentException.class,
                () -> bindings.compileCall(registry.getDefinition("total"),
                        Collections.nCopies(255, Long.class.getName()), Collections.nCopies(255, "1L")));
        assertEquals("Function total supports at most 254 arguments in a generated direct call, got 255", failure.getMessage());
        assertEquals("", bindings.declarations());
        assertEquals("", bindings.initializers());
    }

    private record Compiled(Rule rule, String source) { }

    private Compiled compile(FunctionRegistry registry, String output, String expression) throws Exception {
        return compile(registry, output, expression, true);
    }

    private Compiled compile(FunctionRegistry registry, String output, String expression, boolean validate) throws Exception {
        // Reuse the saved yellow/blue workbook; only the output header/expression vary.
        byte[] excel;
        try (InputStream resource = getClass().getResourceAsStream("/registered-functions/WidenLong.xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook(resource); ByteArrayOutputStream bytes = new ByteArrayOutputStream()) {
            workbook.getSheetAt(0).getRow(0).getCell(1).setCellValue(output);
            workbook.getSheetAt(0).getRow(1).getCell(1).setCellValue(expression);
            workbook.write(bytes);
            excel = bytes.toByteArray();
        }
        String name = "DirectCalls" + NAMES.incrementAndGet();
        RuleStream stream = new RuleStream() {
            public InputStream getInputStream() { return new ByteArrayInputStream(excel); }
            public void close() { }
        };
        Rule rule = new GridFactory(registry).get(new GridIdentifier(name, 1L), key ->
                RuleCreationRequest.getRuleRequestBuilder().withName(name).withVersion(1L)
                .withModelClassName(RegisteredFunctionFact.class.getName()).withRuleStream(stream)
                .withSchema(new Schema(Commons.getPropertySchemaMap(RegisteredFunctionFact.class.getName()), false))
                .withDecisionMatchType(DecisionMatchType.MATCH_ALL).withRulesPerFile(300)
                .withSourceCodeDirectory(generated).withDoValidate(validate).build());
        return new Compiled(rule, Files.readString(generated.resolve(name + "1.java")));
    }
}

// Registration can inspect this public nested class, but generated Java cannot name its enclosing class.
class HiddenFunctionOwner {
    public static class Functions {
        public Long value(Long value) { return value + 100; }
    }
}
