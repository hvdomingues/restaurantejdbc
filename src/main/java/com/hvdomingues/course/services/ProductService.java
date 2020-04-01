package com.hvdomingues.course.services;

import java.util.List;

import com.hvdomingues.course.entities.Product;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(Long id);
	
}
