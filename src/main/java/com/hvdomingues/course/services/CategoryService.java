package com.hvdomingues.course.services;

import java.util.List;

import com.hvdomingues.course.entities.Category;

public interface CategoryService {

	List<Category> findAll();
	
	Category findById(Long id);
	
}
