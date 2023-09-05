package com.dk.bus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dk.bus.utils.BookingConfirmationEmailBody;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements EmailService{
	
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	public void sendBookingConfirmationMailToPassenger(String toEmail, BookingConfirmationEmailBody emailBody
														, String subject) throws MessagingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        System.out.println("Pick-up Location: " + emailBody.getPickUpLocation());
        System.out.println("Started mail writing...");
        String emailContent = "<html><body>";
        emailContent += "<p>Hi " + emailBody.getName() + ",</p>";
        emailContent += "<p>Greetings from GREEN BUS. Your bus ticket has been successfully confirmed.</p>";
        emailContent += "<p>Please find your ticket details below:</p>";
        emailContent += "<ul>";
        emailContent += "<li>Ticket Number: " + emailBody.getTicketNumber() + "</li>";
        emailContent += "<li>Travel Date: " + emailBody.getTravelDate() + "</li>";
        emailContent += "<li>Pick-up Time: " + emailBody.getPickUpTime() + "</li>";
        emailContent += "<li>Pick-up Location: " + emailBody.getPickUpLocation() + "</li>";
        emailContent += "<li>Destination: " + emailBody.getDestination() + "</li>";
        emailContent += "</ul>";
        emailContent += "<p>Enjoy your Journey!!!</p>";
        emailContent += "<p>Best Wishes,</p>";
        emailContent += "<p>GREEN BUS Team</p>";
        emailContent += "</body></html>";
        System.out.println("Ended mail writing...");
        helper.setText(emailContent, true); // true indicates HTML content
        System.out.println("Mail content set...");

        javaMailSender.send(message);
	}

}
