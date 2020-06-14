package com.hvdomingues.DinnerApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Order;
import com.hvdomingues.DinnerApp.repositories.OrderRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderService;


@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrderRepositoryImpl orderRepo;
	
	public OrderServiceImpl() {
		this.orderRepo = new OrderRepositoryImpl();
	}

	@Override
	public Order getByID(Integer id) {
		return orderRepo.getByID(id);
	}

	@Override
	public Order saveOne(Order toSave) {
		return orderRepo.saveOne(toSave);
	}

	@Override
	public List<Order> getAll() {
		return orderRepo.getAll();
	}

	@Override
	public List<Order> saveAll(List<Order> toSave) {
		return orderRepo.saveAll(toSave);
	}

	@Override
	public void closeService() {
		orderRepo.closeEM();
		
	}
	

}
