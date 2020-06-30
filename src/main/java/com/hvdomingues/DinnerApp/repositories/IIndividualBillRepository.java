package com.hvdomingues.DinnerApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.IndividualBill;

public interface IIndividualBillRepository extends JpaRepository<IndividualBill, Integer>{

	List<IndividualBill> findByBill(Bill bill);
	


	
}
