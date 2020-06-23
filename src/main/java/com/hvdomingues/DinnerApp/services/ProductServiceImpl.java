package com.hvdomingues.DinnerApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Product;
import com.hvdomingues.DinnerApp.repositories.IProductRepository;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductRepository productRepo;

	@Override
	public Product getById(Integer id) {
		return productRepo.findById(id).get();
	}

	@Override
	public Product saveOne(Product toSave) {
		return productRepo.save(toSave);
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> saveAll(List<Product> toSave) {
		return productRepo.saveAll(toSave);
	}

	
}
