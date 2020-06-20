package com.hvdomingues.DinnerApp.application;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.builder.EntityBuilder;
import com.hvdomingues.DinnerApp.services.factories.ServiceFactory;


public class TestApp {
	public static void main(String[] args) {

		
		EntityBuilder entityBuilder = new EntityBuilder();
		ServiceFactory serviceFactory = new ServiceFactory();
						
		
		Bill bill1 = serviceFactory.createBillService().getByID(1);
		IndividualBill indBill1 = entityBuilder.createIndividualBill(bill1, "Paulo", 2);
		System.out.println(entityBuilder.createPayment(69.90, indBill1));
		
		
	

	}

}

