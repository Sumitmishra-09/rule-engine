package com.act21.rule.engine.dsl.expression.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.act21.rule.engine.dsl.model.TypeReference;

public class Type {

	private String baseType;
	private List<Type> typeArguments;

	public Type(TypeReference typeRef) {
		this.baseType = typeRef.getIdentifier();
		this.typeArguments = new ArrayList<>();
		for (int i = 0; i < typeRef.getTypeArguments().size(); i++) {
			this.typeArguments.add(new Type(typeRef.getTypeArguments().get(i), null));
		}
	}

	public Type(String baseType, List<Type> typeArguments) {
		this.baseType = baseType;
		this.typeArguments = typeArguments != null ? typeArguments : new ArrayList<Type>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseType, typeArguments);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Type) {
			Type other = (Type) obj;

			if (this.typeArguments.size() != other.typeArguments.size())
				return false;

			for (int i = 0; i < this.typeArguments.size(); i++) {
				if (!this.typeArguments.get(i).equals(other.typeArguments.get(i)))
					return false;
			}

			return this.baseType.equals(other.baseType);
		}
		return false;
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
			this.typeArguments = new ArrayList<>();
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
