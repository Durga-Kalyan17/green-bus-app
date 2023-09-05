package com.dk.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dk.bus.dto.BusBookingAcknoledgement;

@Repository
public interface BookingAcknoledgementRepository extends JpaRepository<BusBookingAcknoledgement, Long> {

}
