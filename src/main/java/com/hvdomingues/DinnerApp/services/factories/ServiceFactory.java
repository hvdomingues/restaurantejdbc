package com.hvdomingues.DinnerApp.services.factories;

import com.hvdomingues.DinnerApp.services.BillPaymentServiceImpl;
import com.hvdomingues.DinnerApp.services.BillServiceImpl;
import com.hvdomingues.DinnerApp.services.CategoryServiceImpl;
import com.hvdomingues.DinnerApp.services.IndividualBillServiceImpl;
import com.hvdomingues.DinnerApp.services.OrderItemServiceImpl;
import com.hvdomingues.DinnerApp.services.OrderServiceImpl;
import com.hvdomingues.DinnerApp.services.PaymentServiceImpl;
import com.hvdomingues.DinnerApp.services.ProductServiceImpl;

public class ServiceFactory {

	public BillServiceImpl createBillService() {
		return new BillServiceImpl();
	}
	
	public BillPaymentServiceImpl createBillPaymentService() {
		return new BillPaymentServiceImpl();
	}
	
	
	public CategoryServiceImpl createCategoryService() {
		return new CategoryServiceImpl();
	}
	
	public IndividualBillServiceImpl createIndBillService() {
		return new IndividualBillServiceImpl();
	}
	
	public OrderItemServiceImpl createOrderItemService() {
		return new OrderItemServiceImpl();
	}
	
	public OrderServiceImpl createOrderService() {
		return new OrderServiceImpl();
	}
	
	public PaymentServiceImpl createPaymentService() {
		return new PaymentServiceImpl();
	}
	
	public ProductServiceImpl createProductService() {
		return new ProductServiceImpl();
	}
}
