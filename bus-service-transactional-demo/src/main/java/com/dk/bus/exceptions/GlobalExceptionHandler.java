package com.dk.bus.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dk.bus.enums.ErrorEnums;
import com.dk.bus.enums.StatusEnums;
import com.dk.bus.enums.ValidationErrorMessages;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InsufficientAmountException.class)
	public ResponseEntity<ExceptionResponse> handleInsufficientAmountException(
			InsufficientAmountException insufficientAmountException, final HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();

		errorResponse.setStatus(StatusEnums.FAILURE.getStatus());
		errorResponse.setErrorMsg(insufficientAmountException.getMessage());
		errorResponse.setPath(request.getRequestURI());
		errorResponse.setErrorCode(ErrorEnums.IFIA_CODE.getError());
		errorResponse.setTimeStamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
	}
	
	@ExceptionHandler(NoPassengerFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoPassengerFoundException(
			NoPassengerFoundException noPassengerFoundException, final HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();

		errorResponse.setStatus(StatusEnums.FAILURE.getStatus());
		errorResponse.setErrorMsg(noPassengerFoundException.getMessage());
		errorResponse.setPath(request.getRequestURI());
		
		if(noPassengerFoundException.getMessage().equalsIgnoreCase(ErrorEnums.NPF.getError())) {
			errorResponse.setErrorCode(ErrorEnums.NPF_CODE.getError());
		}
		else if(noPassengerFoundException.getMessage().contains(ErrorEnums.NPEWPID.getError())) {
			errorResponse.setErrorCode(ErrorEnums.NPEWPID_CODE.getError());
		}
		else if(noPassengerFoundException.getMessage().contains(ErrorEnums.NPEWTN.getError())) {
			errorResponse.setErrorCode(ErrorEnums.NPEWTN_CODE.getError());
		}
		errorResponse.setTimeStamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ExceptionResponse> handleValidationException(
			ValidationException validationException, final HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();
		
		validationException.printStackTrace();
	
		errorResponse.setStatus(StatusEnums.FAILURE.getStatus());
		errorResponse.setErrorMsg(validationException.getMessage());
		errorResponse.setPath(request.getRequestURI());
		if(validationException.getMessage().equalsIgnoreCase(ValidationErrorMessages.INVALID_EMAIL_FORMAT)) {
			errorResponse.setErrorCode(ErrorEnums.INVALID_FORMAT_CODE.getError());
			errorResponse.setTimeStamp(LocalDateTime.now());

			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
		}
		else {
			errorResponse.setErrorCode(ErrorEnums.EMPTY_INPUT_CODE.getError());
		}
		errorResponse.setTimeStamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionResponse> handleConstraintViolationException(
			ConstraintViolationException constraintViolationException, final HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();
		
		System.err.println(constraintViolationException.getMessage());
		
		String [] exception = constraintViolationException.getMessage().split("=");
		String exceptionMessage = exception[1].substring(1, exception[1].indexOf(",") - 1);

		errorResponse.setStatus(StatusEnums.FAILURE.getStatus());
		errorResponse.setErrorMsg(exceptionMessage);
		errorResponse.setPath(request.getRequestURI());
		errorResponse.setErrorCode(ErrorEnums.EMPTY_INPUT_CODE.getError());
		errorResponse.setTimeStamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<ExceptionResponse> handleEmptyInputException(
			EmptyInputException emptyInputException, final HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();

		errorResponse.setStatus(StatusEnums.FAILURE.getStatus());
		errorResponse.setErrorMsg(emptyInputException.getMessage());
		errorResponse.setPath(request.getRequestURI());
		errorResponse.setErrorCode(ErrorEnums.EMPTY_INPUT_CODE.getError());
		errorResponse.setTimeStamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidFormatException(
			HttpMessageNotReadableException httpMessageNotReadableException, final HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();

		errorResponse.setStatus(StatusEnums.FAILURE.getStatus());
		errorResponse.setErrorMsg(httpMessageNotReadableException.getMessage());
		errorResponse.setPath(request.getRequestURI());
		errorResponse.setErrorCode(ErrorEnums.INVALID_FORMAT_CODE.getError());
		errorResponse.setTimeStamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionResponse> handleNullPointerException(
			NullPointerException nullPointerException, final HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();

		errorResponse.setStatus(StatusEnums.FAILURE.getStatus());
		errorResponse.setErrorMsg(nullPointerException.getMessage());
		errorResponse.setPath(request.getRequestURI());
		errorResponse.setErrorCode(ErrorEnums.SIN_CODE.getError());
		errorResponse.setTimeStamp(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
}
