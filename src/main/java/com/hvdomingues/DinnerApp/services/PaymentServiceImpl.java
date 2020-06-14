package com.hvdomingues.DinnerApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.repositories.PaymentRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepositoryImpl paymentRepo;

	public PaymentServiceImpl() {
		this.paymentRepo = new PaymentRepositoryImpl();
	}

	@Override
	public Payment getById(Integer id) {
		return paymentRepo.getByID(id);
	}

	@Override
	public Payment saveOne(Payment toSave) {
		return paymentRepo.saveOne(toSave);
	}

	@Override
	public List<Payment> getAll() {
		return paymentRepo.getAll();
	}

	@Override
	public List<Payment> saveAll(List<Payment> toSave) {
		return paymentRepo.saveAll(toSave);
	}

	@Override
	public void closeService() {
		paymentRepo.closeEM();

	}
}
