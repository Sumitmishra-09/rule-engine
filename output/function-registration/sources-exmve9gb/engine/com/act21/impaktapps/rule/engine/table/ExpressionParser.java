package com.act21.impaktapps.rule.engine.table;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.commons.Commons;
import com.act21.impaktapps.rule.engine.commons.Constants;
import com.act21.impaktapps.rule.engine.validation.ValidationMessage;

public class ExpressionParser {

	private static final String STRING_TYPE = "java.lang.String";
	private static final String RANGE_REGEX = "^[\\[\\]](\\d{2}/\\d{2}/\\d{4}|\\d{4}/\\d{2}/\\d{2}|\\d*\\.?\\d+)\\s*[, -]\\s*(\\d{2}/\\d{2}/\\d{4}|\\d{4}/\\d{2}/\\d{2}|\\d*\\.?\\d+)[\\[\\]]$";
	private static final String CONTAINS_REGEX = "^contains\\(\\s*(.+?)\\s*\\)$";

	public String parse(DtCell cell, RuleCreationRequest request, List<ValidationMessage> messages,
			String propertyType) {

		List<String> rhsValues;
		String value = cell.getContent().toString().trim();

		if (Commons.isDecideCell(cell) && (value == null || value.isBlank() || isPassCondition(value))) {
			return "1==1";
		}

		if (Commons.isDecideCell(cell) && isAnd(value)) {
			rhsValues = Arrays.asList(value.split("&&"));
			return prepareExpression(rhsValues, cell, request, messages, propertyType, "&&");
		} else if (Commons.isDecideCell(cell) && isOr(value)) {
			rhsValues = Arrays.asList(value.split("\\|\\|"));
			return prepareExpression(rhsValues, cell, request, messages, propertyType, "||");
		} else {
			return parseUnary(value, cell, messages, request, propertyType);
		}

	}

	public String prepareExpression(List<String> rhsValues, DtCell cell, RuleCreationRequest request,
			List<ValidationMessage> messages, String propertyType, String seprator) {

		List<String> parsedExpressions = rhsValues.stream()
				.map(values -> parseUnary(values, cell, messages, request, propertyType)).toList();
		return String.join(seprator, parsedExpressions);
	}

	public String parseUnary(String value, DtCell cell, List<ValidationMessage> messages, RuleCreationRequest request,
			String propertyType) {
		value = value.trim();
		String property = cell.getDecisionHeader() != null ? cell.getDecisionHeader().getContent().toString()
				: cell.getAssignHeader().getContent().toString();
		boolean isDecisionCell = Commons.isDecideCell(cell);
		boolean isStringType = STRING_TYPE.equals(propertyType);
		boolean ignoreCase = request.isIgnoreCase();

		Matcher bracesMatcher = Pattern.compile(RANGE_REGEX).matcher(value);
		Matcher containsMatcher = Pattern.compile(CONTAINS_REGEX).matcher(value);

		String getterExpr = getterMethodExpression(property);

		if (isDecisionCell && !isStringType) {
			if (value.startsWith("<=")) {
				String parsedExpression = parseLiteral(value.replaceFirst("<=", ""), propertyType, cell, messages);
				return generateCompareToExpression(getterMethodExpression(property), parsedExpression, "<=");
			} else if (value.startsWith("<") || value.startsWith("upto")) {
				String parsedExpression = parseLiteral(value.replaceFirst("<", ""), propertyType, cell, messages);
				return generateCompareToExpression(getterMethodExpression(property), parsedExpression, "<");
			} else if (value.startsWith(">=")) {
				String parsedExpression = parseLiteral(value.replaceFirst(">=", ""), propertyType, cell, messages);
				return generateCompareToExpression(getterMethodExpression(property), parsedExpression, ">=");
			} else if (value.startsWith(">")) {
				String parsedExpression = parseLiteral(value.replaceFirst(">", ""), propertyType, cell, messages);
				return generateCompareToExpression(getterMethodExpression(property), parsedExpression, ">");
			} else if (bracesMatcher.matches()) {
				validateRangeExpression(bracesMatcher.groupCount(), cell, messages);
				String firstValue = parseLiteral(bracesMatcher.group(1), propertyType, cell, messages);
				String secondValue = parseLiteral(bracesMatcher.group(2), propertyType, cell, messages);

				return prepareInclusiveExclusiveExpression(value, property, firstValue, secondValue);
			}
		}

		if (isDecisionCell && value.startsWith("!=")) {
			String parsedExpression = parseLiteral(value.replaceFirst("!=", ""), propertyType, cell, messages);
			return ignoreCase && isStringType ? String.format("!%s.equalsIgnoreCase(%s)", getterExpr, parsedExpression)
					: String.format("!%s.equals(%s)", getterExpr, parsedExpression);
		}

		if (isDecisionCell && isStringType && containsMatcher.matches()) {
			String parsedExpression = parseLiteral(containsMatcher.group(1), propertyType, cell, messages);
			return String.format("%s.contains(%s)", getterExpr, parsedExpression);
		}

		String parsedExpression = parseLiteral(value, propertyType, cell, messages);
		return ignoreCase && isStringType ? String.format("%s.equalsIgnoreCase(%s)", getterExpr, parsedExpression)
				: String.format("%s.equals(%s)", getterExpr, parsedExpression);
	}

	private void validateRangeExpression(int groupCount, DtCell cell, List<ValidationMessage> messages) {
		if (groupCount > 2) {
			ValidationMessage message = new ValidationMessage();

			message.setMessageType("Error");
			message.setSeverity("High");
			message.setDescription("Range expression cannot contain more than two values");
			if (cell != null) {
				message.setCellNum("[" + cell.getRowStartIndex() + "," + cell.getColStartIndex() + "]");

			}

			messages.add(message);
		}
	}

	private String prepareInclusiveExclusiveExpression(String value, String property, String firstValue,
			String secondValue) {
		String leftExpression = value.startsWith("[")
				? generateCompareToExpression(getterMethodExpression(property), firstValue, ">=")
				: generateCompareToExpression(getterMethodExpression(property), firstValue, ">");

		String rightExpression = value.endsWith("]")
				? generateCompareToExpression(getterMethodExpression(property), secondValue, "<=")
				: generateCompareToExpression(getterMethodExpression(property), secondValue, "<");

		return String.format("%s&&%s", leftExpression, rightExpression);
	}

	private String generateCompareToExpression(String left, String right, String operator) {
		return String.format("%s.compareTo( %s )%s0", left, right, operator);
	}

	public String parseLiteral(String value, String propertyType, DtCell cell, List<ValidationMessage> messages) {
		try {
			value = value.trim();
			return switch (propertyType) {
			case "java.lang.Integer" -> {
				Integer.parseInt(value);
				yield String.format("Integer.parseInt(\"%s\")", value);
			}
			case "java.lang.Long" -> {
				Long.parseLong(value);
				yield String.format("Long.parseLong(\"%s\")", value);
			}
			case "java.lang.Double" -> {
				Double.parseDouble(value);
				yield String.format("Double.parseDouble(\"%s\")", value);
			}
			case "java.lang.Float" -> {
				Float.parseFloat(value);
				yield String.format("Float.parseFloat(\"%s\")", value);
			}
			case "java.lang.Boolean" -> {
				value = "1".equals(value) ? "true" : "false";
				Boolean.parseBoolean(value);
				yield String.format("Boolean.parseBoolean(\"%s\")", value);
			}
			case "java.lang.String" -> String.format("\"%s\"", value);
			case "java.math.BigDecimal" -> {
				new BigDecimal(value);
				yield String.format("new BigDecimal(\"%s\")", value);
			}
			case "java.math.BigInteger" -> {
				new BigInteger(value);
				yield String.format("new BigInteger(\"%s\")", value);
			}
			case "java.util.Date" -> {

				if (!value.isEmpty()) {
					Commons.parse(value);
				} else {
					value = null;
				}
				yield String.format("Commons.parse(\"%s\")", value);
			}
			default -> throw new UnsupportedOperationException("Unsupported property type: " + propertyType);
			};

		} catch (Exception e) {
			ValidationMessage message = new ValidationMessage();

			message.setMessageType("Error");
			message.setSeverity("High");
			message.setDescription(String.format("Unable to parse %s to %s", value,getTypeName(propertyType)));
			if (cell != null) {
				message.setCellNum(cell.getCellRef());

			}

			messages.add(message);
			return "";
		}

	}

	private String getTypeName(String propertyType) {
		if(Constants.NUMBER_TYPE.contains(propertyType)) {
			return "number";
		}else if("java.lang.Boolean".equals(propertyType)) {
			return "true/false";
		}else if("java.util.Date".equals(propertyType)) {
			return "date";
		}
		return null;
	}

	private boolean isOr(String value) {
		return value.contains("||");
	}

	private boolean isAnd(String value) {
		return value.contains("&&");
	}

	private String getterMethodExpression(String property) {
		return "requestData.get" + Character.toUpperCase(property.charAt(0)) + property.substring(1) + "()";
	}

	private boolean isPassCondition(String value) {
		return Constants.PASS_CONDITIONS.contains(value);
	}

}
