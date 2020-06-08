package services;

import com.hvdomingues.DinnerApp.entities.Bill;

public interface BillService {
	
	Bill changeTabNumber(Integer billId, Integer newTabNumber);
	
}
