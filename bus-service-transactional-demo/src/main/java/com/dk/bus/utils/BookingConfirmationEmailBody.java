package com.dk.bus.utils;

import com.dk.bus.enums.ValidationErrorMessages;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class BookingConfirmationEmailBody {

	@NotEmpty(message  = ValidationErrorMessages.NAME_EMPTY)
	private String name;

	private Long ticketNumber;

	@NotEmpty(message  = ValidationErrorMessages.PICKUP_LOCATION_EMPTY)
	private String pickUpLocation;

	@NotEmpty(message  = ValidationErrorMessages.DESTINATION_EMPTY)
	private String destination;

	@NotEmpty(message = ValidationErrorMessages.PICKUP_TIME_EMPTY)
	private String pickUpTime;

	@NotNull(message = ValidationErrorMessages.TRAVEL_DATE_EMPTY)
	private String travelDate;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	
	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String string) {
		this.travelDate = string;
	}
	
	
	@Override
	public String toString() {
		return " Name - " + name + ", Ticket Number - " + ticketNumber
				+ ", Pickup location - " + pickUpLocation + ", Destination - " + destination + ", Pickup Time - " + pickUpTime
				+ ", Travel Date - " + travelDate;
	}

}
