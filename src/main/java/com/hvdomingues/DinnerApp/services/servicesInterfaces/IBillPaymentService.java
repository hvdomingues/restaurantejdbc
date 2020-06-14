package com.hvdomingues.DinnerApp.services.servicesInterfaces;

import com.hvdomingues.DinnerApp.entities.BillPayment;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Payment;

public interface IBillPaymentService {
		
		BillPayment saveOne(Payment payment, IndividualBill indBill);
		
		void closeService();
		
}
