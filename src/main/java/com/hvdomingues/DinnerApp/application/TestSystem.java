package com.hvdomingues.DinnerApp.application;

import java.util.Arrays;
import java.util.List;

import com.hvdomingues.DinnerApp.entities.Bill;

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
		
		//Testando update no número da mesa
		System.out.println(billService.changeTabNumber(2, 25));
		
		billService.closeEM();
		
		
		
		
		
		
		

	}
}