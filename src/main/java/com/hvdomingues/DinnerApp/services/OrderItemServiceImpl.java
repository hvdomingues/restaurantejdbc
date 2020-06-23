package com.hvdomingues.DinnerApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.OrderItem;
import com.hvdomingues.DinnerApp.repositories.IOrderItemRepository;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderItemService;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

	@Autowired
	private IOrderItemRepository orderItemRepo;


	@Override
	public OrderItem getByID(Integer id) {
		return orderItemRepo.findById(id).get();
	}

	@Override
	public OrderItem saveOne(OrderItem toSave) {
		return orderItemRepo.save(toSave);
	}

	@Override
	public List<OrderItem> getAll() {
		return orderItemRepo.findAll();
	}

	@Override
	public List<OrderItem> saveAll(List<OrderItem> toSave) {
		return orderItemRepo.saveAll(toSave);
	}
}
