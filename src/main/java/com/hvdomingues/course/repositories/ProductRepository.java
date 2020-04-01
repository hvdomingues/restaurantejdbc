package com.hvdomingues.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
