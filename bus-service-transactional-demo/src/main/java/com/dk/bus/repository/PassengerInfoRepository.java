package com.dk.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.bus.entities.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long>{

}
