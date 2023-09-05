package com.dk.bus.dto;

import com.dk.bus.entities.PassengerInfo;
import com.dk.bus.entities.PaymentInfo;


public class BusBookingResquest {

	private PassengerInfo passengerInfo;

	private PaymentInfo paymentInfo;

	public PassengerInfo getPassengerInfo() {
		return passengerInfo;
	}

	public void setPassengerInfo(PassengerInfo passengerInfo) {
		this.passengerInfo = passengerInfo;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public BusBookingResquest() {

	}

	public BusBookingResquest(PassengerInfo passengerInfo, PaymentInfo paymentInfo) {
		this.passengerInfo = passengerInfo;
		this.paymentInfo = paymentInfo;
	}
	
	@Override
	public String toString() {
		return "BusBookingResquest [passengerInfo=" + passengerInfo + ", paymentInfo=" + paymentInfo + "]";
	}


}
