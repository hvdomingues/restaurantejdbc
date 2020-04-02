package com.hvdomingues.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.course.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
