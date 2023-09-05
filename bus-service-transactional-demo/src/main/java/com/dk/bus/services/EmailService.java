package com.dk.bus.services;

import org.springframework.stereotype.Service;

import com.dk.bus.utils.BookingConfirmationEmailBody;

import jakarta.mail.MessagingException;


@Service
public interface EmailService {

	void sendBookingConfirmationMailToPassenger(String toEmail, BookingConfirmationEmailBody body, String subject)
																		throws MessagingException;
}
