package com.dk.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.bus.entities.PaymentInfo;

public interface PaymentInfoRepository  extends JpaRepository<PaymentInfo, String>{

}
