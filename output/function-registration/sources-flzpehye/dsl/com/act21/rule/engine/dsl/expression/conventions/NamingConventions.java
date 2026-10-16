package com.act21.rule.engine.dsl.expression.conventions;

public class NamingConventions {

	private static char[] suggestAccessorName(char[] fieldName) {
		fieldName[0] = Character.toUpperCase(fieldName[0]);
		return fieldName;
	}

	public static String suggestGetterName(char[] fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append("get");
		sb.append(suggestAccessorName(fieldName));
		return sb.toString();
	}

	public static String suggestSetterName(char[] fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append("set");
		sb.append(suggestAccessorName(fieldName));
		return sb.toString();
	}
	
	 public static String toCanonicalName(String className) {
	        if (className == null || className.isEmpty()) return className;
	        return className.substring(0, 1).toLowerCase() + className.substring(1);
	 }
	
}
