package com.hvdomingues.DinnerApp.application;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.BillPayment;
import com.hvdomingues.DinnerApp.entities.Category;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Order;
import com.hvdomingues.DinnerApp.entities.OrderItem;
import com.hvdomingues.DinnerApp.entities.Payment;
import com.hvdomingues.DinnerApp.entities.Product;
import com.hvdomingues.DinnerApp.repositories.GenRepository;
import com.hvdomingues.DinnerApp.services.BillServiceImpl;

public class TestSystem {

	public static void main(String[] args) {

		BillServiceImpl billService = new BillServiceImpl();

		//Testando salvar contas, deu certo
		Bill bill1 = new Bill(6);
		Bill bill2 = new Bill(3);
		Bill bill3 = new Bill(7);
		Bill bill4 = new Bill(9);

		System.out.println(billService.getBillRepo().saveAll(Arrays.asList(bill1,bill2,bill3,bill4)));

		//Testando pegar todas as contas, deu certo
		List<Bill> allBill = null;

		allBill = billService.getBillRepo().getAll();

		for (Bill bill : allBill) {
			System.out.println(bill);
		}

		//Testando pegar por ID, deu certo
		Bill bill5 = billService.getBillRepo().getByID(1);
		System.out.println(bill5);
		
		//Testando update no número da mesa, deu certo
		System.out.println(billService.getBillRepo().changeTabNumber(bill1, 25));
		
		//Testando BillPayment, deu certo
		IndividualBill indBill1 = new IndividualBill(bill5, "Henrique", 2);
		IndividualBill indBill2 = new IndividualBill(bill5, "Debora", 1);

		Payment pay1 = new Payment(null, Instant.now(), 150.00);
		Payment pay2 = new Payment(null, Instant.now(), 50.00);
		
		BillPayment billPay1 = new BillPayment(pay1, indBill1);
		BillPayment billPay2 = new BillPayment(pay2, indBill1);
		
		GenRepository<IndividualBill> indBillRepository = new GenRepository<>();
		indBillRepository.saveAll(Arrays.asList(indBill1,indBill2));
		
		GenRepository<Payment> payRepository = new GenRepository<>();
		payRepository.saveAll(Arrays.asList(pay1,pay2));

		GenRepository<BillPayment> billPayRepository = new GenRepository<>();
		billPayRepository.saveAll(Arrays.asList(billPay1,billPay2));
		
		
		//Testando produtos e pedidos
		Category category1 = new Category(null, "Massas");
		
		Product product1 = new Product("Macarrão a bolonhesa", 24.99, "Macarrão feito com molho de tomate e carne moída", category1);
		Product product2 = new Product("Macarrão ao pesto", 19.99, "Macarrão com molho a base de ervas", category1);
		
		Order order1 = new Order(Instant.now(), indBill1);
		
		OrderItem orderItem1 = new OrderItem(null, 2, order1, product1);
		OrderItem orderItem2 = new OrderItem(null, 1, order1, product2);
		
		GenRepository<Category> categoryRepository = new GenRepository<>();
		GenRepository<Product> productRepository = new GenRepository<>();
		GenRepository<Order> orderRepository = new GenRepository<>();
		GenRepository<OrderItem> orderItemRepository = new GenRepository<>();
		
		categoryRepository.saveAll(Arrays.asList(category1));
		productRepository.saveAll(Arrays.asList(product1,product2));
		orderRepository.saveAll(Arrays.asList(order1));
		orderItemRepository.saveAll(Arrays.asList(orderItem1,orderItem2));
		
		
		
		
		
		categoryRepository.closeEM();
		productRepository.closeEM();
		orderRepository.closeEM();
		orderItemRepository.closeEM();
		billService.getBillRepo().closeEM();
		indBillRepository.closeEM();
		payRepository.closeEM();
		billPayRepository.closeEM();
		
		
		
		
		
		
		

	}
}