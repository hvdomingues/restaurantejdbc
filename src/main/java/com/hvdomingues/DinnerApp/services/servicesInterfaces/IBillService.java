package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Bill;

public interface IBillService {

	Bill changeTabNumber(Bill bill, Integer newTabNumber);

	Bill closeBill(Bill bill);

	Bill getByID(Integer id);

	List<Bill> getAll();
	
	List<Bill> getInactiveBills();
	
	List<Bill> getActiveBills();
	
	List<Bill> saveAll(List<Bill> toSave);
	
	
	Bill saveOne(Bill toSave);

	
	
	
}
