package com.hvdomingues.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.course.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
}
