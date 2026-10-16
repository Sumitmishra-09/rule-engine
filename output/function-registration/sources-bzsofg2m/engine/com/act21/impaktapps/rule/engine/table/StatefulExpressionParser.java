package com.act21.impaktapps.rule.engine.table;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.xtext.validation.Issue;

import com.act21.impaktapps.rule.engine.api.PropertySchema;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.validation.ValidationService;
import com.act21.rule.engine.dsl.expression.runtime.ExpressionParser;
import com.act21.rule.engine.dsl.expression.runtime.VariableSchema;
import com.act21.rule.engine.dsl.expression.util.Type;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;

public class StatefulExpressionParser {

	private static final Logger LOGGER = LogManager.getLogger(StatefulExpressionParser.class);
	private ExpressionParser expressionParser;
	private ValidationService validationService = new ValidationService();

	public StatefulExpressionParser(Map<String, PropertySchema> propertySchema, Set<String> restrictedChars) {
		this(propertySchema, restrictedChars, FunctionRegistry.empty());
	}

	public StatefulExpressionParser(Map<String, PropertySchema> propertySchema, Set<String> restrictedChars,
			FunctionRegistry functions) {
		init(propertySchema, restrictedChars, functions);
	}

	private void init(Map<String, PropertySchema> propertySchema, Set<String> restrictedChars, FunctionRegistry functions) {
		Map<String, VariableSchema> variableMap = new HashMap<>();
		for (String key : propertySchema.keySet()) {
			PropertySchema ps = propertySchema.get(key);
			Type type = ps.getType();
			variableMap.put(key, new VariableSchema(type, ps.getPossibleValues(), null));
		}
		try {
			this.expressionParser = new ExpressionParser(variableMap, restrictedChars, functions);
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, e);
			throw new RuntimeException(e);
		}
	}

	public String generateCode(DtCell cell, RuleCreationRequest request) {
		try {
			this.expressionParser.parse(convertToExpression(cell));
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("isIgnoreCase", request.isIgnoreCase());
			return this.expressionParser.generateCode(args);
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, e);
			throw new RuntimeException(e);
		}
	}

	public List<Issue> validateCell(DtCell cell) {
		try {
			this.expressionParser.parse(convertToExpression(cell));
			return this.expressionParser.validate();
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, e);
			throw new RuntimeException(e);
		}
	}

	public static String convertToExpression(DtCell cell) {
		if (cell.getAssignHeader() != null) {
			return "assign " + cell.getAssignHeader().getContent() + ":" + cell.getContent();
		}
		if (cell.getDecisionHeader() != null) {
			return "if " + cell.getDecisionHeader().getContent() + ":" + cell.getContent();
		}
		return "";
	}
}
