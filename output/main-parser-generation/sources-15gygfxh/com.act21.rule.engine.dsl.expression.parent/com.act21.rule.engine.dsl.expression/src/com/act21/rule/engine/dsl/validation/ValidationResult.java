package com.act21.rule.engine.dsl.validation;

public class ValidationResult {
	private String message;
	private String severity;

	public ValidationResult(String message, String severity) {
		this.setMessage(message);
		this.setSeverity(severity);
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
