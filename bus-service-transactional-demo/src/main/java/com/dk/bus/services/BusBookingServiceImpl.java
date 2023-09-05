package com.dk.bus.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.bus.dto.BusBookingAcknoledgement;
import com.dk.bus.dto.BusBookingResquest;
import com.dk.bus.entities.PassengerInfo;
import com.dk.bus.entities.PaymentInfo;
import com.dk.bus.enums.PassengerConstants;
import com.dk.bus.enums.StatusEnums;
import com.dk.bus.repository.BookingAcknoledgementRepository;
import com.dk.bus.repository.PassengerInfoRepository;
import com.dk.bus.repository.PaymentInfoRepository;
import com.dk.bus.utils.BookingConfirmationEmailBody;
import com.dk.bus.utils.PaymentUtils;

import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;


@Service
public class BusBookingServiceImpl implements BusBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepository;

	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	@Autowired
	BookingAcknoledgementRepository bookingAcknoledgementRepository;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ValidationService validationService;


	@Transactional
	@Override
	public BusBookingAcknoledgement bookBusTicket(BusBookingResquest busBookingResquest) {
		
		validationService.validateBookingRequest(busBookingResquest);

		PassengerInfo passengerInfo = busBookingResquest.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);

		PaymentInfo paymentInfo = busBookingResquest.getPaymentInfo();
		
		System.out.println("Account No - " + paymentInfo.getAccountNo() + "\nAmount Paid - " + passengerInfo.getFare());
		System.out.println("P_ID - " + passengerInfo.getpId());
		
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

		paymentInfo.setPassengerId(passengerInfo.getpId());
		System.out.println("PassengerId - " + paymentInfo.getPassengerId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);

		// Generating Random Number for Ticket Number
		int customLength = 8; // Change this to your desired length
        int minValue = (int) Math.pow(10, customLength - 1); // Minimum value for the desired length
        int maxValue = (int) Math.pow(10, customLength) - 1;  // Maximum value for the desired length

        Random random = new Random();
        Long randomNumber = (long) random.nextInt(maxValue - minValue + 1) + minValue;
		
		BusBookingAcknoledgement busBookingAcknoledgement = new BusBookingAcknoledgement(StatusEnums.SUCCESS.getStatus()
																, passengerInfo.getFare(), randomNumber, passengerInfo);
		busBookingAcknoledgement.setPassengerId(passengerInfo.getpId());
		bookingAcknoledgementRepository.save(busBookingAcknoledgement);
		
		BookingConfirmationEmailBody bookingConfirmationEmailBody = new BookingConfirmationEmailBody();
		bookingConfirmationEmailBody.setName(busBookingResquest.getPassengerInfo().getName());
		bookingConfirmationEmailBody.setPickUpTime(busBookingResquest.getPassengerInfo().getPickUpTime());
		bookingConfirmationEmailBody.setPickUpLocation(busBookingResquest.getPassengerInfo().getSource());
		bookingConfirmationEmailBody.setDestination(busBookingResquest.getPassengerInfo().getDestination());
		bookingConfirmationEmailBody.setTicketNumber(randomNumber);
		bookingConfirmationEmailBody.setTravelDate(busBookingResquest.getPassengerInfo().getTravelDate());
		
		try {
			emailService.sendBookingConfirmationMailToPassenger(passengerInfo.getEmail()
					, bookingConfirmationEmailBody, PassengerConstants.BOOKING_EMAIL_SUBJECT);
			System.out.println("Email sent...");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return busBookingAcknoledgement;
	}

}
