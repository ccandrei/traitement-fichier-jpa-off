package applicationstart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open-food-facts-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}
	

	}


