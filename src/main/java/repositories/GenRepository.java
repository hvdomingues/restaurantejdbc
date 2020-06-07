package repositories;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

//Teste de repositório genérico
public class GenRepository<T> {

	// Descobrir onde fechar, código: ENTITY_MANAGER_FACTORY.close();
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("DinnerApp");

	// Teste @Transactional
	EntityManager em2 = ENTITY_MANAGER_FACTORY.createEntityManager();

	public String saveAll(List<T> toSave) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
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
		} finally {
			em.close();

		}
		return "Deu certo";
	}

	public List<T> getAll() {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT x FROM " + returnedClass().getName() + " x WHERE x.id IS NOT NULL";

		TypedQuery<T> tq = em.createQuery(query, returnedClass());

		List<T> itensList;

		try {
			itensList = tq.getResultList();
			return itensList;
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	public T getByIDOriginal(Integer id) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT x FROM " + returnedClass().getName() + " x WHERE x.id = :id";

		TypedQuery<T> tq = em.createQuery(query, returnedClass());
		tq.setParameter("id", id);
		// Setando objeto genérico
		T obj = null;

		try {
			obj = tq.getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return obj;
	}

	// Testando anotação para o update
	public T getByID(Integer id) {
		String query = "SELECT x FROM " + returnedClass().getName() + " x WHERE x.id = :id";

		TypedQuery<T> tq = em2.createQuery(query, returnedClass());
		tq.setParameter("id", id);
		// Setando objeto genérico
		T obj = null;

		try {
			obj = tq.getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			// em2.close();
		}
		return obj;
	}
	
	public void closeEM() {
		em2.close();
	}

	// Update no banco de dados, metódo para alteração nos services
	@Transactional
	public T update(T objNovo) {

		EntityTransaction et = null;
		
		et = em2.getTransaction();
		et.begin();

		em2.persist(objNovo);
		
		et.commit();

		return objNovo;

	}

	// Método para retornar o tipo da classe genérica utilizando Reflection
	@SuppressWarnings("unchecked")
	private Class<T> returnedClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

}
