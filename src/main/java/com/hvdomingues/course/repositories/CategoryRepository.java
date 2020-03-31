package com.hvdomingues.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.course.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
