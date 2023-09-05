package com.dk.bus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.bus.dto.BusBookingAcknoledgement;
import com.dk.bus.entities.PassengerInfo;
import com.dk.bus.enums.ErrorEnums;
import com.dk.bus.exceptions.NoPassengerFoundException;
import com.dk.bus.repository.BookingAcknoledgementRepository;
import com.dk.bus.repository.PassengerInfoRepository;


@Service
public class PassenegerInfoServiceImpl implements PassenegerInfoService {
	
	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	
	@Autowired
	BookingAcknoledgementRepository bookingAcknoledgementRepository;
	

	@Override
	public List<PassengerInfo> getAllPassengers() {
		
		List<PassengerInfo> allPassengersInfo = passengerInfoRepository.findAll();
		
		if(allPassengersInfo == null || allPassengersInfo.isEmpty()) 
			throw new NoPassengerFoundException(ErrorEnums.NPF.getError());
		
		return allPassengersInfo;
	}

	@Override
	public Optional<PassengerInfo> getPassengerInfoByPID(Long pId) {
		
		Optional<PassengerInfo> passengerInfo = passengerInfoRepository.findById(pId);
		
		if(passengerInfo == null || passengerInfo.isEmpty()) 
			throw new NoPassengerFoundException(ErrorEnums.NPEWPID.getError() + pId);
		
		return passengerInfo;
	}

	@Override
	public BusBookingAcknoledgement getPassengerInfoByTicketNumber(Long ticketNumber) {
		
		Optional<BusBookingAcknoledgement> passengerAcknoledgementFromDB = bookingAcknoledgementRepository.findById(ticketNumber);
		System.out.println("Passenger Booking Acknoledgement - " + passengerAcknoledgementFromDB);

		if(passengerAcknoledgementFromDB == null || passengerAcknoledgementFromDB.isEmpty()) 
			throw new NoPassengerFoundException(ErrorEnums.NPEWTN.getError() + ticketNumber);
		
		BusBookingAcknoledgement busBookingAcknoledgement = passengerAcknoledgementFromDB.get();
		PassengerInfo passengerInfo = passengerInfoRepository.findById(busBookingAcknoledgement.getPassengerId()).get();
		busBookingAcknoledgement.setPassengerInfo(passengerInfo);
		
		System.out.println("Passenger info - " + passengerInfo);
		
		return busBookingAcknoledgement;
	}

}
