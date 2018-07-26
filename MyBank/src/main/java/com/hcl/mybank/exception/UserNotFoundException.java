package com.hcl.mybank.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

}
