package com.act21.impaktapps.rule.engine.api;

import java.util.List;

import com.act21.rule.engine.dsl.expression.util.Type;

public class PropertySchema {

	private String name;
	private List possibleValues;
	private Type type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getPossibleValues() {
		return possibleValues;
	}

	public void setPossibleValues(List possibleValues) {
		this.possibleValues = possibleValues;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
