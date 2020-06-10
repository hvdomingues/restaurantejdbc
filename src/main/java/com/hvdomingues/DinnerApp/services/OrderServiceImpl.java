package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.repositories.OrderRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderService;


@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
	
	public OrderRepositoryImpl getRepo() {
		return orderRepository;
	}
}
