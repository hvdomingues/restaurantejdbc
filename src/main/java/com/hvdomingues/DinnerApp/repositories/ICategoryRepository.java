package com.hvdomingues.DinnerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer>{

	
	
}
