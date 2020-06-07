package services;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Bill;

import repositories.GenRepository;

public class BillServiceImpl implements BillService {

	private GenRepository<Bill> genRepository;

	@Override
	public String saveAll(List<Bill> toSave) {
		return genRepository.saveAll(toSave);
	}

}
