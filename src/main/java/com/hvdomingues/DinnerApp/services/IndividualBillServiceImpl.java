package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.repositories.IndividualBillRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IIndividualBillService;


@Service
public class IndividualBillServiceImpl implements IIndividualBillService{
	
	@Autowired
	private IndividualBillRepositoryImpl individualBillRepository;
	
	public IndividualBillServiceImpl() {
		this.individualBillRepository = new IndividualBillRepositoryImpl();
	}
	
	public IndividualBillRepositoryImpl getRepo() {
		return individualBillRepository;
	}
}
