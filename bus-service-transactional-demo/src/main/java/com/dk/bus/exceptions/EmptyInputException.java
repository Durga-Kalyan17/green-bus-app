package com.dk.bus.exceptions;

public class EmptyInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2026438592962149778L;

	public EmptyInputException(String message) {
		super(message);
	}
}
