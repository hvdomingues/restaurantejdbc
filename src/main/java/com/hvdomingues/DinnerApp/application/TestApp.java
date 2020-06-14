package com.hvdomingues.DinnerApp.application;

import com.hvdomingues.DinnerApp.entities.builder.EntityBuilder;
import com.hvdomingues.DinnerApp.services.factories.ServiceFactory;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;


public class TestApp {
	public static void main(String[] args) {

		
		ServiceFactory serviceFactory = new ServiceFactory();
		EntityBuilder entityBuilder = new EntityBuilder();
		
		IBillService billService = serviceFactory.createBillService();
				
		billService.closeBill(billService.getByID(25));
		
		entityBuilder.createBill(9);
		
		billService.closeService();
	

	}

}

