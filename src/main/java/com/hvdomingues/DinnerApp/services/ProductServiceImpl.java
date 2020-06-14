package com.hvdomingues.DinnerApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Product;
import com.hvdomingues.DinnerApp.repositories.ProductRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductRepositoryImpl productRepo;

	public ProductServiceImpl() {
		this.productRepo = new ProductRepositoryImpl();
	}

	@Override
	public Product getById(Integer id) {
		return productRepo.getByID(id);
	}

	@Override
	public Product saveOne(Product toSave) {
		return productRepo.saveOne(toSave);
	}

	@Override
	public List<Product> getAll() {
		return productRepo.getAll();
	}

	@Override
	public List<Product> saveAll(List<Product> toSave) {
		return productRepo.saveAll(toSave);
	}

	@Override
	public void closeService() {
		productRepo.closeEM();

	}
}
