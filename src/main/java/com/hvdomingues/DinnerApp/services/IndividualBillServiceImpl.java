package com.hvdomingues.DinnerApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.repositories.IIndividualBillRepository;
import com.hvdomingues.DinnerApp.services.exceptions.MyException2;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IIndividualBillService;

@Service
public class IndividualBillServiceImpl implements IIndividualBillService {

	@Autowired
	private IIndividualBillRepository indBillRepo;

	@Override
	public IndividualBill saveOne(IndividualBill toSave) {

		if (toSave.getBill() == null || toSave.getBill().getStatusBill() == 1) {
			throw new MyException2("Impossível criar conta individual sem uma conta principal ativa.");
		}
		List<IndividualBill> indBills = toSave.getBill().getIndividualBills();
		for (IndividualBill indBill : indBills) {
			if (indBill.getTabPosition() == toSave.getTabPosition()) {
				throw new MyException2("Já há uma conta individual para esse lugar da mesa.");
			}
		}

		return indBillRepo.save(toSave);
	}

	@Override
	public List<IndividualBill> saveAll(List<IndividualBill> toSave) {
		return indBillRepo.saveAll(toSave);
	}

	@Override
	public List<IndividualBill> getAll() {
		return indBillRepo.findAll();
	}

	@Override
	public IndividualBill getByID(Integer id) {
		return indBillRepo.findById(id).get();
	}

}
