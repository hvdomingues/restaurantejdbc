package com.hvdomingues.DinnerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer>{

	
	
}
