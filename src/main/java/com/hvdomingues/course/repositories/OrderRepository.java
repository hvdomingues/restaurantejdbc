package com.hvdomingues.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
