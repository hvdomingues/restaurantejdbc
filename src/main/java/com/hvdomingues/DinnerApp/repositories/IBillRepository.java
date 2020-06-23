package com.hvdomingues.DinnerApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.Bill;

public interface IBillRepository extends JpaRepository<Bill, Integer> {

}
