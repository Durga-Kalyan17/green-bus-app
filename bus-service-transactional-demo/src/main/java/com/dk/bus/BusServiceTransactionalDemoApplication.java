package com.dk.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BusServiceTransactionalDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusServiceTransactionalDemoApplication.class, args);
	}

}
