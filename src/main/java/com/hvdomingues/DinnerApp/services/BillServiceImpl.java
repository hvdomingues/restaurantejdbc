package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.repositories.BillRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;


@Service
public class BillServiceImpl implements IBillService{
	
	@Autowired
	private BillRepositoryImpl billRepo;
	
	public BillServiceImpl() {
		this.billRepo = new BillRepositoryImpl();
	}

	public BillRepositoryImpl getBillRepo() {
		return billRepo;
	}


	
}
