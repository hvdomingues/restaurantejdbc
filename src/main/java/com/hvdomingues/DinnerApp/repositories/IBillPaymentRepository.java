package com.hvdomingues.DinnerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.BillPayment;

public interface IBillPaymentRepository extends JpaRepository<BillPayment, Integer>{

	
	
}
