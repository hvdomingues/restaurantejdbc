package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


//Teste de repositório genérico
public class GenRepository<T>{

	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("DinnerApp");

	
	public String saveAll(List<T> toSave) {
		
			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction et = null;
			
			try {
				//Objeto genérico x da lista "toSave", tipo T
				for(T x: toSave) {
					if(!em.getTransaction().isActive()) {
						et = em.getTransaction();
						et.begin();
					}

					em.persist(x);
				}
				et.commit();
			}
			//Exceção genérica, mudar depois
			catch(Exception ex) {
				if(et != null) {
					et.rollback();
				}
				ex.printStackTrace();
			}
			finally {
				em.close();
				ENTITY_MANAGER_FACTORY.close();
			}
			return "Deu certo";
	}
	
}

