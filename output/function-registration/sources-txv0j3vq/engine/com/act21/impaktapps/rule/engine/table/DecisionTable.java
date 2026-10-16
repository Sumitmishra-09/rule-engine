package com.act21.impaktapps.rule.engine.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DecisionTable implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int batchNo;
	private List<DtCell> horizontalHeaders = new ArrayList<DtCell>();
	private List<DtCell> verticalHeaders = new ArrayList<DtCell>();
	private List<DtCell> assignHeaders = new ArrayList<DtCell>();
	private List<DtCell> assignSpanGroup = new ArrayList<DtCell>();
	private List<DtCell> horizontal = new ArrayList<DtCell>();
	private List<DtCell> vertical = new ArrayList<DtCell>();
	private int firstRowIndex;
	private int firstColIndex;
	private Set<Long> ruleGridIds = new HashSet<>();


	public DecisionTable(String name, int firstRowIndex, int firstColIndex, int batchNo) {
		this.name = name;
		this.firstRowIndex = firstRowIndex;
		this.firstColIndex = firstColIndex;
		this.batchNo = batchNo;
	}
	
	public DecisionTable(String name, int batchNo) {
		this.name = name;
		this.batchNo = batchNo;
	}

	public void addToSpanGroup(DtCell dtCell, int currentRowIdx) {

		DtCell spanGroup = this.assignSpanGroup.stream()
				.filter(span -> span.getColStartIndex() <= dtCell.getColStartIndex()
						&& span.getColEndIndex() >= dtCell.getColEndIndex())

				.findFirst().orElse(null);

		if (spanGroup == null) {
			spanGroup = new DtCell(dtCell.getRowStartIndex(), dtCell.getRowEndIndex(),
					assignHeaders.get(0).getColStartIndex(),
					assignHeaders.get(assignHeaders.size() - 1).getColEndIndex() + 1, null,
					DtCellType.ASSIGN_SPAN_GROUP, null, false);
			this.assignSpanGroup.add(spanGroup);
		}
		DtCell span = null;

		if (currentRowIdx < spanGroup.getChilds().size()) {
			span = spanGroup.getChilds().get(currentRowIdx);
		}

		if (span == null) {
			span = new DtCell(dtCell.getRowStartIndex(), dtCell.getRowEndIndex(), spanGroup.getColStartIndex(),
					spanGroup.getColEndIndex(), null, DtCellType.ASSIGN_SPAN, null, false);
			span.getChilds().add(dtCell);
			spanGroup.getChilds().add(span);
			return;
		}

		span.getChilds().add(dtCell);

	}
	
	

	public Set<Long> getRuleGridIds() {
		return ruleGridIds;
	}

	public void setRuleGridIds(Set<Long> ruleGridIds) {
		this.ruleGridIds = ruleGridIds;
	}

	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	public List<DtCell> getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(List<DtCell> horizontal) {
		this.horizontal = horizontal;
	}

	public List<DtCell> getVertical() {
		return vertical;
	}

	public void setVertical(List<DtCell> vertical) {
		this.vertical = vertical;
	}

	public int getFirstRowIndex() {
		return firstRowIndex;
	}

	public void setFirstRowIndex(int firstRowIndex) {
		this.firstRowIndex = firstRowIndex;
	}

	public int getFirstColIndex() {
		return firstColIndex;
	}

	public void setFirstColIndex(int firstColIndex) {
		this.firstColIndex = firstColIndex;
	}

	public List<DtCell> getHorizontalHeaders() {
		return horizontalHeaders;
	}

	public List<DtCell> getAssignHeaders() {
		return assignHeaders;
	}

	public void setAssignHeaders(List<DtCell> assignHeaders) {
		this.assignHeaders = assignHeaders;
	}

	public List<DtCell> getAssignSpanGroup() {
		return assignSpanGroup;
	}

	public void setAssignSpanGroup(List<DtCell> assignSpanGroup) {
		this.assignSpanGroup = assignSpanGroup;
	}

	public void setHorizontalHeaders(List<DtCell> horizontalHeaders) {
		this.horizontalHeaders = horizontalHeaders;
	}

	public List<DtCell> getVerticalHeaders() {
		return verticalHeaders;
	}

	public void setVerticalHeaders(List<DtCell> verticalHeaders) {
		this.verticalHeaders = verticalHeaders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
