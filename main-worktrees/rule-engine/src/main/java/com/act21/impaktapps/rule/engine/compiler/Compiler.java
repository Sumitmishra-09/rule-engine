package com.act21.impaktapps.rule.engine.compiler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.act21.impaktapps.rule.engine.api.Rule;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.api.RuleStream;
import com.act21.impaktapps.rule.engine.exception.ParsingException;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DecisionTableParser;
import com.act21.impaktapps.rule.engine.table.DtCell;
import com.act21.impaktapps.rule.engine.validation.ValidationMessage;
import com.act21.java.compiler.ClassSource;
import com.act21.java.compiler.Result;
import com.act21.java.compiler.SourceCompiler;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class Compiler {

	private static final Logger LOGGER = LogManager.getLogger(Compiler.class);

	public static Rule getRule(RuleCreationRequest request) throws Exception {
		return getRule(request, FunctionRegistry.empty());
	}

	public static Rule getRule(RuleCreationRequest request, FunctionRegistry functions) throws Exception {
		java.util.Objects.requireNonNull(functions, "functions");

		boolean writeToFile = request.getSourceCodeDirectory() != null;
		SourceCompiler compiler = new SourceCompiler(Thread.currentThread().getContextClassLoader());

		DecisionTableParser decisionTableParser = new DecisionTableParser();
		List<ValidationMessage> messages = new ArrayList<>();
		
		try (RuleStream ruleStream = request.getRuleStream()) {
			request = request.forCompilation(functions);

			DecisionTable decisionTable = decisionTableParser.processExcel(request, ruleStream.getInputStream(), messages);
			LOGGER.info("DecisionTable with name {} is created", request.getName());

			if (!messages.isEmpty()) {
				throw new ParsingException(messages);
			}
			List<DecisionTable> batch = createBatch(decisionTable, request.getRulesPerFile());
			List<ClassSource> classSources = new ArrayList<>();

			for (int i = 0; i < batch.size(); i++) {

				Generator generator = new Generator();
				String source = generator.generate(batch.get(i), batch.size(), request, messages);
				
				LOGGER.info("source code generated for {}", batch.get(i).getName());
				String javaClassName = batch.get(i).getName() + batch.get(i).getBatchNo();

				ClassSource classSource = new ClassSource();
				classSource.setBinaryName(Generator.RULE_COMPILED_PACKAGE_NAME + "." + javaClassName);
				classSource.setSource(source);

				if (writeToFile) {
					writeToFile(javaClassName + ".java", source, request.getSourceCodeDirectory());
				}
				classSources.add(classSource);

			}
			
			Collection<Result> results = compiler.compile(classSources);

			String entryClassName = Generator.RULE_COMPILED_PACKAGE_NAME + "." + batch.get(0).getName()
					+ batch.get(0).getBatchNo();
			Result entry = results.stream().filter(result -> result.getCompiledClass().getName().equals(entryClassName))
					.findFirst().orElseThrow(() -> new IllegalStateException("Missing compiled rule: " + entryClassName));
			return (Rule) entry.getCompiledClass().getDeclaredConstructor(FunctionRegistry.class).newInstance(functions);
		}

	}

	private static List<DecisionTable> createBatch(DecisionTable decisionTable, int rulesPerFile) {

		List<DecisionTable> decisionTables = new ArrayList<>();
		if (rulesPerFile == 0) {
			decisionTables.add(decisionTable);
			return decisionTables;
		}

		int batchNo = 1;
		int fromIndex = 0;

		List<List<DtCell>> partitions = Lists.partition(decisionTable.getVertical(), rulesPerFile);

		for (int i = 0; i < partitions.size(); i++) {

			List<DtCell> partition = partitions.get(i);

			int assignSize = partition.get(partition.size() - 1).getRowEndIndex() - partition.get(0).getRowStartIndex()
					+ 1;

			List<DtCell> spanGroups = new ArrayList<>();

			for (DtCell cell : decisionTable.getAssignSpanGroup()) {

				List<DtCell> spans = cell.getChilds().subList(fromIndex, fromIndex + assignSize);
				spanGroups.add(createSpanGroup(cell, spans));

			}

			fromIndex = fromIndex + assignSize;
			decisionTables.add(createCopy(partition, decisionTable, spanGroups, batchNo++));

		}

		return decisionTables;

	}

	private static DtCell createSpanGroup(DtCell original, List<DtCell> spans) {
		DtCell cell = new DtCell(original.getRowStartIndex(), original.getRowEndIndex(), original.getColStartIndex(),
				original.getColEndIndex(), original.getDtCellType(), original.getContent(),
				original.getDecisionHeader(), original.isLeaf());

		cell.setChilds(spans);

		return cell;

	}

	private static DecisionTable createCopy(List<DtCell> partition, DecisionTable original, List<DtCell> spanGroups,
			int batchNo) {

		DecisionTable copy = new DecisionTable(original.getName(), batchNo);
		copy.setVertical(partition);
		copy.setAssignSpanGroup(spanGroups);
		copy.setBatchNo(batchNo);
		copy.setAssignHeaders(original.getAssignHeaders());
		copy.setVerticalHeaders(original.getVerticalHeaders());
		copy.setHorizontal(original.getHorizontal());
		copy.setHorizontalHeaders(original.getHorizontalHeaders());

		return copy;

	}

	public static void writeToFile(String fileName, String content, Path location) throws IOException {
		Files.write(content.getBytes(), location.resolve(fileName).toFile());

	}

}
