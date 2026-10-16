package com.act21.impaktapps.rule.engine.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;

public class DtCell implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rowStartIndex;
	private int rowEndIndex;
	private DtCell decisionHeader;
	private DtCell assignHeader;
	private int colStartIndex;
	private int colEndIndex;
	private DtCellType dtCellType;
	private Object content = "";
	private List<DtCell> childs;
	private boolean isLeaf;
	private boolean isVisited;
	private int rowspan;
	private boolean isMetaDataColumn;
	private String cellRef;
	private String cellFormat;
	private short cellFormatId;

	public DtCell() {
	}
	
	

	public DtCell(int rowStartIndex, int rowEndIndex, int colStartIndex, int colEndIndex, DtCellType dtCellType,
			Object content, DtCell decisionHeader, boolean isLeaf) {
		this.rowStartIndex = rowStartIndex;
		this.rowEndIndex = rowEndIndex;
		this.colStartIndex = colStartIndex;
		this.colEndIndex = colEndIndex;
		this.dtCellType = dtCellType;
		this.content = content;
		this.childs = new ArrayList<DtCell>();
	}

	public DtCell(String cellRef) {
		this.cellRef = cellRef;
		setCellCoordiates(cellRef);
		this.content = "";
		this.childs = new ArrayList<>();
	}

	public void setCellCoordiates(String cellRef) {

		String[] cellRefArray = cellRef.split(":");
		String startingCellRef = cellRefArray[0];
		String endingCellRef = cellRefArray[0];
		if (cellRefArray.length > 1) {
			endingCellRef = cellRefArray[1];
		}

		StringBuilder startColumnPart = new StringBuilder();
		StringBuilder startRowPart = new StringBuilder();
		collectRowAndColumnPart(startingCellRef, startColumnPart, startRowPart);

		StringBuilder endColumnPart = new StringBuilder();
		StringBuilder endRowPart = new StringBuilder();
		collectRowAndColumnPart(endingCellRef, endColumnPart, endRowPart);

		int startColumnIndex = getColumnIndex(startColumnPart.toString());
		int endColumnIndex = getColumnIndex(endColumnPart.toString());

		this.rowStartIndex = Integer.parseInt(startRowPart.toString()) - 1;
		this.rowEndIndex = Integer.parseInt(endRowPart.toString()) - 1;
		this.colStartIndex = startColumnIndex;
		this.colEndIndex = endColumnIndex;
	}

	public void collectRowAndColumnPart(String cellRef, StringBuilder columnPart, StringBuilder rowPart) {
		for (char ch : cellRef.toCharArray()) {
			if (Character.isLetter(ch)) {
				columnPart.append(ch);
			} else {
				rowPart.append(ch);
			}
		}
	}

	public int getColumnIndex(String columnPart) {
		int columnIndex = 0;
		for (char ch : columnPart.toCharArray()) {
			columnIndex = columnIndex * 26 + (ch - 'A' + 1);
		}

		return columnIndex - 1;
	}

	@Override
	public String toString() {
		return "DtCell [rowStartIndex=" + rowStartIndex + ", rowEndIndex=" + rowEndIndex + ", colStartIndex="
				+ colStartIndex + ", colEndIndex=" + colEndIndex + ", dtCellType=" + dtCellType + ", content=" + content
				+ "]";
	}

	public short getCellFormatId() {
		return cellFormatId;
	}

	public void setCellFormatId(short cellFormatId) {
		this.cellFormatId = cellFormatId;
	}



	public String getCellFormat() {
		return cellFormat;
	}

	public void setCellFormat(String cellFormat) {
		this.cellFormat = cellFormat;
	}



	public String getCellRef() {
		return cellRef;
	}

	public void setCellRef(String cellRef) {
		this.cellRef = cellRef;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public DtCell getAssignHeader() {
		return assignHeader;
	}

	public void setAssignHeader(DtCell assignHeader) {
		this.assignHeader = assignHeader;
	}

	public DtCell getDecisionHeader() {
		return decisionHeader;
	}

	public void setDecisionHeader(DtCell decisionHeader) {
		this.decisionHeader = decisionHeader;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<DtCell> getChilds() {
		return childs;
	}

	public void setChilds(List<DtCell> childs) {
		this.childs = childs;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public int getRowStartIndex() {
		return rowStartIndex;
	}

	public void setRowStartIndex(int rowStartIndex) {
		this.rowStartIndex = rowStartIndex;
	}

	public int getRowEndIndex() {
		return rowEndIndex;
	}

	public void setRowEndIndex(int rowEndIndex) {
		this.rowEndIndex = rowEndIndex;
	}

	public int getColStartIndex() {
		return colStartIndex;
	}

	public void setColStartIndex(int colStartIndex) {
		this.colStartIndex = colStartIndex;
	}

	public int getColEndIndex() {
		return colEndIndex;
	}

	public void setColEndIndex(int colEndIndex) {
		this.colEndIndex = colEndIndex;
	}

	public DtCellType getDtCellType() {
		return dtCellType;
	}

	public void setDtCellType(DtCellType dtCellType) {
		this.dtCellType = dtCellType;
	}

	public int getRowspan() {
		return rowspan;
	}

	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}

	public boolean isMetaDataColumn() {
		return isMetaDataColumn;
	}

	public void setMetaDataColumn(boolean isMetaDataColumn) {
		this.isMetaDataColumn = isMetaDataColumn;
	}

}
