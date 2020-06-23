package com.hvdomingues.DinnerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Integer>{

	
	
}
