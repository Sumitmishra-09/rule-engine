package com.act21.impaktapps.rule.engine.service;

import static org.assertj.core.api.Assertions.catchException;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.act21.impaktapps.rule.engine.commons.Constants;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DtCell;

/**
 * Service for generating Excel representations of decision tables.
 */
public class ExcelWriter {

	public void write(DecisionTable decisionTable, OutputStream outputStream) throws IOException {
		try (XSSFWorkbook workbook = new XSSFWorkbook();) {

			XSSFSheet sheet = workbook.createSheet(decisionTable.getName());
			CellStyle headerStyle = createStyleWithFill(workbook, Constants.DECIDE_HEADER_COLOR);
			CellStyle assignHeaderStyle = createStyleWithFill(workbook, Constants.ASSIGN_HEADER_COLOR);
			CellStyle borderStyle = createBorderedStyle(workbook);
			// Write all header types
			write(sheet, headerStyle, decisionTable.getHorizontalHeaders());
			write(sheet, headerStyle, decisionTable.getVerticalHeaders());
			write(sheet, assignHeaderStyle, decisionTable.getAssignHeaders());

			// Write cell content
			write(sheet, borderStyle, decisionTable.getVertical());
			write(sheet, borderStyle, decisionTable.getHorizontal());
			write(sheet, borderStyle,
					decisionTable.getAssignSpanGroup().stream().flatMap(
							cellGroup -> cellGroup.getChilds().stream().flatMap(span -> span.getChilds().stream()))
							.collect(Collectors.toList()));
			workbook.write(outputStream);
		} finally {
			outputStream.close();
		}
	}

	private void write(Sheet sheet, CellStyle style, List<DtCell> dtCells) {
		for (DtCell dtCell : dtCells) {

			// Get or create row
			Row row = Optional.ofNullable(sheet.getRow(dtCell.getRowStartIndex()))
					.orElseGet(() -> sheet.createRow(dtCell.getRowStartIndex()));

			// Create and style the cell
			Cell cell = row.createCell(dtCell.getColStartIndex());
			cell.setCellValue(dtCell.getContent().toString());
			cell.setCellStyle(style);

			// Handle cell merging if needed
			if (needsMerging(dtCell.getColStartIndex(), dtCell.getColEndIndex(), dtCell.getRowStartIndex(),
					dtCell.getRowEndIndex())) {
				CellRangeAddress mergedCell = new CellRangeAddress(dtCell.getRowStartIndex(), dtCell.getRowEndIndex(),
						dtCell.getColStartIndex(), dtCell.getColEndIndex());
				sheet.addMergedRegion(mergedCell);
				applyBordersToMergedCell(sheet, mergedCell);
			}

			// Process child cells
			if (!dtCell.getChilds().isEmpty()) {
				for (DtCell child : dtCell.getChilds()) {
					write(sheet, style, List.of(child));
				}
			}
		}
	}

	/**
	 * Creates a cell style with fill color and borders
	 */
	private CellStyle createStyleWithFill(XSSFWorkbook workbook, String hexColor) {
		Color color = Color.decode("#" + hexColor.substring(2));
		XSSFColor xssfColor = new XSSFColor(color);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(xssfColor);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		applyBorderStyling(workbook, style);
		return style;
	}

	/**
	 * Creates a cell style with just borders
	 */
	private CellStyle createBorderedStyle(XSSFWorkbook workbook) {
		return applyBorderStyling(workbook, null);
	}

	/**
	 * Applies border styling to a cell style
	 */
	private CellStyle applyBorderStyling(XSSFWorkbook workbook, CellStyle style) {
		CellStyle cellStyle = style != null ? style : workbook.createCellStyle();

		// Apply borders
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);

		// Set border colors
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

		// Set alignment and text wrapping
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setWrapText(true);

		return cellStyle;
	}

	/**
	 * Applies borders to a merged cell region
	 */
	private void applyBordersToMergedCell(Sheet sheet, CellRangeAddress mergedRegion) {
		// Apply borders
		RegionUtil.setBorderTop(BorderStyle.THIN, mergedRegion, sheet);
		RegionUtil.setBorderBottom(BorderStyle.THIN, mergedRegion, sheet);
		RegionUtil.setBorderLeft(BorderStyle.THIN, mergedRegion, sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN, mergedRegion, sheet);

		// Set border colors
		RegionUtil.setTopBorderColor(IndexedColors.BLACK.getIndex(), mergedRegion, sheet);
		RegionUtil.setBottomBorderColor(IndexedColors.BLACK.getIndex(), mergedRegion, sheet);
		RegionUtil.setLeftBorderColor(IndexedColors.BLACK.getIndex(), mergedRegion, sheet);
		RegionUtil.setRightBorderColor(IndexedColors.BLACK.getIndex(), mergedRegion, sheet);
	}

	/**
	 * Checks if a cell needs to be merged based on start and end indices
	 */
	private boolean needsMerging(int colStart, int colEnd, int rowStart, int rowEnd) {
		return colEnd - colStart > 0 || rowEnd - rowStart > 0;
	}
}