package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.repositories.BillRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;


@Service
public class BillServiceImpl implements IBillService{
	
	@Autowired
	private BillRepositoryImpl billRepo;
	
	public BillServiceImpl() {
		this.billRepo = new BillRepositoryImpl();
	}

	public BillRepositoryImpl getBillRepo() {
		return billRepo;
	}
	
	/*Não seria melhor fazer um método desse tipo para todos os métodos do billRepo? O cliente não veria o billRepo, então excluiria a necessidade do getBillRepo.
	 * Caso tivesse alguma outra lógica para ser feita no serviço, seria apenas escrevê-la nesses métodos. */
	public Bill changeTabNumber(Bill bill, Integer newTabNumber) {
		
		bill = billRepo.changeTabNumber(bill, newTabNumber);
		
		if(bill != null) {
			System.out.println("Table number of bill " + bill.getId() + " changed sucessfully to " + bill.getTableNumber() + ".");
		}
		
		return bill;
		
	}
	
	
}
