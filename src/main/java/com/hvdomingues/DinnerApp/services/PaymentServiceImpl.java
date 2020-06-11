package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.repositories.PaymentRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IPaymentService;


@Service
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	private PaymentRepositoryImpl paymentRepository;
	
	public PaymentServiceImpl() {
		this.paymentRepository = new PaymentRepositoryImpl();
	}
	
	public PaymentRepositoryImpl getRepo() {
		return paymentRepository;
	}
}
