package com.hvdomingues.DinnerApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.Bill;

public interface IBillRepository extends JpaRepository<Bill, Integer> {

	List<Bill> findByStatusBill(Integer StatusBill);
	
}
