package com.act21.impaktapps.rule.engine.api;

import java.util.Map;

public class Schema {

	private boolean includeMetaColumns;
	private Map<String, PropertySchema> propertySchemaMap;

	public Schema(Map<String, PropertySchema> propertySchemaMap, boolean includeMetaColumns) {
		this.propertySchemaMap = propertySchemaMap;
		this.includeMetaColumns = includeMetaColumns;
	}

	public boolean isIncludeMetaColumns() {
		return includeMetaColumns;
	}

	public void setIncludeMetaColumns(boolean includeMetaColumns) {
		this.includeMetaColumns = includeMetaColumns;
	}

	public Map<String, PropertySchema> getPropertySchemaMap() {
		return propertySchemaMap;
	}

}
