package com.act21.impaktapps.rule.engine.exception;

import java.util.List;

import com.act21.impaktapps.rule.engine.validation.ValidationMessage;

public class ParsingException extends RuntimeException{

	
	
	private static final long serialVersionUID = 1L;
	private List<ValidationMessage> validationMessage ;
	
	public ParsingException(List<ValidationMessage> validationMessage,Throwable cause){
		super(cause);
		this.validationMessage = validationMessage;
	}
	public ParsingException(List<ValidationMessage> validationMessage){
		super();
		this.validationMessage = validationMessage;
	}

	public  List<ValidationMessage> getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(List<ValidationMessage> validationMessage) {
		this.validationMessage = validationMessage;
	}
	
	
	
}
