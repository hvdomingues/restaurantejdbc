package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Category;

public interface ICategoryService {
		
	Category getByID(Integer id);
	
	Category saveOne(Category toSave);
	
	List<Category> saveAll(List<Category> toSave);
	
	List<Category> getAll();
	
	
	
}
