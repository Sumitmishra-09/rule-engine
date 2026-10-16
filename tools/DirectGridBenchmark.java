package local.benchmark;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openjdk.jmh.annotations.*;

import com.act21.impaktapps.rule.engine.api.*;
import com.act21.impaktapps.rule.engine.commons.Commons;
import com.act21.impaktapps.rule.engine.compiler.Generator;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DecisionTableParser;
import com.act21.impaktapps.rule.engine.test.RegisteredFunctionFact;
import com.act21.impaktapps.rule.engine.validation.ValidationMessage;
import com.act21.java.compiler.ClassSource;
import com.act21.java.compiler.SourceCompiler;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;

/** Local comparison of warmed real rules; all preparation is outside measurement. */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class DirectGridBenchmark {
    @Param({"1", "100"}) public int rows;
    private Rule direct;
    private Rule legacy;
    private RegisteredFunctionFact fact;
    private RuleStatistics statistics;
    private Long[] inputs;
    private int index;

    public static class Functions {
        public Long add(Long left, Long right) { return left + right; }
    }

    @Setup(Level.Trial)
    public void setup() throws Exception {
        FunctionRegistry functions = FunctionRegistry.builder()
                .register("plus", new Functions(), "add", Long.class, Long.class).build();
        byte[] excel;
        try (InputStream input = getClass().getResourceAsStream("/registered-functions/WidenLong.xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook(input); ByteArrayOutputStream bytes = new ByteArrayOutputStream()) {
            for (int i = 1; i <= rows; i++) {
                org.apache.poi.ss.usermodel.Row row = workbook.getSheetAt(0).getRow(i);
                if (row == null) row = workbook.getSheetAt(0).createRow(i);
                row.createCell(0).setCellValue("PASS");
                row.createCell(1).setCellValue("plus(number,smallNumber)");
            }
            workbook.write(bytes);
            excel = bytes.toByteArray();
        }
        direct = compile("Direct" + rows, excel, functions, true);
        legacy = compile("Legacy" + rows, excel, functions, false);
        fact = new RegisteredFunctionFact();
        statistics = new RuleStatistics();
        inputs = new Long[1024];
        for (int i = 0; i < inputs.length; i++) inputs[i] = 1000L + i;
        fact.setNumber(inputs[0]);
        direct.execute(fact, statistics);
        if (!Long.valueOf(1002L).equals(fact.getResult()) || statistics.getRuleExecuted().size() != rows)
            throw new AssertionError("Direct grid result/row count");
        statistics.getRuleExecuted().clear();
        legacy.execute(fact, statistics);
        if (!Long.valueOf(1002L).equals(fact.getResult()) || statistics.getRuleExecuted().size() != rows)
            throw new AssertionError("Legacy grid result/row count");
    }

    private Rule compile(String name, byte[] excel, FunctionRegistry functions, boolean optimized) throws Exception {
        RuleStream stream = new RuleStream() {
            public InputStream getInputStream() { return new ByteArrayInputStream(excel); }
            public void close() { }
        };
        RuleCreationRequest request = RuleCreationRequest.getRuleRequestBuilder().withName(name).withVersion(1L)
                .withModelClassName(RegisteredFunctionFact.class.getName()).withRuleStream(stream)
                .withSchema(new Schema(Commons.getPropertySchemaMap(RegisteredFunctionFact.class.getName()), false))
                .withDecisionMatchType(DecisionMatchType.MATCH_ALL).withRulesPerFile(0).withDoValidate(true)
                .build().forCompilation(functions);
        List<ValidationMessage> messages = new ArrayList<>();
        DecisionTable table = new DecisionTableParser().processExcel(request, stream.getInputStream(), messages);
        if (!messages.isEmpty()) throw new AssertionError(messages);
        table.setBatchNo(1);
        String source = optimized ? new Generator().generate(table, 1, request, messages)
                : new LegacyGenerator().generate(table, 1, request, messages);
        if (source.contains("registeredFunctions.invoke") == optimized)
            throw new AssertionError("Unexpected invocation path");
        Path out = Path.of(System.getProperty("benchmark.output"));
        Files.writeString(out.resolve(name + "1.java"), source);
        ClassSource classSource = new ClassSource();
        classSource.setBinaryName(Generator.RULE_COMPILED_PACKAGE_NAME + "." + name + "1");
        classSource.setSource(source);
        Class<?> compiled = new SourceCompiler(Thread.currentThread().getContextClassLoader())
                .compile(List.of(classSource)).iterator().next().getCompiledClass();
        return (Rule) compiled.getConstructor(FunctionRegistry.class).newInstance(functions);
    }

    @Benchmark public Long directGeneratedGrid() {
        statistics.getRuleExecuted().clear();
        fact.setNumber(inputs[index++ & 1023]);
        direct.execute(fact, statistics);
        return fact.getResult();
    }

    @Benchmark public Long registryGeneratedGrid() {
        statistics.getRuleExecuted().clear();
        fact.setNumber(inputs[index++ & 1023]);
        legacy.execute(fact, statistics);
        return fact.getResult();
    }
}
