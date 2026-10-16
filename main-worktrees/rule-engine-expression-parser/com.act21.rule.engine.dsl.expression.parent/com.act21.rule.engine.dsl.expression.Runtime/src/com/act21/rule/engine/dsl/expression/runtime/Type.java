package com.act21.rule.engine.dsl.expression.runtime;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Type {

	private String baseType;
	private List<Type> typeArguments;

	public Type(String baseType, List<Type> typeArguments) {
		this.baseType = baseType;
		this.typeArguments = typeArguments;
	}

	public Type(java.lang.reflect.Type type) {
		createType(type);
	}

	public List<Type> getTypeArguments() {
		return typeArguments;
	}

	public void setTypeArguments(List<Type> typeArguments) {
		this.typeArguments = typeArguments;
	}

	public Type(Field field) {
		java.lang.reflect.Type type = field.getGenericType();
		createType(type);
	}

	private void createType(java.lang.reflect.Type type) {
		if (type instanceof ParameterizedType) {
			this.baseType = ((ParameterizedType) type).getRawType().getTypeName();
			this.typeArguments = new ArrayList<Type>();
			for (int i = 0; i < ((ParameterizedType) type).getActualTypeArguments().length; i++) {
				this.typeArguments.add(new Type(((ParameterizedType) type).getActualTypeArguments()[i]));
			}
		} else {
			this.baseType = type.getTypeName();
		}
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public static boolean isCollection(Type type) {
		if (type.getBaseType().equals("java.util.List") || type.getBaseType().equals("java.util.Map")) {
			return true;
		}
		return false;
	}

}
