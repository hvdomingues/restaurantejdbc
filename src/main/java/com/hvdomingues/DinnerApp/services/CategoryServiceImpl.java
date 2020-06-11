package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.repositories.CategoryRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.ICategoryService;


@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private CategoryRepositoryImpl categoryRepository;
	
	public CategoryServiceImpl() {
		this.categoryRepository = new CategoryRepositoryImpl();
	}
	
	public CategoryRepositoryImpl getRepo() {
		return categoryRepository;
	}
}
