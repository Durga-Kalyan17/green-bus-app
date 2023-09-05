package com.dk.bus.exceptions;

public class NoPassengerFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6790222774314208137L;

	public NoPassengerFoundException(String message) {
		super(message);
	}
}
