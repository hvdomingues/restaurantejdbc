package com.hvdomingues.DinnerApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Order;
import com.hvdomingues.DinnerApp.repositories.IOrderRepository;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderService;


@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private IOrderRepository orderRepo;
	

	@Override
	public Order getByID(Integer id) {
		return orderRepo.findById(id).get();
	}

	@Override
	public Order saveOne(Order toSave) {
		return orderRepo.save(toSave);
	}

	@Override
	public List<Order> getAll(Integer indBillID) {
		IndividualBill indBill = new IndividualBill();
		indBill.setId(indBillID);
		return orderRepo.findByIndBill(indBill);
	}

	@Override
	public List<Order> saveAll(List<Order> toSave) {
		return orderRepo.saveAll(toSave);
	}	

}
