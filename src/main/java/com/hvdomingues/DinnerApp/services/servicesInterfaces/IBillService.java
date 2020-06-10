package com.hvdomingues.DinnerApp.services.servicesInterfaces;
import com.hvdomingues.DinnerApp.entities.Bill;


public interface IBillService {
	
	Bill changeTabNumber(Integer billId, Integer newTabNumber);
	
}
