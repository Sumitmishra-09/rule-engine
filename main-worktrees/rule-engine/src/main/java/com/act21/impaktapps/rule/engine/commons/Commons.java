package com.act21.impaktapps.rule.engine.commons;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.act21.impaktapps.rule.engine.api.PropertySchema;
import com.act21.impaktapps.rule.engine.api.RuleStatistics;
import com.act21.impaktapps.rule.engine.table.DtCell;
import com.act21.impaktapps.rule.engine.table.DtCellType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Commons {

	private static final Logger logger = LoggerFactory.getLogger(Commons.class);
	public static final ObjectMapper OBJECT_MAPPER;

	static {
		OBJECT_MAPPER = new ObjectMapper();
	}

	private Commons() {
	}

	public static Date parse(String date, SimpleDateFormat simpleDateFormat) {
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			logger.error("Invalid date format: {}", date);
			throw new RuntimeException(e);
		}
	}

	public static Date parse(String dateString) {
		try {
			LocalDate localDate = LocalDate.parse(dateString, Constants.RULE_ENGINE_DEFAULT_DATE_FORMAT);
			return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (IllegalStateException e) {
			throw new java.lang.IllegalStateException("Unable to parse date :" + dateString);
		}
	}

	public static Map<String, PropertySchema> getPropertySchemaMap(String className) {
		try {
			Class modelClass = Class.forName(className);
			Field[] fields = modelClass.getDeclaredFields();
			Map<String, PropertySchema> propertySchemaMap = new HashMap<>();

			for (Field field : fields) {
				PropertySchema propertySchema = new PropertySchema();
				propertySchema.setName(field.getName());
				propertySchema.setType(new com.act21.rule.engine.dsl.expression.runtime.Type(field));
				propertySchemaMap.put(field.getName(), propertySchema);
			}
			return propertySchemaMap;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean isNumber(String value) {
		try {
			Long.parseLong(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static Type getParameterizedTypeName(Type type) {

		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type[] typeArguments = parameterizedType.getActualTypeArguments();
		return typeArguments[0];

	}

	public static boolean compare(DtCell cell1, DtCell cell2) {
		return cell1.getContent().toString().trim().equals(cell2.getContent().toString().trim())
				&& cell1.getColStartIndex() == cell2.getColStartIndex()
				&& cell1.getColEndIndex() == cell2.getColEndIndex()
				&& cell1.getRowStartIndex() == cell2.getRowStartIndex()
				&& cell1.getRowEndIndex() == cell2.getRowEndIndex()
				&& cell1.getDtCellType().equals(cell2.getDtCellType());
	}

	public static boolean isDate(String value) {
		try {
			parse(value);
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}

	public static boolean log(RuleStatistics stats, int row, int col, String cellRef) {
		stats.setCurrentRowIndex(row);
		stats.setCurrentColIndex(col);
		stats.setCellRef(cellRef);
		return true;
	}

	public static boolean isDecideCell(DtCell cell) {
		return DtCellType.DECISION_H.equals(cell.getDtCellType()) || DtCellType.DECISION_V.equals(cell.getDtCellType());
	}
}
