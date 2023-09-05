package com.dk.bus.services;

import org.springframework.stereotype.Service;

import com.dk.bus.dto.BusBookingResquest;


@Service
public interface ValidationService {

	void validateBookingRequest(BusBookingResquest busBookingResquest);
}
