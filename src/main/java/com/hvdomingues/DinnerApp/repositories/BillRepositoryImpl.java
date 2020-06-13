package com.hvdomingues.DinnerApp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
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
					throw new MyException("Table already occupied by an active bill. Bill id: " + x.getId() + ".");
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
	
	
	//Verifica se a conta já está fechada e verifica se foi paga através do fechamento das contas individuais. Caso as indBills estejam fechadas, logo a conta está paga.
	public Bill closeBill(Bill bill) {

		try {

			if (bill.getStatusBill() == 1) {
				throw new MyException("A conta já está fechada.");
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
					throw new MyException("Ainda há contas individuais abertas. Contas:\n" + openedIndBills);
				}
				bill.setStatusBill(1);
				update(bill);

			}
		} catch (MyException e) {
			System.out.println(e.getMessage());
			return null;
		}

		return bill;
	}
	
	
	

}
