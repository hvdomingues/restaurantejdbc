package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Bill;
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
	
	@Override
	public Bill changeTabNumber(Bill bill, Integer newTabNumber) {
		
		bill = billRepo.changeTabNumber(bill, newTabNumber);
		
		if(bill != null) {
			System.out.println("Table number of bill " + bill.getId() + " changed sucessfully to " + bill.getTableNumber() + ".");
		}
		
		return bill;
		
	}
	
	@Override
	public Bill closeBill(Bill bill) {
		return billRepo.closeBill(bill);
	}

	@Override
	public void closeService() {
		billRepo.closeEM();
	}

	@Override
	public Bill getByID(Integer id) {
		return this.billRepo.getByID(id);
	}
	
	
}
