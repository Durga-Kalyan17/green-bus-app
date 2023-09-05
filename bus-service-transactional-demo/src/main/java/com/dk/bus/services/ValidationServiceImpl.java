package com.dk.bus.services;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.dk.bus.dto.BusBookingResquest;
import com.dk.bus.entities.PassengerInfo;
import com.dk.bus.entities.PaymentInfo;
import com.dk.bus.enums.ValidationErrorMessages;
import com.dk.bus.exceptions.EmptyInputException;
import com.dk.bus.exceptions.ValidationException;


@Service
public class ValidationServiceImpl implements ValidationService {

	@Override
	public void validateBookingRequest(BusBookingResquest busBookingResquest) {

		System.out.println("In validatioon service....");

		PassengerInfo passengerInfo = busBookingResquest.getPassengerInfo();
		PaymentInfo paymentInfo = busBookingResquest.getPaymentInfo();

		// Validating other fields of input request except date
		if (passengerInfo.getName() == null || passengerInfo.getName().equals("")) {
			throw new EmptyInputException(ValidationErrorMessages.NAME_EMPTY);
		} 
		else if (passengerInfo.getEmail().equals("") || passengerInfo.getEmail() == null) {
			throw new ValidationException(ValidationErrorMessages.EMAIL_EMPTY);
		} 
		else if (!passengerInfo.getEmail().contains("@")) {
			throw new ValidationException(ValidationErrorMessages.INVALID_EMAIL_FORMAT);
		} 
		else if (passengerInfo.getSource() == null || passengerInfo.getSource().equals("")) {
			throw new EmptyInputException(ValidationErrorMessages.PICKUP_LOCATION_EMPTY);
		} 
		else if (passengerInfo.getDestination() == null || passengerInfo.getDestination().equals("")) {
			throw new EmptyInputException(ValidationErrorMessages.DESTINATION_EMPTY);
		} 
		else if (passengerInfo.getPickUpTime() == null || passengerInfo.getPickUpTime().equals("")) {
			throw new EmptyInputException(ValidationErrorMessages.PICKUP_TIME_EMPTY);
		} 
		else if (passengerInfo.getArraivalTime() == null || passengerInfo.getArraivalTime().equals("")) {
			throw new EmptyInputException(ValidationErrorMessages.ARRIVAL_TIME_EMPTY);
		} 
		else if (Objects.isNull(passengerInfo.getFare())) {
			throw new EmptyInputException(ValidationErrorMessages.TICKET_FARE_NULL);
		} 
		else if (paymentInfo.getAccountNo() == null || paymentInfo.getAccountNo().equals("")) {
			throw new EmptyInputException(ValidationErrorMessages.ACCOUNT_NO_EMPTY);
		} 
		else if (paymentInfo.getCardType() == null || paymentInfo.getCardType().equals("")) {
			throw new EmptyInputException(ValidationErrorMessages.CARD_TYPE_EMPTY);
		}
		
		// Validating date for empty input and null value and invalid format
		String travelDate = passengerInfo.getTravelDate();

		if (travelDate.length() > 10 || travelDate.length() < 10) {
			throw new ValidationException(ValidationErrorMessages.INVALID_DATE_LENGTH);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("In for loop...");
			if (i == 2 || i == 5) {
				System.out.println("In if block...");
				if (travelDate.charAt(i) != '-') {
					System.out.println("'i' value before throw ValidationException = " + i);
					throw new ValidationException(ValidationErrorMessages.INVALID_TRAVEL_DATE);
				}
			} 
			else if (travelDate.charAt(i) == '-') {
				System.out.println("In else if block...");
				System.out.println("'i' value before throw ValidationException = " + i);
				throw new ValidationException(ValidationErrorMessages.INVALID_TRAVEL_DATE);
			}
		}

	}

}
