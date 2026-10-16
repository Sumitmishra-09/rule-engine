package com.act21.impaktapps.rule.engine.migrator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MigratorService {
	
	private static final String CONTAINS_REGEX = "^contains\\(\\s*(.+?)\\s*\\)$";

	public String parse(String value) {

		List<String> rhsValues = new ArrayList<>();
		String val = "";
		if (isAnd(value)) {
			rhsValues = Arrays.asList(value.split("&&"));
			val = prepareExpression(rhsValues, "&&");
		} else if (isOr(value)) {
			rhsValues = Arrays.asList(value.split("\\|\\|"));
			val = prepareExpression(rhsValues, "||");
		} else {
			val = parseUnary(value);

		}
		return val;

	}

	public String prepareExpression(List<String> rhsValues, String seprator) {

		List<String> parsedExpressions = rhsValues.stream().map(this::parseUnary).toList();
		return String.join(seprator, parsedExpressions);
	}

	public String parseUnary(String value) {
		value = value.trim();
		Matcher containsMatcher = Pattern.compile(CONTAINS_REGEX).matcher(value);
		if (value.startsWith("!=")) {
			return "!= " + parseLiteral(value.replaceFirst("!=", "").trim());
		} else if (value.startsWith("==")) {
			return "== " + parseLiteral(value.replaceFirst("==", "").trim());
		} else if (containsMatcher.matches()) {
			String parsedExpression = parseLiteral(containsMatcher.group(1));
			return String.format("contains( %s )", parsedExpression);
		} else {
			return parseLiteral(value);
		}
	}

	public String parseLiteral(String value) {
		if (isWrappedWithDoubleDoubleQuotes(value)) {
			return value;
		}
		
		if(value.isEmpty()) {
			return value;
		}
		
		if(Arrays.asList("PASS","ALL").contains(value)) {
			return value;
		}

		return String.format("\"%s\"", value);

	}

	public static boolean isWrappedWithDoubleDoubleQuotes(String value) {
		return value != null && value.length() >= 2 && value.startsWith("\"") && value.endsWith("\"");
	}

	private boolean isOr(String value) {
		return value.contains("||");
	}

	private boolean isAnd(String value) {
		return value.contains("&&");
	}



}
