package com.act21.impaktapps.rule.engine.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.commons.Constants;
import com.act21.impaktapps.rule.engine.service.RuleDataFormatter;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DtCell;
import com.act21.impaktapps.rule.engine.table.DtCellType;
import com.act21.impaktapps.rule.engine.validation.ValidationMessage;
import com.act21.impaktapps.rule.engine.validation.ValidationService;

public class SheetHandler extends DefaultHandler {

	private boolean isValue = false;
	private Object cellValue;
	private String cellType;
	private DecisionTable decisionTable;
	private boolean foundFirstRow = false;
	private boolean foundFirstCell = false;
	private DtCell parentCell = null;
	private boolean isFirstAssignHeaderVisited = false;
	private List<DtCell> mergedCell;
	private DtCell cell = null;
	private int cellIndex = -1;
	private StylesTable stylesTable;
	private SharedStringsTable sst;
	List<ValidationMessage> messages;
	private ValidationService validationService;
	private List<DtCell> prevHorizontalDecisions = new ArrayList<>();
	List<DtCell> currentRow = new ArrayList<>();
	private RuleCreationRequest request;
	private boolean skipAllFurtherRows;
	private boolean isFirstNonEmptyCellFound;
	private int[] currentCellTraker = { 0, 0 };
	private String styleIndex;
	private RuleDataFormatter ruleDataFormatter = new RuleDataFormatter();

	public SheetHandler(StylesTable stylesTable, SharedStringsTable sst, DecisionTable decisionTable,
			List<DtCell> mergedCell, List<ValidationMessage> messages, RuleCreationRequest request,
			ValidationService validationService) {
		this.mergedCell = mergedCell;
		this.stylesTable = stylesTable;
		this.sst = sst;
		this.decisionTable = decisionTable;
		this.messages = messages;
		this.request = request;
		this.validationService = validationService;

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {

		if ("row".equals(qName)) {
			isFirstNonEmptyCellFound = false;
			parentCell = null;

		} else if ("c".equals(qName)) {
			if (!skipAllFurtherRows) {
				parseCell(attributes);
			} else {
				cell = null;
			}

		} else if ("v".equals(qName)) {
			isValue = true;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		incrementTracker(qName);

		if ("v".equals(qName)) {
			assignCellValue();
		} else if ("c".equals(qName)) {
			onCellEnd();
		}

	}

	private void incrementTracker(String qName) {
		if ("row".equals(qName)) {
			currentCellTraker[0] = currentCellTraker[0] + 1;
			currentCellTraker[1] = 0;
		} else if ("c".equals(qName)) {
			currentCellTraker[1] = currentCellTraker[1] + 1;
		}
	}

	private void onCellEnd() {

		if (!isFirstNonEmptyCellFound) {
			isFirstNonEmptyCellFound = (cell != null && !cell.getContent().toString().isEmpty())
					|| (parentCell != null && !parentCell.getContent().toString().isEmpty());
		}

		if (cell == null) {
			return;
		}
		setCellFormatParameters(cell);
		cell.setVisited(true);

		if (isHeader(cell) && cell.getContent() != null && request.getSchema().isIncludeMetaColumns()) {
			cell.setMetaDataColumn(isMetaDataColumn(cell));
		}
		if (isMergedCell(cell)) {
			mergedCell.set(cellIndex, cell);
		}
		if (request.isDoValidate()) {
			validationService.validateCell(cell, parentCell, decisionTable, request, messages);
		}
		assignParentCell();
	}

	private boolean isMetaDataColumn(DtCell cell) {
		return Constants.META_DATA_COLUMNS.contains(cell.getContent().toString());
	}

	private boolean isHeader(DtCell cell2) {
		return DtCellType.ASSIGN_HEADER.equals(cell2.getDtCellType())
				|| DtCellType.DECISION_HEADER_H.equals(cell2.getDtCellType())
				|| DtCellType.DECISION_HEADER_V.equals(cell2.getDtCellType());
	}

	private boolean isMergedCell(DtCell cell) {

		return cell.getRowStartIndex() != cell.getRowEndIndex() || cell.getColStartIndex() != cell.getColEndIndex();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (isValue) {
			cellValue = new String(ch, start, length);
		}
	}

	private void parseCell(Attributes attributes) {

		String cellRef = attributes.getValue("r");

		cell = new DtCell(cellRef);
		cellType = attributes.getValue("t") != null ? attributes.getValue("t") : "n";

		XSSFColor fillColor = getCellColor(attributes);

		if (!foundFirstRow) {
			decisionTable.setFirstRowIndex(cell.getRowStartIndex());
			foundFirstRow = true;

		}

		if (!foundFirstCell) {
			decisionTable.setFirstColIndex(cell.getColStartIndex());
			if (fillColor != null) {
				validationService.firstCellValidation(cell, fillColor.getARGBHex(), messages);
			}
			foundFirstCell = true;

		}

		if (cell.getColStartIndex() != currentCellTraker[1]) {
			throw new RuntimeException(
					String.format("%s : Cell %s is not readable", decisionTable.getName(), cell.getCellRef()));
		}

		if (fillColor != null && isHeaderColor(fillColor)) {
			collectHeaders(fillColor);
		} else {
			collectDecisionsAndAssign();
		}

	}

	public void setCellFormatParameters(DtCell cell) {
		String formatString = "General";
		short numFmtId = 0;
		if (styleIndex != null) {
			CTXf cellXf = stylesTable.getCellXfAt(Integer.parseInt(styleIndex));
			numFmtId = (short) cellXf.getNumFmtId();

			formatString = stylesTable.getNumberFormatAt(numFmtId);
			if (formatString == null) {
				formatString = BuiltinFormats.getBuiltinFormat(numFmtId);
			}
		}
		cell.setCellFormatId(numFmtId);
		cell.setCellFormat(formatString);
	}

	private XSSFColor getCellColor(Attributes attributes) {
		styleIndex = attributes.getValue("s");
		if (styleIndex != null) {
			int styleIndexInt = Integer.parseInt(styleIndex);
			XSSFCellStyle cellStyle = stylesTable.getStyleAt(styleIndexInt);

			return cellStyle.getFillForegroundXSSFColor();
		}
		return null;
	}

	private boolean isHeaderColor(XSSFColor fillColor) {
		return Constants.DECIDE_HEADER_COLOR.equalsIgnoreCase(fillColor.getARGBHex())
				|| Constants.ASSIGN_HEADER_COLOR.equalsIgnoreCase(fillColor.getARGBHex());
	}

	private boolean isDecideHeader(String fillColor) {
		return fillColor.equalsIgnoreCase(Constants.DECIDE_HEADER_COLOR);
	}

	private boolean isAssignHeader(String fillColor) {
		return fillColor.equalsIgnoreCase(Constants.ASSIGN_HEADER_COLOR);
	}

	private int getMergedCell(DtCell cell) {
		return IntStream.range(0, mergedCell.size()).filter(i -> {
			DtCell c = mergedCell.get(i);
			return c.getRowStartIndex() <= cell.getRowStartIndex() && c.getRowEndIndex() >= cell.getRowEndIndex()
					&& c.getColStartIndex() <= cell.getColStartIndex() && c.getColEndIndex() >= cell.getColEndIndex();
		}).findFirst().orElse(-1);
	}

	private void createAssignSpanGroup() {
		for (DtCell leafCell : currentRow) {
			leafCell.setLeaf(true);
			decisionTable.getAssignSpanGroup()
					.add(new DtCell(leafCell.getRowStartIndex(), leafCell.getRowEndIndex(), leafCell.getColStartIndex(),
							leafCell.getColEndIndex(), DtCellType.ASSIGN_SPAN_GROUP, null, null, false));

		}
	}

	private void collectDecisionsAndAssign() {

		if (!isFirstAssignHeaderVisited) {
			collectHorizontalDecision();
		} else if (isAssign(cell)) {
			if (!isFirstNonEmptyCellFound) {
				decisionTable.getVertical().remove(decisionTable.getVertical().size() - 1);

				cell = null;
				skipAllFurtherRows = true;
				return;
			}
			cell.setDtCellType(DtCellType.ASSIGN);
			cell.setAssignHeader(getAssignHeaderCell(cell.getColStartIndex()));
			int idx = cell.getRowStartIndex()
					- (decisionTable.getFirstRowIndex() + decisionTable.getHorizontalHeaders().size() + 1);
			decisionTable.addToSpanGroup(cell, idx);
		} else {
			collectVerticalDecisions();
		}
	}

	private void collectVerticalDecisions() {
		cellIndex = getMergedCell(cell);
		DtCell newCell = null;
		if (cellIndex != -1) {
			newCell = mergedCell.get(cellIndex);
		}
		if (newCell != null) {
			if (newCell.isVisited()) {
				parentCell = newCell;
				cell = null;
				return;
			}
			cell = newCell;

		}
		cell.setDtCellType(DtCellType.DECISION_V);
		cell.setDecisionHeader(getVerticalHeaderCell(cell.getColStartIndex()));

		if (cell.getColEndIndex() == decisionTable.getVerticalHeaders()
				.get(decisionTable.getVerticalHeaders().size() - 1).getColEndIndex()) {
			cell.setLeaf(true);
		}

		if (cell.getColStartIndex() == decisionTable.getFirstColIndex()) {
			decisionTable.getVertical().add(cell);
		} else if (parentCell != null) {
			parentCell.getChilds().add(cell);
		}

	}

	private void collectHorizontalDecision() {
		cellIndex = getMergedCell(cell);
		DtCell newCell = null;
		if (cellIndex != -1) {
			newCell = mergedCell.get(cellIndex);
		}

		if (newCell != null) {
			if (newCell.isVisited()) {
				cell = null;
				return;
			}

			cell = newCell;

		}
		cell.setDtCellType(DtCellType.DECISION_H);

		if (!decisionTable.getHorizontalHeaders().isEmpty()) {
			cell.setDecisionHeader(
					decisionTable.getHorizontalHeaders().get(decisionTable.getHorizontalHeaders().size() - 1));
		}

		if (!currentRow.isEmpty() && cell.getRowStartIndex() != currentRow.get(0).getRowStartIndex()) {
			prevHorizontalDecisions.clear();
			prevHorizontalDecisions.addAll(currentRow);
			currentRow.clear();
		}
		addCellToParentCell();

	}

	private void addCellToParentCell() {

		if (prevHorizontalDecisions.isEmpty()) {
			decisionTable.getHorizontal().add(cell);
			currentRow.add(cell);
			return;
		}
		for (DtCell prevHorizontal : prevHorizontalDecisions) {
			if (prevHorizontal.getColStartIndex() <= cell.getColStartIndex()
					&& prevHorizontal.getColEndIndex() >= cell.getColEndIndex()) {
				prevHorizontal.getChilds().add(cell);
				currentRow.add(cell);
			}
		}

	}

	private void collectHeaders(XSSFColor fillColor) {
		if (isDecideHeader(fillColor.getARGBHex())) {
			cellIndex = getMergedCell(cell);
			DtCell newCell = null;
			if (cellIndex != -1) {
				newCell = mergedCell.get(cellIndex);
			}

			if (newCell != null) {
				if (newCell.isVisited()) {
					cell = null;
					return;

				}
				cell = newCell;
			}

			cell.setDtCellType(DtCellType.DECISION_HEADER_H);
			decisionTable.getHorizontalHeaders().add(cell);
		} else if (isAssignHeader(fillColor.getARGBHex())) {
			processAssignHeaders();
		}
	}

	private void processAssignHeaders() {
		if (!isFirstAssignHeaderVisited) {
			List<DtCell> horizontalHeaders = decisionTable.getHorizontalHeaders();
			List<DtCell> headersToBeRemoved = new ArrayList<>();
			horizontalHeaders.stream().forEach(h -> {
				if (isVerticalHeader(h)) {
					h.setDtCellType(DtCellType.DECISION_HEADER_V);
					decisionTable.getVerticalHeaders().add(h);
					headersToBeRemoved.add(h);
				}
			});
			horizontalHeaders.removeAll(headersToBeRemoved);
			createAssignSpanGroup();
			isFirstAssignHeaderVisited = true;
		}

		cell.setDtCellType(DtCellType.ASSIGN_HEADER);
		createAndExpandAssignGroupWhenNoHorizontal(cell);
		decisionTable.getAssignHeaders().add(cell);
	}

	private boolean isVerticalHeader(DtCell dtCell) {
		return dtCell.getRowStartIndex() == cell.getRowStartIndex();
	}

	private DtCell getAssignHeaderCell(int index) {
		return this.decisionTable.getAssignHeaders().stream()
				.filter(h -> h.getColStartIndex() == index && h.getDtCellType() == DtCellType.ASSIGN_HEADER).findFirst()
				.orElse(null);

	}

	private DtCell getVerticalHeaderCell(int index) {
		return this.decisionTable.getVerticalHeaders().stream()
				.filter(h -> h.getColStartIndex() == index && h.getDtCellType() == DtCellType.DECISION_HEADER_V)
				.findFirst().orElse(null);

	}

	private void createAndExpandAssignGroupWhenNoHorizontal(DtCell cell) {
		if (currentRow.isEmpty()) {

			if (decisionTable.getAssignSpanGroup().isEmpty()) {
				decisionTable.getAssignSpanGroup()
						.add(new DtCell(cell.getRowStartIndex(), cell.getRowEndIndex(), cell.getColStartIndex(),
								cell.getColEndIndex(), DtCellType.ASSIGN_SPAN_GROUP, null, null, false));
				return;
			}
			DtCell spanGroup = decisionTable.getAssignSpanGroup().get(0);
			spanGroup.setColEndIndex(cell.getColEndIndex());
		}

	}

	private boolean isAssign(DtCell cell) {

		return this.decisionTable.getAssignHeaders().stream()
				.anyMatch(header -> header.getColStartIndex() == cell.getColStartIndex());

	}

	private void assignCellValue() {
		if (cell != null) {
			isValue = false;
			cell.setContent(
					ruleDataFormatter.formatCellValue(styleIndex, cellType, stylesTable, sst, cellValue.toString()));
		}
	}

	private void assignParentCell() {
		if (cell == null)
			return;
		if (DtCellType.DECISION_V.equals(cell.getDtCellType()) || DtCellType.DECISION_H.equals(cell.getDtCellType())) {
			parentCell = cell;
		}
	}
}
