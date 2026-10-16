package com.act21.impaktapps.rule.engine.compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.act21.impaktapps.rule.engine.api.DecisionMatchType;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.commons.Constants;
import com.act21.impaktapps.rule.engine.exception.ParsingException;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DtCell;
import com.act21.impaktapps.rule.engine.validation.ValidationMessage;
import com.act21.impaktapps.rule.engine.validation.ValidationService;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.act21.rule.engine.dsl.expression.functions.FunctionCallBindings;

public class Generator {

	public static final String NEW_LINE = "\n";
	public static final String SEMI_COLON = ";";
	public static final String RULE_COMPILED_PACKAGE_NAME = "com.act21.impaktapps.rule.engine.compiled";
	public static final String ENGINE_PACKAGE_NAME = "com.act21.impaktapps.rule.engine.api";
	public static final String COMMONS_PACKAGE_NAME = "com.act21.impaktapps.rule.engine.commons";
	public static final String UTIL_IMPORT = "java.util.Map";
	public static final String MATH_IMPORT = "java.math.*";
	public static final String DATE_FORMAT_IMPORT = "java.text.DateFormat";
	public static final String SIMPLE_DATE_FORMAT_IMPORT = "java.text.SimpleDateFormat";
	public static final String IMPORT = "import ";
	public static final String HEPLERFUNCTIONS_IMPORT = "com.act21.rule.engine.dsl.expression.runtime.HelperFunctions";
	private Integer H_BIT_COUNT = 0;
	private Integer V_BIT_COUNT = 0;
	List<DtCell> postExclusionVertical = new ArrayList<>();
	
	private ValidationService validationService = new ValidationService();
	private FunctionCallBindings functionCalls;

	public Generator() {

	}

	public String generate(DecisionTable decisionTable, int totalBatchCount, RuleCreationRequest request,
			List<ValidationMessage> messages) {
		String className = request.getModelClassName().substring(request.getModelClassName().lastIndexOf(".") + 1);

		H_BIT_COUNT = 0;
		V_BIT_COUNT = 0;
		functionCalls = new FunctionCallBindings(Thread.currentThread().getContextClassLoader());

		for (DtCell cell : decisionTable.getVertical()) {
			getInitialDecisionCells(cell, postExclusionVertical);
		}

		int H = decisionTable.getAssignSpanGroup().size();
		int V = decisionTable.getAssignSpanGroup().get(0).getChilds().size();

		StringBuilder sb = new StringBuilder();
		sb.append("package " + RULE_COMPILED_PACKAGE_NAME);
		sb.append(SEMI_COLON);
		sb.append(NEW_LINE);
		sb.append(IMPORT + ENGINE_PACKAGE_NAME + ".*");
		sb.append(SEMI_COLON);
		sb.append(NEW_LINE);
		sb.append(IMPORT + COMMONS_PACKAGE_NAME + ".*");
		sb.append(SEMI_COLON);
		sb.append(NEW_LINE);
		sb.append(IMPORT + request.getModelClassName());
		sb.append(SEMI_COLON);
		sb.append(NEW_LINE);
		sb.append(IMPORT + UTIL_IMPORT);
		sb.append(SEMI_COLON);
		sb.append(NEW_LINE);
		sb.append(IMPORT + MATH_IMPORT);
		sb.append(SEMI_COLON);
		sb.append(IMPORT + HEPLERFUNCTIONS_IMPORT);
		sb.append(SEMI_COLON);
		sb.append(NEW_LINE);
		sb.append(IMPORT + DATE_FORMAT_IMPORT);
		sb.append(SEMI_COLON);
		sb.append(NEW_LINE);
		sb.append(IMPORT + SIMPLE_DATE_FORMAT_IMPORT);
		sb.append(SEMI_COLON);
		sb.append(NEW_LINE);

		sb.append("public class " + decisionTable.getName() + decisionTable.getBatchNo() + " implements Rule {");
		sb.append(NEW_LINE);
		String generatedClassName = decisionTable.getName() + decisionTable.getBatchNo();
		String registryType = FunctionRegistry.class.getName();
		sb.append("private final " + registryType + " registeredFunctions;" + NEW_LINE);
		Stream.iterate(0, i -> i + 1).limit(H)
				.forEach(n -> sb.append(" private  final int H_" + n + "= " + n + ";" + NEW_LINE));
		Stream.iterate(0, i -> i + 1).limit(V)
				.forEach(n -> sb.append(" private  final int V_" + n + "= " + n + ";" + NEW_LINE));
		sb.append(NEW_LINE);
		sb.append("@Override");
		sb.append(NEW_LINE);
		sb.append("public final void execute(Object requestData,RuleStatistics ruleStats) {");
		sb.append(NEW_LINE);
		sb.append(className + " requestData1= (" + className + ")" + "requestData ;");
		sb.append(NEW_LINE);
		sb.append("try{");
		sb.append(NEW_LINE);
		sb.append(String.format("java.util.BitSet horizontal = new java.util.BitSet(%d);", H));
		sb.append(NEW_LINE);
		sb.append(String.format("java.util.BitSet vertical = new java.util.BitSet(%d);", V));
		sb.append(NEW_LINE);
		sb.append("decideHorizontal(requestData1, horizontal,ruleStats);");
		sb.append(NEW_LINE);
		sb.append("decideVertical(requestData1, vertical,ruleStats);");
		sb.append(NEW_LINE);
		sb.append("executeTableActions(requestData1, horizontal, vertical,ruleStats);");
		sb.append(NEW_LINE);

		if (decisionTable.getBatchNo() < totalBatchCount) {

			String nextClass = decisionTable.getName() + (decisionTable.getBatchNo() + 1);

			StringBuilder nextRuleClassExpressionBuilder = new StringBuilder();

			nextRuleClassExpressionBuilder
					.append(String.format("%s %sObj = new %s(registeredFunctions);" + NEW_LINE, nextClass, nextClass, nextClass));
			nextRuleClassExpressionBuilder.append(
					String.format("%sObj.execute(requestData1,ruleStats);" + NEW_LINE, nextClass, nextClass, nextClass)
							+ "");

			DecisionMatchType decisionMatchType = request.getDecisionMatchType();

			if (decisionMatchType == DecisionMatchType.MATCH_ALL) {
				sb.append(nextRuleClassExpressionBuilder.toString());
			} else {
				sb.append("if(!horizontal.isEmpty() && vertical.isEmpty()) {" + NEW_LINE);
				sb.append(nextRuleClassExpressionBuilder.toString());
				sb.append("}");
			}

		}
		sb.append(NEW_LINE);
		sb.append("}catch(Exception e){");
		sb.append(NEW_LINE);

		sb.append(String.format(
				"throw new RuntimeException(\"Execution of grid: %s with version: %d failed , last Cell Executed: [R:\"+ruleStats.getCurrentRowIndex()+ \",C:\"+ruleStats.getCurrentColIndex()+\"]"
						+ ". Please check logs for details: \", e);",
				request.getName(), request.getVersion()));
		sb.append("}");
		sb.append(NEW_LINE);
		sb.append("}");
		sb.append(NEW_LINE);
		sb.append(String.format(
				"private  void decideHorizontal( %s requestData, final java.util.BitSet bitSet,RuleStatistics ruleStats) {",
				className));

		if (!decisionTable.getHorizontal().isEmpty()) {
			sb.append(NEW_LINE);
			sb.append("decide_H_0(requestData, bitSet,ruleStats);");
			sb.append(NEW_LINE);
			sb.append("}");
			sb.append(NEW_LINE);
			StringBuilder decideHFnqs = new StringBuilder();
			generateHorizontalDecideFnqs(decisionTable.getHorizontal(), decideHFnqs, "0", request, className, messages);
			sb.append(decideHFnqs);
		} else {
			sb.append("bitSet.set(H_0);" + NEW_LINE);
			sb.append("}" + NEW_LINE);
		}

		sb.append(String.format(
				"private  void decideVertical( %s requestData, final java.util.BitSet bitSet,RuleStatistics ruleStats) {",
				className));
		sb.append(NEW_LINE);
		sb.append("decide_V_0(requestData, bitSet,ruleStats);");
		sb.append(NEW_LINE);
		sb.append("}");
		sb.append(NEW_LINE);
		StringBuilder decideVFnqs = new StringBuilder();

		generateVerticalDecideFnqs(postExclusionVertical, decideVFnqs, "0", request, className, messages);
		sb.append(decideVFnqs);

		StringBuilder assignFnqs = new StringBuilder();
		generateAssignFnqs(decisionTable, H, V, assignFnqs, request, className, messages);
		sb.append(assignFnqs);
		sb.append(functionCalls.declarations());
		sb.append("public " + generatedClassName + "() { this(" + registryType + ".empty()); }" + NEW_LINE);
		sb.append("public " + generatedClassName + "(" + registryType + " functions) { "
				+ "this.registeredFunctions = java.util.Objects.requireNonNull(functions);" + NEW_LINE
				+ functionCalls.initializers() + "}" + NEW_LINE);

		sb.append("}");

		if (!messages.isEmpty()) {
			throw new ParsingException(messages);
		}

		return sb.toString();

	}

	private void getInitialDecisionCells(DtCell vertical, List<DtCell> postExclusionVertical) {

		if (!isMetaDataColumn(vertical)) {
			postExclusionVertical.add(vertical);
			return;
		}

		for (DtCell cell : vertical.getChilds()) {
			getInitialDecisionCells(cell, postExclusionVertical);
		}

	}

	private boolean isMetaDataColumn(DtCell vertical) {
		return Constants.META_DATA_COLUMNS.contains(vertical.getDecisionHeader().getContent().toString());

	}

	private void generateHorizontalDecideFnqs(List<DtCell> hChildCells, StringBuilder stringBuilder, String fncPostfix,
			RuleCreationRequest request, String className, List<ValidationMessage> messages) {
		if (hChildCells.isEmpty()) {
			return;
		}
		stringBuilder.append(String.format(
				"private  void decide_H_%s (%s requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {"
						+ NEW_LINE,
				fncPostfix, className));

		for (int i = 0; i < hChildCells.size(); i++) {

			DtCell cell = hChildCells.get(i);
			try {
			stringBuilder.append(String.format("%s(Commons.log(ruleStats,%d,%d,\"%s\") && %s) { " + NEW_LINE,
					determineConditionType(request.getDecisionMatchType(), i), cell.getRowStartIndex(),
					cell.getColStartIndex(), cell.getCellRef(),
					request.getExpressionParser().generateCode(cell, request, functionCalls)));
			}catch (Exception e) {
				messages.add(validationService.prepareValidationMessage(cell, "ERROR", "High",
						"Unable to parse the expression"));
				throw new RuntimeException(e);
			}
			if (hChildCells.get(i).isLeaf()) {
				stringBuilder.append(String.format("bitSet.set(H_%d);", H_BIT_COUNT));
				H_BIT_COUNT += 1;
				stringBuilder.append(NEW_LINE);
			} else {
				stringBuilder.append(
						String.format("decide_H_%s_%d(requestData , bitSet,ruleStats) ;" + NEW_LINE, fncPostfix, i));
				
			}
			addReturnStatement(stringBuilder, request.getDecisionMatchType());
			stringBuilder.append("}");
			stringBuilder.append(NEW_LINE);

		}
		stringBuilder.append("}");
		stringBuilder.append(NEW_LINE);
		for (int i = 0; i < hChildCells.size(); i++) {
			generateHorizontalDecideFnqs(hChildCells.get(i).getChilds(), stringBuilder, fncPostfix.concat("_" + i),
					request, className, messages);
		}

	}

	private void generateVerticalDecideFnqs(List<DtCell> vChildCells, StringBuilder stringBuilder, String fncPostfix,
			RuleCreationRequest request, String className, List<ValidationMessage> messages) {

		if (vChildCells.isEmpty()) {
			return;
		}

		stringBuilder.append(String.format(
				"private  void decide_V_%s (%s requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {"
						+ NEW_LINE,
				fncPostfix, className));

		for (int i = 0; i < vChildCells.size(); i++) {
			DtCell cell = vChildCells.get(i);
			try {
			stringBuilder.append(String.format("%s(Commons.log(ruleStats,%d,%d,\"%s\") && %s) { " + NEW_LINE,
					determineConditionType(request.getDecisionMatchType(), i), cell.getRowStartIndex(),
					cell.getColStartIndex(), cell.getCellRef(),
					request.getExpressionParser().generateCode(cell, request, functionCalls)));
			}catch (Exception e) {
				messages.add(validationService.prepareValidationMessage(cell, "ERROR", "High",
						"Unable to parse the expression"));
				throw new RuntimeException(e);
			}

			if (vChildCells.get(i).isLeaf() || vChildCells.get(0).getChilds().isEmpty()) {
				stringBuilder.append(String.format("bitSet.set(V_%d);", V_BIT_COUNT));
				stringBuilder.append(NEW_LINE);
				stringBuilder.append(String.format("ruleStats.getRuleExecuted().add(%dL);",
						Long.valueOf(vChildCells.get(i).getRowStartIndex())));
				V_BIT_COUNT += 1;
				stringBuilder.append(NEW_LINE);
			} else {
				stringBuilder.append(
						String.format("decide_V_%s_%d(requestData , bitSet,ruleStats) ;" + NEW_LINE, fncPostfix, i));
			}
			addReturnStatement(stringBuilder, request.getDecisionMatchType());
			stringBuilder.append("}");
			stringBuilder.append(NEW_LINE);

		}
		stringBuilder.append("}");
		stringBuilder.append(NEW_LINE);

		for (int i = 0; i < vChildCells.size(); i++) {

			generateVerticalDecideFnqs(vChildCells.get(i).getChilds(), stringBuilder, fncPostfix.concat("_" + i),
					request, className, messages);
		}
	}

	private void addReturnStatement(StringBuilder builder, DecisionMatchType matchType) {

		if (matchType == DecisionMatchType.MATCH_UNTIL) {
			builder.append(NEW_LINE);
			builder.append("if(!bitSet.isEmpty()){");
			builder.append(NEW_LINE);
			builder.append("return ;" + NEW_LINE + "}");
			builder.append(NEW_LINE);
		}

	}

	private String determineConditionType(DecisionMatchType matchType, int index) {
		return (matchType == DecisionMatchType.MATCH_ALL || matchType == DecisionMatchType.MATCH_UNTIL || index == 0)
				? "if"
				: "else if";
	}

	private void generateAssignFnqs(DecisionTable decisionTable, int H, int V, StringBuilder builder,
			RuleCreationRequest request, String className, List<ValidationMessage> messages) {
		builder.append(String.format(
				"private  void executeTableActions(%s requestData,final java.util.BitSet horizontal, final java.util.BitSet vertical,RuleStatistics ruleStats) {"
						+ NEW_LINE,
				className));

		Stream.iterate(0, i -> i + 1).limit(H).forEach(i -> {
			builder.append(String.format("%s(horizontal.get(%d)){" + NEW_LINE,
					determineConditionType(request.getDecisionMatchType(), i), i));
			builder.append(String.format("executeTableActions(requestData ,%s , vertical ,ruleStats);", i));
			builder.append(NEW_LINE + "}" + NEW_LINE);
		});

		builder.append(NEW_LINE + "}" + NEW_LINE);

		builder.append(String.format(
				"private  void executeTableActions(%s requestData, final int x, final java.util.BitSet vertical,RuleStatistics ruleStats) {"
						+ NEW_LINE,
				className));

		Stream.iterate(0, i -> i + 1).limit(V).forEach(i -> {
			builder.append(String.format("%s(vertical.get(%d)){" + NEW_LINE,
					determineConditionType(request.getDecisionMatchType(), i), i));
			builder.append(String.format("executeTableActions(requestData ,x , %d,ruleStats );", i));
			builder.append(NEW_LINE + "}" + NEW_LINE);
		});

		builder.append(NEW_LINE + "}" + NEW_LINE);

		builder.append(String.format(
				"private  void executeTableActions( %s requestData, final int x, final int y ,RuleStatistics ruleStats) { "
						+ NEW_LINE,
				className));

		List<String> assignFnqs = new ArrayList<>();

		Stream.iterate(0, i -> i + 1)
				.limit(decisionTable.getAssignSpanGroup().get(0).getChilds().get(0).getChilds().size()).forEach(i -> {
					builder.append(
							String.format("computationtableaction_%d(requestData , x , y,ruleStats) ;" + NEW_LINE, i));
					assignFnqs.add(generateAssignSwitch(decisionTable, i, H, V, request, className, messages));
				});

		builder.append(NEW_LINE + "}" + NEW_LINE);

		assignFnqs.forEach(builder::append);

	}

	private String generateAssignSwitch(DecisionTable decisionTable, Integer i, int h, int v,
			RuleCreationRequest request, String className, List<ValidationMessage> messages) {

		StringBuilder stringBuilder = new StringBuilder();
		List<String> assignMatrix = new ArrayList<>();
		stringBuilder.append(String.format(
				"private  void computationtableaction_%d( %s requestData, final int x, final int y,RuleStatistics ruleStats) {"
						+ NEW_LINE,
				i, className));
		stringBuilder.append("switch(x) {" + NEW_LINE);
		Stream.iterate(0, j -> j + 1).limit(h).forEach(j -> {
			stringBuilder.append(String.format("case %d :" + NEW_LINE, j));
			stringBuilder.append(String.format("matrix_%d_x_%d(requestData , y ,ruleStats);" + NEW_LINE, i, j));
			stringBuilder.append("break;" + NEW_LINE);
			assignMatrix.add(generateAssignMatrix(decisionTable, i, j, h, v, request, className, messages));
		});
		stringBuilder.append("default:" + NEW_LINE);

		stringBuilder.append("throw new java.lang.IllegalStateException() ;" + NEW_LINE);
		stringBuilder.append("}" + NEW_LINE);
		stringBuilder.append("}" + NEW_LINE);

		assignMatrix.forEach(s -> stringBuilder.append(s));

		return stringBuilder.toString();
	}

	private String generateAssignMatrix(DecisionTable decisionTable, int i, int j, int h, int v,
			RuleCreationRequest request, String className, List<ValidationMessage> messages) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format(
				"private  void matrix_%d_x_%d(%s requestData, final int y,RuleStatistics ruleStats) {" + NEW_LINE, i, j,
				className));
		stringBuilder.append("switch(y) {" + NEW_LINE);
		Stream.iterate(0, k -> k + 1).limit(v).forEach(k -> {
			stringBuilder.append(String.format("case %d :" + NEW_LINE, k));
			DtCell cell = decisionTable.getAssignSpanGroup().get(j).getChilds().get(k).getChilds().get(i);
			String headerName = cell.getAssignHeader().getContent().toString();
			stringBuilder.append(String.format("Commons.log(ruleStats,%d,%d,\"%s\");", cell.getRowStartIndex(),
					cell.getColStartIndex(), cell.getCellRef()) + NEW_LINE);
			appendSetterExpression(stringBuilder, headerName, cell.getContent().toString(), request, cell, messages);
			stringBuilder.append("break;" + NEW_LINE);
		});
		stringBuilder.append("default:" + NEW_LINE);
		stringBuilder.append("throw new java.lang.IllegalStateException() ;" + NEW_LINE);
		stringBuilder.append("}" + NEW_LINE);
		stringBuilder.append("}" + NEW_LINE);
		return stringBuilder.toString();

	}

	private void appendSetterExpression(StringBuilder builder, String property, String content,
			RuleCreationRequest request, DtCell cell, List<ValidationMessage> messages) {
		try {
			builder.append(request.getExpressionParser().generateCode(cell, request, functionCalls) + ';'
					+ NEW_LINE);
		} catch (Exception e) {
			messages.add(validationService.prepareValidationMessage(cell, "ERROR", "High",
					"Unable to parse the expression"));
			throw new RuntimeException(e);
		}

	}

	public String capitalizeFirstLetter(String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}

}
