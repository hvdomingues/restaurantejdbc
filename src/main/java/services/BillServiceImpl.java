package services;

import com.hvdomingues.DinnerApp.entities.Bill;

import repositories.GenRepository;

public class BillServiceImpl extends GenRepository<Bill> {
	
	public Bill changeTabNumber(Integer billId, Integer newTabNumber) {
		
		Bill bill = getByID(billId);
		bill.setTableNumber(newTabNumber);
		
		return update(bill);
	}

}
