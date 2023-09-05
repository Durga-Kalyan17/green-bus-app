package com.dk.bus.enums;


public enum StatusEnums {

	FAILURE("Failure"),
	SUCCESS("Success");

	private String status;
	
	public String getStatus() {
		return status;
	}

	StatusEnums(String status) {
		this.status = status;
	}
}
