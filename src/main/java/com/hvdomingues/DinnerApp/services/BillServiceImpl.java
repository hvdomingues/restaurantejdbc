package com.hvdomingues.DinnerApp.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.repositories.IBillRepository;
import com.hvdomingues.DinnerApp.services.exceptions.MyException2;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;

@Service
public class BillServiceImpl implements IBillService {

	@Autowired
	private IBillRepository billRepo;

	@Override
	public Bill changeTabNumber(Bill bill, Integer newTabNumber) {

		List<Bill> bills = billRepo.findAll();
		for (Bill x : bills) {
			if (x.getStatusBill() == 0 && x.getTableNumber() == newTabNumber) {
				throw new MyException2("Table already occupied by an active bill. Bill id: " + x.getId() + ".");
			}
		}

		bill.setTableNumber(newTabNumber);
		bill = billRepo.save(bill);

		return bill;

	}

	@Override
	public Bill closeBill(Bill bill) {

		if (bill.getStatusBill() == 1) {
			throw new MyException2("A conta já está fechada.");
		}

		if (bill.getIndividualBills() != null) {
			List<IndividualBill> indBills = bill.getIndividualBills();
			List<IndividualBill> openedIndBills = new ArrayList<>();

			for (IndividualBill indBill : indBills) {
				if (indBill.getStatusBill() == 0) {
					openedIndBills.add(indBill);
				}
			}

			if (openedIndBills.size() >= 1) {
				throw new MyException2("Ainda há contas individuais abertas. Contas:\n" + openedIndBills);
			}
			bill.setStatusBill(1);
			billRepo.save(bill);

		}
		return bill;
	}

	@Override
	public Bill getByID(Integer id) {
		return billRepo.findById(id).get();
	}
	
	@Override
	public List<Bill> getAll() {
		return billRepo.findAll();
	}

	@Override
	public List<Bill> getInactiveBills() {
		return billRepo.findByStatusBill(1);
		
	}
	
	@Override
	public List<Bill> getActiveBills() {
		List<Bill> results = billRepo.findByStatusBill(0);
		results.sort(Comparator.comparing(Bill::getTableNumber));
		return results;
	}

	@Override
	public List<Bill> saveAll(List<Bill> toSave) {
		return billRepo.saveAll(toSave);
	}

	@Override
	public Bill saveOne(Bill toSave) {

		List<Bill> bills = getAll();

		for (Bill x : bills) {
			if (x.getStatusBill() == 0 && x.getTableNumber() == toSave.getTableNumber()) {

				throw new MyException2("Table already occupied by an active bill. Bill id: " + x.getId() + ".");

			}
		}

		return billRepo.save(toSave);
	}


}
