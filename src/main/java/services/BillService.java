package services;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Bill;

public interface BillService {

	String saveAll(List<Bill> toSave);
	
}
