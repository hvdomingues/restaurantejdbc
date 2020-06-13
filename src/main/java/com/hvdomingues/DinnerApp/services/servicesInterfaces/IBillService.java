package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import com.hvdomingues.DinnerApp.entities.Bill;

public interface IBillService {

	
	Bill changeTabNumber(Bill bill, Integer newTabNumber);
	Bill closeBill(Bill bill);
	void closeService();
	Bill getByID(Integer id);
	
	
}
