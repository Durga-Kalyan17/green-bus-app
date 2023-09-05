package com.dk.bus.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
(
	{ 
		"status", 
		"time_stamp",
		"error_message",
		"error_code",   
		"path" 
	}
)
public class ExceptionResponse {

	private String status;

	@JsonProperty("error_message")
	private String errorMsg;

	@JsonProperty("error_code")
	private String errorCode;

	private String path;

	@JsonProperty("time_stamp")
	private LocalDateTime timeStamp;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String string) {
		this.errorCode = string;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
