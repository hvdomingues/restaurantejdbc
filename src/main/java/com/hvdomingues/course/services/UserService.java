package com.hvdomingues.course.services;

import java.util.List;

import com.hvdomingues.course.entities.User;


public interface UserService {
		
	List<User> findAll();
	
	User findById(Long id);
	
	User insert(User obj);
	
	void delete(Long id);
	
	User update(Long id, User obj);
	
}
