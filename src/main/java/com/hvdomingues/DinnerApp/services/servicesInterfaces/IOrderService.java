package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Order;

public interface IOrderService {
		
	
		Order getByID(Integer id);
		
		Order saveOne(Order toSave);
		
		List<Order> getAll(Integer indBillID);
		
		List<Order> saveAll(List<Order> toSave);
	
		
	
}
