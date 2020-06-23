package com.hvdomingues.DinnerApp.entities.builder;

import java.time.Instant;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.Category;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Order;
import com.hvdomingues.DinnerApp.entities.OrderItem;
import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.entities.Product;
import com.hvdomingues.DinnerApp.entities.exceptions.MyException;
import com.hvdomingues.DinnerApp.services.factories.ServiceFactory;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillPaymentService;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.ICategoryService;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IIndividualBillService;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderItemService;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderService;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IPaymentService;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IProductService;

//Utilizado o site "https://refactoring.guru/pt-br/design-patterns/builder" para referências.
public class EntityBuilder {

	private Bill bill;
	private IndividualBill individualBill;
	private Order order;
	private OrderItem orderItem;
	private Payment payment;
	private Product product;
	private Category category;
	private ServiceFactory serviceFactory = new ServiceFactory();

	public Bill createBill(Integer tableNumber) {

		// Instanciando o novo objeto
		this.bill = new Bill();

		// Settando valores do objeto
		this.bill.setTableNumber(tableNumber);

		// Instanciando o serviço
		IBillService billService = serviceFactory.createBillService();

		// Persistindo objeto no BD
		this.bill = billService.saveOne(this.bill);

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
		IIndividualBillService individualBillService = serviceFactory.createIndBillService();

		// Persistindo objeto no BD
		this.individualBill = individualBillService.saveOne(this.individualBill);

		return this.individualBill;
	}

	public Order createOrder(Instant moment, IndividualBill individualBill) {
		// Instanciando o novo objeto
		this.order = new Order();

		// Settando valores do objeto
		this.order.setIndBill(individualBill);
		this.order.setMoment(moment);

		// Instanciando o serviço
		IOrderService orderService = serviceFactory.createOrderService();

		// Persistindo objeto no BD
		this.order = orderService.saveOne(this.order);

		return this.order;
	}

	public OrderItem createOrderItem(Integer quantity, String observation, Order order, Product product) {
		// Instanciando o novo objeto
		this.orderItem = new OrderItem();

		// Settando valores do objeto
		this.orderItem.setOrder(order);
		this.orderItem.setProduct(product);
		this.orderItem.setObservation(observation);
		this.orderItem.setItemPrice();

		// Instanciando o serviço
		IOrderItemService orderItemService = serviceFactory.createOrderItemService();

		// Persistindo objeto no BD
		this.orderItem = orderItemService.saveOne(this.orderItem);

		return this.orderItem;
	}

	public Payment createPayment(Double paymentValue, IndividualBill indBill) {
		// Instanciando o novo objeto
		this.payment = new Payment();

		// Settando valores do objeto
		this.payment.setPayMoment(Instant.now());
		this.payment.setPayValue(paymentValue);

		// Instanciando o serviço
		IPaymentService paymentService = serviceFactory.createPaymentService();
		IBillPaymentService billPaymentService = serviceFactory.createBillPaymentService();

		// Persistindo objeto no BD
		try {
			if (this.individualBill == null) {
				this.payment = null;
				throw new MyException("Um pagamento deve ter ao menos uma conta individual associada a ele");
			} else {
				this.payment = paymentService.saveOne(this.payment);
				billPaymentService.saveOne(payment, indBill);
			}
		} catch (MyException e) {
			System.out.println(e.getMessage());
			return this.payment;
		} 

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
		IProductService productService = serviceFactory.createProductService();

		// Persistindo objeto no BD
		this.product = productService.saveOne(this.product);

		return this.product;
	}

	public Category createCategory(String categoryName) {
		// Instanciando o novo objeto
		this.category = new Category();

		// Settando valores do objeto
		this.category.setName(categoryName);

		// Instanciando o serviço
		ICategoryService categoryService = serviceFactory.createCategoryService();

		// Persistindo objeto no BD
		this.category = categoryService.saveOne(this.category);

		return this.category;
	}

}
