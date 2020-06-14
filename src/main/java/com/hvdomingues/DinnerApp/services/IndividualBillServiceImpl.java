package com.hvdomingues.DinnerApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.repositories.IndividualBillRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IIndividualBillService;


@Service
public class IndividualBillServiceImpl implements IIndividualBillService{
	
	@Autowired
	private IndividualBillRepositoryImpl indBillRepo;
	
	public IndividualBillServiceImpl() {
		this.indBillRepo = new IndividualBillRepositoryImpl();
	}

	@Override
	public IndividualBill saveOne(IndividualBill toSave) {
		return indBillRepo.saveOne(toSave);
	}

	@Override
	public List<IndividualBill> saveAll(List<IndividualBill> toSave) {
		return indBillRepo.saveAll(toSave);
	}

	@Override
	public List<IndividualBill> getAll() {
		return indBillRepo.getAll();
	}

	@Override
	public IndividualBill getByID(Integer id) {
		return indBillRepo.getByID(id);
	}

	@Override
	public void closeService() {
		indBillRepo.closeEM();
		
	}
	
}
