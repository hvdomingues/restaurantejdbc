package com.hvdomingues.DinnerApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.OrderItem;
import com.hvdomingues.DinnerApp.repositories.OrderItemRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderItemService;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

	@Autowired
	private OrderItemRepositoryImpl orderItemRepo;

	public OrderItemServiceImpl() {
		this.orderItemRepo = new OrderItemRepositoryImpl();
	}

	@Override
	public OrderItem getByID(Integer id) {
		return orderItemRepo.getByID(id);
	}

	@Override
	public OrderItem saveOne(OrderItem toSave) {
		return orderItemRepo.saveOne(toSave);
	}

	@Override
	public List<OrderItem> getAll() {
		return orderItemRepo.getAll();
	}

	@Override
	public List<OrderItem> saveAll(List<OrderItem> toSave) {
		return orderItemRepo.saveAll(toSave);
	}

	@Override
	public void closeService() {
		orderItemRepo.closeEM();

	}
}
