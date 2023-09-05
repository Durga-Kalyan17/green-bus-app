package com.dk.bus.entities;

import com.dk.bus.enums.PassengerConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = PassengerConstants.PAYMENT_ID)
	@JsonProperty(PassengerConstants.PAYMENT_ID)
	private String paymentId;

	
	@Column(name = PassengerConstants.ACCOUNT_NO)
	@JsonProperty(PassengerConstants.ACCOUNT_NO)
	private String accountNo;

	@Column(name = PassengerConstants.AMOUNT_PAID)
	@JsonProperty(PassengerConstants.AMOUNT_PAID)
	private double amount;

	@Column(name = PassengerConstants.CARD_TYPE)
	@JsonProperty(PassengerConstants.CARD_TYPE)
	private String cardType;

	
	@Column(name = PassengerConstants.PASSENGER_ID, columnDefinition = "BigInt(20) default '0'")
	@JsonProperty(PassengerConstants.PASSENGER_ID)
	private Long passengerId;
	

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public PaymentInfo() {

	}

	public PaymentInfo(String paymentId, String accountNo, double amount, String cardType, Long passengerId) {
		this.paymentId = paymentId;
		this.accountNo = accountNo;
		this.amount = amount;
		this.cardType = cardType;
		this.passengerId = passengerId;
	}

	@Override
	public String toString() {
		return "PaymentInfo [paymentId=" + paymentId + ", accountNo=" + accountNo + ", amount=" + amount + ", cardType="
				+ cardType + ", passengerId=" + passengerId + "]";
	}

}