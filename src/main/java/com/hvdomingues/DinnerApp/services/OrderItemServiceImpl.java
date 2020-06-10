package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.repositories.OrderItemRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderItemService;


@Service
public class OrderItemServiceImpl implements IOrderItemService{
	
	@Autowired
	private OrderItemRepositoryImpl orderItemRepository = new OrderItemRepositoryImpl();
	
	public OrderItemRepositoryImpl getRepo() {
		return orderItemRepository;
	}
}
