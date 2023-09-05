package com.dk.bus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Insufficient funds please check your account balance...")
public class InsufficientAmountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5693748464299381871L;

	public InsufficientAmountException(String message) {
		super(message);
	}
//	public InsufficientAmountException() {
//		
//	}
}
