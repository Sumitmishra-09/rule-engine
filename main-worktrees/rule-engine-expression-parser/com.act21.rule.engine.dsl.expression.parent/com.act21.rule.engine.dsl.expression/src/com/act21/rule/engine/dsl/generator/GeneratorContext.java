package com.act21.rule.engine.dsl.generator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.util.CancelIndicator;

public class GeneratorContext implements IGeneratorContext {
	private Map<String, Object> additionalData = new HashMap<>();
	private CancelIndicator cancelIndicator;

	
	public CancelIndicator getCancelIndicator() {
		return cancelIndicator;
	}

	public void setCancelIndicator(CancelIndicator cancelIndicator) {
		this.cancelIndicator = cancelIndicator;
	}

	public Map<String, Object> getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(Map<String, Object> additionalData) {
		this.additionalData = additionalData;
	}

}
