package com.act21.impaktapps.rule.engine.test;

import java.util.List;

import com.act21.impaktapps.rule.engine.table.DtCell;

public class GridRule {

	private DtCell vertical;
	private List<DtCell> spanGroup;

	public GridRule() {

	}

	public DtCell getVertical() {
		return vertical;
	}

	public void setVertical(DtCell vertical) {
		this.vertical = vertical;
	}

	public List<DtCell> getSpanGroup() {
		return spanGroup;
	}

	public void setSpanGroup(List<DtCell> spanGroup) {
		this.spanGroup = spanGroup;
	}

}
