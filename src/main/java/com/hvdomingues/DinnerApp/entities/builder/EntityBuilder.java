package com.hvdomingues.DinnerApp.entities.builder;

import java.time.Instant;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.BillPayment;
import com.hvdomingues.DinnerApp.entities.Category;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Order;
import com.hvdomingues.DinnerApp.entities.OrderItem;
import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.entities.Product;
import com.hvdomingues.DinnerApp.services.BillPaymentServiceImpl;
import com.hvdomingues.DinnerApp.services.BillServiceImpl;
import com.hvdomingues.DinnerApp.services.CategoryServiceImpl;
import com.hvdomingues.DinnerApp.services.IndividualBillServiceImpl;
import com.hvdomingues.DinnerApp.services.OrderItemServiceImpl;
import com.hvdomingues.DinnerApp.services.OrderServiceImpl;
import com.hvdomingues.DinnerApp.services.PaymentServiceImpl;
import com.hvdomingues.DinnerApp.services.ProductServiceImpl;


//Utilizado o site "https://refactoring.guru/pt-br/design-patterns/builder" para referências.
public class EntityBuilder {

	private Bill bill;
	private IndividualBill individualBill;
	private BillPayment billPayment;
	private Order order;
	private OrderItem orderItem;
	private Payment payment;
	private Product product;
	private Category category;

	public Bill createBill(Integer id, Integer tableNumber, Integer statusBill) {

		// Instanciando o novo objeto
		this.bill = new Bill();

		// Settando valores do objeto
		this.bill.setId(id);
		this.bill.setStatusBill(statusBill);
		this.bill.setTableNumber(tableNumber);

		// Instanciando o serviço
		BillServiceImpl billService = new BillServiceImpl();

		// Persistindo objeto no BD
		this.bill = billService.getBillRepo().saveOne(this.bill);

		// Fechando conexão
		billService.getBillRepo().closeEM();

		return this.bill;

	}

	public IndividualBill createIndividualBill(Integer id, Bill bill, String observation, Integer tabPosition) {

		// Instanciando o novo objeto
		this.individualBill = new IndividualBill();

		// Settando valores do objeto
		this.individualBill.setId(id);
		this.individualBill.setBill(bill);
		this.individualBill.setObservation(observation);
		this.individualBill.setTabPosition(tabPosition);

		// Instanciando o serviço
		IndividualBillServiceImpl individualBillService = new IndividualBillServiceImpl();

		// Persistindo objeto no BD
		this.individualBill = individualBillService.getRepo().saveOne(this.individualBill);

		// Fechando conexão
		individualBillService.getRepo().closeEM();

		return this.individualBill;
	}

	public BillPayment createBillPayment(Payment payment, IndividualBill individualBill) {
		// Instanciando o novo objeto
		this.billPayment = new BillPayment();

		// Settando valores do objeto
		this.billPayment.setIndBill(individualBill);
		this.billPayment.setPayment(payment);

		// Instanciando o serviço
		BillPaymentServiceImpl billPaymentService = new BillPaymentServiceImpl();

		// Persistindo objeto no BD
		this.billPayment = billPaymentService.getRepo().saveOne(this.billPayment);

		// Fechando conexão
		billPaymentService.getRepo().closeEM();

		return this.billPayment;
	}

	public Order createOrder(Integer id, Instant moment, IndividualBill individualBill) {
		// Instanciando o novo objeto
		this.order = new Order();

		// Settando valores do objeto
		this.order.setId(id);
		this.order.setIndBill(individualBill);
		this.order.setMoment(moment);

		// Instanciando o serviço
		OrderServiceImpl orderService = new OrderServiceImpl();

		// Persistindo objeto no BD
		this.order = orderService.getRepo().saveOne(this.order);

		// Fechando conexão
		orderService.getRepo().closeEM();

		return this.order;
	}

	public OrderItem createOrderItem(Integer id, Integer quantity, Order order, Product product) {
		// Instanciando o novo objeto
		this.orderItem = new OrderItem();

		// Settando valores do objeto
		this.orderItem.setId(id);
		this.orderItem.setOrder(order);
		this.orderItem.setProduct(product);
		this.orderItem.setQuantity(quantity);
		this.orderItem.setItemPrice();

		// Instanciando o serviço
		OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();

		// Persistindo objeto no BD
		this.orderItem = orderItemService.getRepo().saveOne(this.orderItem);

		// Fechando conexão
		orderItemService.getRepo().closeEM();

		return this.orderItem;
	}

	public Payment createPayment(Integer id, Instant moment, Double paymentValue) {
		// Instanciando o novo objeto
		this.payment = new Payment();

		// Settando valores do objeto
		this.payment.setId(id);
		this.payment.setPayMoment(moment);
		this.payment.setPayValue(paymentValue);

		// Instanciando o serviço
		PaymentServiceImpl paymentService = new PaymentServiceImpl();

		// Persistindo objeto no BD
		this.payment = paymentService.getRepo().saveOne(this.payment);

		// Fechando conexão
		paymentService.getRepo().closeEM();

		return this.payment;
	}

	public Product createProduct(Integer id, String productName, Double price, String desc, Category category) {
		// Instanciando o novo objeto
		this.product = new Product();

		// Settando valores do objeto
		this.product.setCategory(category);
		this.product.setDescription(desc);
		this.product.setId(id);
		this.product.setName(productName);
		this.product.setPrice(price);

		// Instanciando o serviço
		ProductServiceImpl productService = new ProductServiceImpl();

		// Persistindo objeto no BD
		this.product = productService.getRepo().saveOne(this.product);

		// Fechando conexão
		productService.getRepo().closeEM();

		return this.product;
	}

	public Category createCategory(Integer id, String categoryName) {
		// Instanciando o novo objeto
		this.category = new Category();

		// Settando valores do objeto
		this.category.setId(id);
		this.category.setName(categoryName);;

		// Instanciando o serviço
		CategoryServiceImpl categoryService = new CategoryServiceImpl();

		// Persistindo objeto no BD
		this.category = categoryService.getRepo().saveOne(this.category);

		// Fechando conexão
		categoryService.getRepo().closeEM();

		return this.category;
	}

}
