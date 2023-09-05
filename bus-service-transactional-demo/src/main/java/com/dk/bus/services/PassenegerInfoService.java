package com.dk.bus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dk.bus.dto.BusBookingAcknoledgement;
import com.dk.bus.entities.PassengerInfo;


@Service
public interface PassenegerInfoService {

	List<PassengerInfo> getAllPassengers();
	
	Optional<PassengerInfo> getPassengerInfoByPID(Long pId);
	
	BusBookingAcknoledgement getPassengerInfoByTicketNumber(Long ticketNumber);
}
