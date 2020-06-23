package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.services.exceptions.MyException2;

public interface IBillService {

	Bill changeTabNumber(Bill bill, Integer newTabNumber);

	Bill closeBill(Bill bill);

	Bill getByID(Integer id);

	List<Bill> getAll();
	
	List<Bill> saveAll(List<Bill> toSave);
	
	Bill saveOne(Bill toSave) throws MyException2;
}
