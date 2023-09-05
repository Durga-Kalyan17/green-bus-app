package com.dk.bus.dto;

import com.dk.bus.entities.PassengerInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "BUS_BOOKING_ACKNOLEDGEMENT")
public class BusBookingAcknoledgement {

	@Id
	@Column(name = "ticket_no")
	@JsonProperty("ticket_no")
	private Long ticketNo; 
	
	private String status;
	
	@Column(name = "amount_paid")
	@JsonProperty("amount_paid")
	private double amountPaid;  
	
	@Column(name = "passenger_id")
	@JsonIgnore
	private Long passengerId;
	
//	@Column(name = "passenger_info", columnDefinition = "JSON")
	@JsonProperty("passenger_info")
	@Transient
	private PassengerInfo passengerInfo;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Long getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(Long ticketNo) {
		this.ticketNo = ticketNo;
	}

	public PassengerInfo getPassengerInfo() {
		return passengerInfo;
	}

	public void setPassengerInfo(PassengerInfo passengerInfo) {
		this.passengerInfo = passengerInfo;
	}
	

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public BusBookingAcknoledgement() {

	}

	public BusBookingAcknoledgement(String status, double amountPaid, Long ticketNo, PassengerInfo passengerInfo) {
		this.status = status;
		this.amountPaid = amountPaid;
		this.ticketNo = ticketNo;
		this.passengerInfo = passengerInfo;
	}

	@Override
	public String toString() {
		return "BusBookingAcknoledgement [ticketNo=" + ticketNo + ", status=" + status + ", amountPaid=" + amountPaid
				+ ", passengerId=" + passengerId + ", passengerInfo=" + passengerInfo + "]";
	}
}
