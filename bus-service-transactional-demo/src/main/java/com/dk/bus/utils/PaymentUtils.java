package com.dk.bus.utils;

import java.util.HashMap;
import java.util.Map;

import com.dk.bus.enums.ErrorEnums;
import com.dk.bus.enums.ValidationErrorMessages;
import com.dk.bus.exceptions.EmptyInputException;
import com.dk.bus.exceptions.InsufficientAmountException;

public class PaymentUtils {

	private static Map<String, Double> paymentMap = new HashMap<>();
	
	static {
		paymentMap.put("acc1", 2000.0);
		paymentMap.put("acc2", 12000.0);
		paymentMap.put("acc3", 2500.0);
		paymentMap.put("acc4", 22000.0);
		paymentMap.put("acc5", 200000.0);   
		paymentMap.put("acc6", 30000.0);
	}
	
	public static boolean validateCreditLimit(String accNo, Double paidAmount) {
		
		System.out.println("Account Number - " + accNo);
		System.out.println("Amount Available - " + paymentMap.get(accNo));
		
		if(accNo.isEmpty() || accNo == null) {
			throw new EmptyInputException(ValidationErrorMessages.ACCOUNT_NO_EMPTY);
		}
		else if(paidAmount > paymentMap.get(accNo)) {
			throw new InsufficientAmountException(ErrorEnums.IFIA.getError());
		}
		else {
			return true;
		}
			
	}
}
