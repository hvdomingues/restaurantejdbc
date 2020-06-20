package com.hvdomingues.DinnerApp.application;

import java.util.List;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.builder.EntityBuilder;
import com.hvdomingues.DinnerApp.services.factories.ServiceFactory;


public class TestApp {
	public static void main(String[] args) {

		
		EntityBuilder entityBuilder = new EntityBuilder();
		ServiceFactory serviceFactory = new ServiceFactory();
						
		
		/*
		 * Bill bill1 = serviceFactory.createBillService().getByID(1); IndividualBill
		 * indBill1 = entityBuilder.createIndividualBill(bill1, "Paulo", 2);
		 */
		List<Bill> bills = serviceFactory.createBillService().getAll();
		
		for(Bill bill : bills) {
			if(bill.getStatusBill() == 1) {
				System.out.println(bill.toString());
			}
			
		}
		
		
	

	}

}

