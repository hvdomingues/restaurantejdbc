package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Payment;

public interface IPaymentService {
		
	Payment getById(Integer id);
	
	Payment saveOne(Payment toSave);
	
	List<Payment> getAll();
	
	List<Payment> saveAll(List<Payment> toSave);
	
	void closeService();
	
}
