package com.hvdomingues.DinnerApp.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hvdomingues.DinnerApp.entities.Bill;

@Repository
public class BillRepositoryImpl extends GenRepository<Bill> {

	public Bill changeTabNumber(Bill bill, Integer newTabNumber) {
		
		List<Bill> bills = getAll();
		
		for(Bill x : bills) {
			if(x.getStatusBill() == 0 && x.getTableNumber() == newTabNumber) {
				return null;
			}
		}
		
		bill.setTableNumber(newTabNumber);

		return update(bill);
	}
	
	

}
