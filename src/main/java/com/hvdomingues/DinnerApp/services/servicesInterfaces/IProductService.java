package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Product;

public interface IProductService {

	Product getById(Integer id);

	Product saveOne(Product toSave);

	List<Product> getAll();

	List<Product> saveAll(List<Product> toSave);

	
}
