package com.hvdomingues.DinnerApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.exceptions.MyException;
import com.hvdomingues.DinnerApp.repositories.BillRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;


@Service
public class BillServiceImpl implements IBillService{
	
	@Autowired
	private BillRepositoryImpl billRepo;
	
	public BillServiceImpl() {
		this.billRepo = new BillRepositoryImpl();
	}

	
	@Override
	public Bill changeTabNumber(Bill bill, Integer newTabNumber) {
		
		bill = billRepo.changeTabNumber(bill, newTabNumber);
		
		if(bill != null) {
			System.out.println("Table number of bill " + bill.getId() + " changed sucessfully to " + bill.getTableNumber() + ".");
		}
		
		return bill;
		
	}
	
	@Override
	public Bill closeBill(Bill bill) {
		return billRepo.closeBill(bill);
	}

	@Override
	public void closeService() {
		billRepo.closeEM();
	}

	@Override
	public Bill getByID(Integer id) {
		return billRepo.getByID(id);
	}

	@Override
	public List<Bill> getAll() {
		return billRepo.getAll();
	}


	@Override
	public List<Bill> saveAll(List<Bill> toSave) {
		return billRepo.saveAll(toSave);
	}


	@Override
	public Bill saveOne(Bill toSave) {
		
		List<Bill> bills = getAll();
		try {
			for (Bill x : bills) {
				if (x.getStatusBill() == 0 && x.getTableNumber() == toSave.getTableNumber()) {

					throw new MyException("Table already occupied by an active bill. Bill id: " + x.getId() + ".");
				}
			}

		}

		catch (MyException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return billRepo.saveOne(toSave);
	}
	
	
}
