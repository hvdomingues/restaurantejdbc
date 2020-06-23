package com.hvdomingues.DinnerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Integer>{

	
	
}
