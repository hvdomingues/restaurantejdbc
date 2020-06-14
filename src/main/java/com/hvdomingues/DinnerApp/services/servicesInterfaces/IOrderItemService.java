package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.OrderItem;

public interface IOrderItemService {
		
	OrderItem getByID(Integer id);
	
	OrderItem saveOne(OrderItem toSave);
	
	List<OrderItem> getAll();
	
	List<OrderItem> saveAll(List<OrderItem> toSave);
	
	void closeService();
	
}
