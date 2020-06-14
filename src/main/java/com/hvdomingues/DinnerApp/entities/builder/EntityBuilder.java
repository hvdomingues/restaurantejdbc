package com.hvdomingues.DinnerApp.entities.builder;

import java.time.Instant;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.Category;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Order;
import com.hvdomingues.DinnerApp.entities.OrderItem;
import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.entities.Product;
import com.hvdomingues.DinnerApp.services.BillServiceImpl;
import com.hvdomingues.DinnerApp.services.CategoryServiceImpl;
import com.hvdomingues.DinnerApp.services.IndividualBillServiceImpl;
import com.hvdomingues.DinnerApp.services.OrderItemServiceImpl;
import com.hvdomingues.DinnerApp.services.OrderServiceImpl;
import com.hvdomingues.DinnerApp.services.PaymentServiceImpl;
import com.hvdomingues.DinnerApp.services.ProductServiceImpl;


//Utilizado o site "https://refactoring.guru/pt-br/design-patterns/builder" para referências.
//Como o BillPayment será criado automaticamente, não teremos um método aqui
public class EntityBuilder {

	private Bill bill;
	private IndividualBill individualBill;
	private Order order;
	private OrderItem orderItem;
	private Payment payment;
	private Product product;
	private Category category;

	public Bill createBill(Integer tableNumber) {

		// Instanciando o novo objeto
		this.bill = new Bill();

		// Settando valores do objeto
		this.bill.setTableNumber(tableNumber);
		

		// Instanciando o serviço
		BillServiceImpl billService = new BillServiceImpl();

		// Persistindo objeto no BD
		this.bill = billService.saveOne(this.bill);

		// Fechando conexão
		billService.closeService();;

		return this.bill;

	}

	public IndividualBill createIndividualBill(Bill bill, String observation, Integer tabPosition) {

		// Instanciando o novo objeto
		this.individualBill = new IndividualBill();

		// Settando valores do objeto
		this.individualBill.setBill(bill);
		this.individualBill.setObservation(observation);
		this.individualBill.setTabPosition(tabPosition);

		// Instanciando o serviço
		IndividualBillServiceImpl individualBillService = new IndividualBillServiceImpl();

		// Persistindo objeto no BD
		this.individualBill = individualBillService.saveOne(this.individualBill);

		// Fechando conexão
		individualBillService.closeService();

		return this.individualBill;
	}


	public Order createOrder(Instant moment, IndividualBill individualBill) {
		// Instanciando o novo objeto
		this.order = new Order();

		// Settando valores do objeto
		this.order.setIndBill(individualBill);
		this.order.setMoment(moment);

		// Instanciando o serviço
		OrderServiceImpl orderService = new OrderServiceImpl();

		// Persistindo objeto no BD
		this.order = orderService.saveOne(this.order);

		// Fechando conexão
		orderService.closeService();

		return this.order;
	}

	public OrderItem createOrderItem(Integer quantity, Order order, Product product) {
		// Instanciando o novo objeto
		this.orderItem = new OrderItem();

		// Settando valores do objeto
		this.orderItem.setOrder(order);
		this.orderItem.setProduct(product);
		this.orderItem.setQuantity(quantity);
		this.orderItem.setItemPrice();

		// Instanciando o serviço
		OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();

		// Persistindo objeto no BD
		this.orderItem = orderItemService.saveOne(this.orderItem);

		// Fechando conexão
		orderItemService.closeService();

		return this.orderItem;
	}

	public Payment createPayment(Instant moment, Double paymentValue) {
		// Instanciando o novo objeto
		this.payment = new Payment();

		// Settando valores do objeto
		this.payment.setPayMoment(moment);
		this.payment.setPayValue(paymentValue);

		// Instanciando o serviço
		PaymentServiceImpl paymentService = new PaymentServiceImpl();

		// Persistindo objeto no BD
		this.payment = paymentService.saveOne(this.payment);

		// Fechando conexão
		paymentService.closeService();

		return this.payment;
	}

	public Product createProduct(String productName, Double price, String desc, Category category) {
		// Instanciando o novo objeto
		this.product = new Product();

		// Settando valores do objeto
		this.product.setCategory(category);
		this.product.setDescription(desc);
		this.product.setName(productName);
		this.product.setPrice(price);

		// Instanciando o serviço
		ProductServiceImpl productService = new ProductServiceImpl();

		// Persistindo objeto no BD
		this.product = productService.saveOne(this.product);

		// Fechando conexão
		productService.closeService();

		return this.product;
	}

	public Category createCategory(String categoryName) {
		// Instanciando o novo objeto
		this.category = new Category();

		// Settando valores do objeto
		this.category.setName(categoryName);;

		// Instanciando o serviço
		CategoryServiceImpl categoryService = new CategoryServiceImpl();

		// Persistindo objeto no BD
		this.category = categoryService.saveOne(this.category);

		// Fechando conexão
		categoryService.closeService();

		return this.category;
	}

}
