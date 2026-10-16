package com.act21.rule.engine.dsl.expression.runtime;

import java.util.List;

import com.act21.rule.engine.dsl.expression.util.Type;

public class VariableSchema {

	private Type type;
	private List<Object> values;
	private String prefix;

	public VariableSchema(Type type, List<Object> values, String prefix) {
		this.type = type;
		this.values = values;
		this.prefix = prefix;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Object> getValues() {
		return values;
	}

	public void setValues(List<Object> values) {
		this.values = values;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
