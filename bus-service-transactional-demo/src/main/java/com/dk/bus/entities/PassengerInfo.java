package com.dk.bus.entities;

import com.dk.bus.enums.PassengerConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PASSENGER_INFO")
public class PassengerInfo {

	@Id
	@GeneratedValue
	private Long pId;
	
	@Column(name = PassengerConstants.NAME)
	@JsonProperty(PassengerConstants.NAME)
	private String name;
	
	@Column(name = PassengerConstants.EMAIL)
	@JsonProperty(PassengerConstants.EMAIL)
	private String email;
	
	@Column(name = PassengerConstants.PICKUP_LOCATION)
	@JsonProperty(PassengerConstants.PICKUP_LOCATION)
	private String source;
	
	private String destination;
	
	@Column(name = PassengerConstants.TRAVEL_DATE)
	@JsonProperty(PassengerConstants.TRAVEL_DATE)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	private String travelDate;
	
	@Column(name = PassengerConstants.PICKUP_TIME)
	@JsonProperty(PassengerConstants.PICKUP_TIME)
	private String pickUpTime;
	
	@Column(name = PassengerConstants.ARRAIVAL_TIME)
	@JsonProperty(PassengerConstants.ARRAIVAL_TIME)
	private String arraivalTime;

	@Column(name = PassengerConstants.TICKET_FARE)
	@JsonProperty(PassengerConstants.TICKET_FARE)
	private double fare;

	
	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getArraivalTime() {
		return arraivalTime;
	}

	public void setArraivalTime(String arraivalTime) {
		this.arraivalTime = arraivalTime;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public PassengerInfo() {

	}

	public PassengerInfo(Long pId, String name, String email, String source, String destination, String travelDate,
			String pickUpTime, String arraivalTime, double fare) {
		this.pId = pId;
		this.name = name;
		this.email = email;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
		this.pickUpTime = pickUpTime;
		this.arraivalTime = arraivalTime;
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "PassengerInfo [pId=" + pId + ", name=" + name + ", email=" + email + ", source=" + source
				+ ", destination=" + destination + ", travelDate=" + travelDate + ", pickUpTime=" + pickUpTime
				+ ", arraivalTime=" + arraivalTime + ", fare=" + fare + "]";
	}

}
