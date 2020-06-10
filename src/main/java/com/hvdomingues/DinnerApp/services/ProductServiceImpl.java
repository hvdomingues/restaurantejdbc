package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.repositories.ProductRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IProductService;


@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
	
	public ProductRepositoryImpl getRepo() {
		return productRepository;
	}
}
