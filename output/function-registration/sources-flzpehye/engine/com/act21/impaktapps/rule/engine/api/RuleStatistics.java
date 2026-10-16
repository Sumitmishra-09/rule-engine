package com.act21.impaktapps.rule.engine.api;

import java.util.ArrayList;
import java.util.List;

public class RuleStatistics {

	private List<Long> ruleExecuted = new ArrayList<>();
	private int currentRowIndex;
	private int currentColIndex;
	private String cellRef;
	
	
	

	public String getCellRef() {
		return cellRef;
	}

	public void setCellRef(String cellRef) {
		this.cellRef = cellRef;
	}

	public int getCurrentRowIndex() {
		return currentRowIndex;
	}

	public void setCurrentRowIndex(int currentRowIndex) {
		this.currentRowIndex = currentRowIndex;
	}

	public int getCurrentColIndex() {
		return currentColIndex;
	}

	public void setCurrentColIndex(int currentColIndex) {
		this.currentColIndex = currentColIndex;
	}

	public List<Long> getRuleExecuted() {
		return ruleExecuted;
	}

	public void setRuleExecuted(List<Long> ruleExecuted) {
		this.ruleExecuted = ruleExecuted;
	}
	
	
}
