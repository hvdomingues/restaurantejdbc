package com.hvdomingues.DinnerApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.repositories.IPaymentRepository;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepo;

	@Override
	public Payment getById(Integer id) {
		return paymentRepo.findById(id).get();
	}

	@Override
	public Payment saveOne(Payment toSave) {
		return paymentRepo.save(toSave);
	}

	@Override
	public List<Payment> getAll() {
		return paymentRepo.findAll();
	}

	@Override
	public List<Payment> saveAll(List<Payment> toSave) {
		return paymentRepo.saveAll(toSave);
	}
}
