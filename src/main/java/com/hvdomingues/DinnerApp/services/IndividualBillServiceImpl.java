package com.hvdomingues.DinnerApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.exceptions.MyException;
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
		
		try{
			if(toSave.getBill() == null || toSave.getBill().getStatusBill() == 1) {
				throw new MyException("Impossível criar conta individual sem uma conta principal ativa.");
			}
			List<IndividualBill> indBills = toSave.getBill().getIndividualBills();
			for(IndividualBill indBill : indBills) {
				if(indBill.getTabPosition() == toSave.getTabPosition()) {
					throw new MyException("Já há uma conta individual para esse lugar da mesa.");
				}
			}
		}
		catch(MyException e) {
			System.out.println(e.getMessage());
			return null;
		}
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
