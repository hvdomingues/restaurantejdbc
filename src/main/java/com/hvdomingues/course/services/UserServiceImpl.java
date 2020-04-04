package com.hvdomingues.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.course.entities.User;
import com.hvdomingues.course.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	@Override
	public User insert(User obj) {
		return repository.save(obj);
	}
	
}
