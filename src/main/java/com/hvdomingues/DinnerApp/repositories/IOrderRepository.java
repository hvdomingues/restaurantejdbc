package com.hvdomingues.DinnerApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer>{

	List<Order> findByIndBill(IndividualBill indBill);
	
}
