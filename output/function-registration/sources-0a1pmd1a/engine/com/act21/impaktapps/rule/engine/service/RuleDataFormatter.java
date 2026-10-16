package com.act21.impaktapps.rule.engine.service;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;

public class RuleDataFormatter {

	public String formatCellValue(String styleIndex, String cellType, StylesTable stylesTable, SharedStringsTable sst,
			String cellValue) {

		DataFormatter formatter = new DataFormatter();

		CellStyle style = null;

		if (styleIndex != null) {
			int cellStyleIndex = Integer.parseInt(styleIndex);
			style = stylesTable.getStyleAt(cellStyleIndex);
		}
		if(style == null) {
			style =  stylesTable.getStyleAt(0);
		}

		if ("s".equals(cellType)) {
			int index = Integer.parseInt(cellValue);
			cellValue = sst.getEntryAt(index).getT();
		} else if ("b".equals(cellType)) {
			cellValue = "1".equals(cellValue) ? "true" : "false";
		} else if ("n".equals(cellType)) {

			try {
				double numericValue = Double.parseDouble(cellValue);
				if (style != null && style.getDataFormatString() != null) {
					cellValue = formatter.formatRawCellContents(numericValue, style.getDataFormat(),
							style.getDataFormatString());
				}
			} catch (NumberFormatException e) {
				return cellValue.trim();
			}

		}
		return cellValue.trim();
	}
}
