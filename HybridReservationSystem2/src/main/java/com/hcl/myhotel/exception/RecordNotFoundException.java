package com.hcl.myhotel.exception;

import java.io.Serializable;

public class RecordNotFoundException extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public RecordNotFoundException(){
		super();
	}
	
	public RecordNotFoundException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
