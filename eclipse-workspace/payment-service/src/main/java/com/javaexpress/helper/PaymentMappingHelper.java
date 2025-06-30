package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.PaymentDto;
import com.javaexpress.model.Payment;

public interface PaymentMappingHelper {
	
	
	 public static PaymentDto map(Payment payment) {
		 
		 PaymentDto paymentDto=new PaymentDto();
		 BeanUtils.copyProperties(payment, paymentDto);
		 return paymentDto;
		 
		 
		 
		 
		 
		
	}

	 public static Payment map(PaymentDto paymentDto) {
		 
		 Payment payment=new Payment();
		 BeanUtils.copyProperties(paymentDto, payment);
		 return payment;
		 
		 
	 }
}
