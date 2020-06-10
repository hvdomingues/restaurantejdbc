package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.repositories.BillPaymentRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillPaymentService;


@Service
public class BillPaymentServiceImpl implements IBillPaymentService{
	
	@Autowired
	private BillPaymentRepositoryImpl billPaymentRepository = new BillPaymentRepositoryImpl();
	
	public BillPaymentRepositoryImpl getRepo() {
		return billPaymentRepository;
	}
}
