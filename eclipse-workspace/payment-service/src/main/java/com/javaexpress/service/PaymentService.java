package com.javaexpress.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.PaymentDto;
import com.javaexpress.helper.PaymentMappingHelper;
import com.javaexpress.model.Payment;
import com.javaexpress.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	/*public PaymentDto save(PaymentDto paymentDto) {
		log.info("PaymentService save ");
		
	Payment payment=	PaymentMappingHelper.map(paymentDto);
		//Payment payment =PaymentMappingHelper.map(paymentDto);
		Payment dbPayment=paymentRepository.save(payment);
		return PaymentMappingHelper.map(dbPayment);
	}*/
	public PaymentDto save(PaymentDto paymentDto) {
	    Payment payment = new Payment();
	    payment.setIsPaymentDone(paymentDto.getIsPaymentDone());
	    payment.setPaymentStatus(paymentDto.getPaymentStatus());  // Important!
	    payment.setOrderId(paymentDto.getOrderId());

	    Payment saved = paymentRepository.save(payment);

	    PaymentDto response = new PaymentDto();
	    response.setPaymentId(saved.getPaymentId());
	    response.setIsPaymentDone(saved.getIsPaymentDone());
	    response.setPaymentStatus(saved.getPaymentStatus());
	    response.setOrderId(saved.getOrderId());
	    response.setOrderDto(paymentDto.getOrderDto()); // optional

	    return response;
	}
	public PaymentDto update(Integer paymentId,PaymentDto paymentDto) {
		paymentDto.setPaymentId(paymentId);
		
	Payment payment=paymentRepository.findById(paymentId).orElseThrow(()->new RuntimeException("payment not found exception"));
	
	BeanUtils.copyProperties(paymentDto, payment);
	Payment updatedPayment=paymentRepository.save(payment);
	return PaymentMappingHelper.map(updatedPayment);
	
	
	}

}
