package com.hvdomingues.DinnerApp.application;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.BillPayment;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Payment;

import repositories.GenRepository;
import services.BillServiceImpl;

public class TestSystem {

	public static void main(String[] args) {

		BillServiceImpl billService = new BillServiceImpl();

		//Testando salvar contas, deu certo
		Bill bill1 = new Bill(6);
		Bill bill2 = new Bill(3);
		Bill bill3 = new Bill(7);
		Bill bill4 = new Bill(9);

		System.out.println(billService.saveAll(Arrays.asList(bill1,bill2,bill3,bill4)));

		//Testando pegar todas as contas, deu certo
		List<Bill> allBill = null;

		allBill = billService.getAll();

		for (Bill bill : allBill) {
			System.out.println(bill);
		}

		//Testando pegar por ID, deu certo
		Bill bill5 = billService.getByID(1);
		System.out.println(bill5);
		
		//Testando update no número da mesa, deu certo
		System.out.println(billService.changeTabNumber(2, 25));
		
		//Testando BillPayment
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
		
		
		billService.closeEM();
		indBillRepository.closeEM();
		payRepository.closeEM();
		billPayRepository.closeEM();
		
		
		
		
		
		
		

	}
}