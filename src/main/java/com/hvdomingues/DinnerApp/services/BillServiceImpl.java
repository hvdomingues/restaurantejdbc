package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.repositories.BillRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;


@Service
public class BillServiceImpl implements IBillService{
	
	@Autowired
	private BillRepositoryImpl billRepo = new BillRepositoryImpl();
	
	public Bill changeTabNumber(Integer billId, Integer newTabNumber) {
		
		Bill bill = billRepo.getByID(billId);
		
		//billRepository.getByID(billId);
		bill.setTableNumber(newTabNumber);
		
		
		return billRepo.update(bill);
	}

	public BillRepositoryImpl getBillRepo() {
		return billRepo;
	}


	
}
