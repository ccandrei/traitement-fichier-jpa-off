package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entites.Produits;

public class ProduitsDAO {

	private EntityManagerFactory emf;

	public ProduitsDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void insert(Produits produit) {
	EntityManager em = this.emf.createEntityManager();
	em.getTransaction().begin();
	em.persist(produit);
	em.getTransaction().commit();
	
	em.close();
	
	
	
	}
}
