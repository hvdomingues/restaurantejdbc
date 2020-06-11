package com.hvdomingues.DinnerApp.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.exceptions.MyException;

@Repository
public class BillRepositoryImpl extends GenRepository<Bill> {

	// Antes de commitar no banco de dados, verifica se existe alguma conta aberta
	// com o mesmo número de mesa
	public Bill changeTabNumber(Bill bill, Integer newTabNumber) {

		List<Bill> bills = getAll();
		try {
			for (Bill x : bills) {
				if (x.getStatusBill() == 0 && x.getTableNumber() == newTabNumber) {
					// Teste de Exception personalizada
					throw new MyException("Table already occupied by an active bill. Bill id: " + bill.getId() + ".");
				}
			}
			
			bill = update(bill);
			bill.setTableNumber(newTabNumber);
		}

		catch (MyException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return bill;
	}

}
