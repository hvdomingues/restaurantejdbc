package com.hvdomingues.DinnerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

	
	
}
