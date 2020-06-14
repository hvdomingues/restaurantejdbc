package com.hvdomingues.DinnerApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Category;
import com.hvdomingues.DinnerApp.repositories.CategoryRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.ICategoryService;


@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private CategoryRepositoryImpl categoryRepository;
	
	public CategoryServiceImpl() {
		this.categoryRepository = new CategoryRepositoryImpl();
	}
	

	@Override
	public Category getByID(Integer id) {
		return categoryRepository.getByID(id);
	}

	@Override
	public Category saveOne(Category toSave) {
		return categoryRepository.saveOne(toSave);
	}

	@Override
	public List<Category> saveAll(List<Category> toSave) {
		return categoryRepository.saveAll(toSave);
	}

	@Override
	public void closeService() {
		categoryRepository.closeEM();
		
	}


	@Override
	public List<Category> getAll() {
		return categoryRepository.getAll();
	}
}
