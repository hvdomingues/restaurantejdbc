package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.IndividualBill;

public interface IIndividualBillService {
		
	IndividualBill saveOne(IndividualBill toSave);
	
	List<IndividualBill> saveAll(List<IndividualBill> toSave);
	
	List<IndividualBill> getAll();
	
	IndividualBill getByID(Integer id);
	

	
}
