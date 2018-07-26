package com.hcl.mybank.exception;

public class UserAlreadyExist extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1150450347903437142L;
	
	public UserAlreadyExist(String message)
	{
		super(message);
	}

}
