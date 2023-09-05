package com.dk.bus.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dk.bus.dto.BusBookingAcknoledgement;
import com.dk.bus.dto.BusBookingResquest;
import com.dk.bus.entities.PassengerInfo;
import com.dk.bus.services.BusBookingService;
import com.dk.bus.services.PassenegerInfoService;

@RestController
@RequestMapping("/bus")
public class BusController {
	
	@Autowired
	BusBookingService busBookingService;
	
	@Autowired
	PassenegerInfoService passenegerInfoService;
	

	@PostMapping("/book-ticket")
	public BusBookingAcknoledgement bookBusTicket(@RequestBody BusBookingResquest busBookingResquest) {
		return busBookingService.bookBusTicket(busBookingResquest);
	}
	
	@GetMapping("/get-all-passengers")
	public List<PassengerInfo> getAllPasengers(){
		return passenegerInfoService.getAllPassengers();
	}
	
	@GetMapping("/get-passenger/pid={pId}")
	public Optional<PassengerInfo> getPassengerByPID(@PathVariable Long pId){
		return passenegerInfoService.getPassengerInfoByPID(pId);
	}
	
	@GetMapping("/get-passenger/ticket={ticketNumber}")
	public BusBookingAcknoledgement getPassengerInfoByTicketNumber(@PathVariable Long ticketNumber){
		return passenegerInfoService.getPassengerInfoByTicketNumber(ticketNumber);
	}
}
