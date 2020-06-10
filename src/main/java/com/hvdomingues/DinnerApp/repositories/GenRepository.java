package com.hvdomingues.DinnerApp.repositories;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

//Repositório genérico
public class GenRepository<T> {

	//Descobrir como fechar isso, código: ENTITY_MANAGER_FACTORY.close();
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("DinnerApp");

	//Inicialização do EntityManager
	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

	@Transactional
	public List<T> saveAll(List<T> toSave) {
		EntityTransaction et = null;

		try {
			// Objeto genérico x da lista "toSave", tipo T
			for (T x : toSave) {
				if (!em.getTransaction().isActive()) {
					et = em.getTransaction();
					et.begin();
				}

				em.persist(x);
			}
			et.commit();
		}
		// Exceção genérica, mudar depois
		catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
		return toSave;
	}
	
	@Transactional
	public T saveOne(T toSave) {
		
		EntityTransaction et = null;
		
		if (!em.getTransaction().isActive()) {
			et = em.getTransaction();
			et.begin();
		}

		em.persist(toSave);
		et.commit();
		
		return toSave;
		
	}

	@Transactional
	public List<T> getAll() {

		String query = "SELECT x FROM " + returnedClass().getName() + " x WHERE x.id IS NOT NULL";

		TypedQuery<T> tq = em.createQuery(query, returnedClass());

		List<T> itensList;

		try {
			itensList = tq.getResultList();
			return itensList;
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Transactional
	public T getByID(Integer id) {
		String query = "SELECT x FROM " + returnedClass().getName() + " x WHERE x.id = :id";

		TypedQuery<T> tq = em.createQuery(query, returnedClass());
		tq.setParameter("id", id);
		// Setando objeto genérico
		T obj = null;
		
		em.find(returnedClass(), id);
		
		try {
			obj = tq.getSingleResult();
			
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return obj;
	}

	// Update no banco de dados, metódo para alteração nos services
	@Transactional
	public T update(T objNovo) {

		EntityTransaction et = null;

		et = em.getTransaction();
		et.begin();

		em.persist(objNovo);

		et.commit();

		return objNovo;

	}

	// Fechar o EntityManager
	public void closeEM() {
		if(em != null) {
			em.close();
		}
		
	}

	// Método para retornar o tipo da classe genérica utilizando Reflection
	@SuppressWarnings("unchecked")
	private Class<T> returnedClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

}
