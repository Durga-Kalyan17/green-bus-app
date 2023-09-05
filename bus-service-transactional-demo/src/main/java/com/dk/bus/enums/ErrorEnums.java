package com.dk.bus.enums;

public enum ErrorEnums {

	IFIA("Insufficient funds please check your account balance..."),
	IFIA_CODE("IFIA - 001"),
	NPF("No Passengers Found"),
	NPF_CODE("NPF - 002"),
	NPEWPID("No Passenger Exists with given PID - "),
	NPEWPID_CODE("NPEWPID - 003"),
	EMPTY_INPUT_CODE("EMPTY INPUT - 004"),
	INVALID_FORMAT_CODE("INVALID FORMAT - 005"),
	SIN_CODE("Something is Null - 006"),
	NPEWTN("No Passenger Exists with given Ticket Number - "),
	NPEWTN_CODE("NPEWTN - 007"),;

	private String error;
	
	
	public String getError() {
		return error;
	}

	ErrorEnums(String error) {
		this.error = error;
	}
}
