package com.hvdomingues.DinnerApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Category;
import com.hvdomingues.DinnerApp.repositories.ICategoryRepository;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.ICategoryService;


@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryRepository categoryRepository;
	

	@Override
	public Category getByID(Integer id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category saveOne(Category toSave) {
		return categoryRepository.save(toSave);
	}

	@Override
	public List<Category> saveAll(List<Category> toSave) {
		return categoryRepository.saveAll(toSave);
	}


	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
}
