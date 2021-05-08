package com.cognizant.exception;

public class InvalidFlightOperationException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InvalidFlightOperationException(String message) {
		super(message);
	}

}
