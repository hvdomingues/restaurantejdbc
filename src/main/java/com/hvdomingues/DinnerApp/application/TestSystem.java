package com.hvdomingues.DinnerApp.application;

import java.util.Arrays;

import com.hvdomingues.DinnerApp.entities.Bill;

import repositories.GenRepository;

public class TestSystem {
	
	//private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			//.createEntityManagerFactory("DinnerApp");

	public static void main(String[] args) {
		
		
		Bill bill1 = new Bill(6);
		Bill bill2 = new Bill(3);
		Bill bill3 = new Bill(7);
		Bill bill4 = new Bill(9);
		
		GenRepository<Bill> billRepository = new GenRepository<>();
		
		System.out.println(billRepository.saveAll(Arrays.asList(bill1,bill2,bill3,bill4)));
		

		
		/*Bill billteste = getBill(4);
		
		
		getBills();
		
		changeStatusBill(5, 1);
		
		changeTableNumber(1, 2);
		
		addIndividualBill(billteste, "Deu certo", 2);
		
		//Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		//Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u2);
		//Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, u1);
		
		
		
		ENTITY_MANAGER_FACTORY.close();

	}
	
	
	
	public static void addIndividualBill(Bill bill, String observation, Integer tabPosition) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			IndividualBill individualBill = new IndividualBill();
			individualBill.setBill(bill);
			individualBill.setObservation(observation);
			individualBill.setTabPosition(tabPosition);
			em.persist(individualBill);
			et.commit();
			bill.addIndividualBills(individualBill);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			if(et != null) {
				et.rollback();
			}
		}
		finally {
			em.close();
		}
	}
	
	public static void addBill(int statusBill, int tableNumber) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Bill bill = new Bill();
			bill.setStatusBill(statusBill);
			bill.setTableNumber(tableNumber);
			em.persist(bill);
			et.commit();
		}
		catch(Exception ex) {
			if(et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public static Bill getBill(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT b FROM Bill b WHERE b.id = :id";
		
		TypedQuery<Bill> tq = em.createQuery(query, Bill.class);
		tq.setParameter("id", id);
		Bill bill = null;
		try {
			bill = tq.getSingleResult();
			System.out.println(bill);
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
		return bill;
	}
	
	public static void getBills() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT b FROM Bill b WHERE b.id IS NOT NULL";
		
		
		TypedQuery<Bill> tq = em.createQuery(strQuery, Bill.class);
		List<Bill> bills;
		
		try {
			bills = tq.getResultList();
			bills.forEach(bill->System.out.println(bill.getId() + " " + bill.getStatusBill() + " " + bill.getTableNumber()));
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
		
	}
	
	public static void changeTableNumber(int id, int tableNumber) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Bill bill = null;
		
		try {
			et = em.getTransaction();
			et.begin();
			
			bill = em.find(Bill.class, id);
			bill.setTableNumber(tableNumber);
			
			em.persist(bill);
			et.commit();
		}
		catch(Exception ex) {
			if(et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public static void changeStatusBill(int id, int i) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Bill bill = null;
		
		try {
			et = em.getTransaction();
			et.begin();
			
			bill = em.find(Bill.class, id);
			bill.setStatusBill(i);
			
			em.persist(bill);
			et.commit();
		}
		catch(Exception ex) {
			if(et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	*/
	

}
}