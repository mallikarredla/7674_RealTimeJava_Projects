package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
