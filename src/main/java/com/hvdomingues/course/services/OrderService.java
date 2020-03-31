package com.hvdomingues.course.services;

import java.util.List;

import com.hvdomingues.course.entities.Order;


public interface OrderService {

	
	List<Order> findAll();
	
	Order findById(Long id);
	
}
