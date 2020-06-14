package com.hvdomingues.DinnerApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvdomingues.DinnerApp.entities.BillPayment;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.repositories.BillPaymentRepositoryImpl;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillPaymentService;


@Service
public class BillPaymentServiceImpl implements IBillPaymentService{
	
	@Autowired
	private BillPaymentRepositoryImpl billPaymentRepo;
	
	public BillPaymentServiceImpl() {
		this.billPaymentRepo = new BillPaymentRepositoryImpl();
	}
	

	@Override
	public BillPayment saveOne(Payment payment, IndividualBill indBill) {
		if(payment != null && indBill != null) {
			BillPayment billPayment = new BillPayment(payment, indBill);
			return billPaymentRepo.saveOne(billPayment);
		}
		return null;
	}


	@Override
	public void closeService() {
		billPaymentRepo.closeEM();
		
	}
}
