package com.dk.bus.services;

import org.springframework.stereotype.Service;

import com.dk.bus.dto.BusBookingAcknoledgement;
import com.dk.bus.dto.BusBookingResquest;


@Service
public interface BusBookingService {

	BusBookingAcknoledgement bookBusTicket(BusBookingResquest busBookingResquest);
	
}
