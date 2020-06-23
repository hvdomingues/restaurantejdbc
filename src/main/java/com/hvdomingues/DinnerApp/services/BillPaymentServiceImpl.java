package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.BillPayment;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.repositories.IBillPaymentRepository;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillPaymentService;


@Service
public class BillPaymentServiceImpl implements IBillPaymentService{
	
	@Autowired
	private IBillPaymentRepository billPaymentRepo;
	

	@Override
	public BillPayment saveOne(Payment payment, IndividualBill indBill) {
		if(payment != null && indBill != null) {
			BillPayment billPayment = new BillPayment(payment, indBill);
			return billPaymentRepo.save(billPayment);
		}
		return null;
	}


}
