package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Personne;
import util.Context;

class DaoPersonneJPA implements DaoPersonne {

	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> findAll() {
		List<Personne> Personnes = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Personne a");
		Personnes = query.getResultList();
		
		return Personnes;
	}

	@Override
	public Personne findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Personne f = null;
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		em.find(Personne.class, key);
		tx.commit();
		em.close();
		return f;	}

	@Override
	public void insert(Personne obj) {
			EntityManager em = Context.getEntityManagerFactory().createEntityManager();
			EntityTransaction tx = null ;
			try {
				tx = em.getTransaction();
				tx.begin();
				em.persist(obj);
				tx.commit();
			} catch(Exception e) {
				if (tx != null && tx.isActive()) {
					e.printStackTrace();
					tx.rollback();
				}
			}
			em.close();
		}

	@Override
	public Personne update(Personne obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Personne Personne = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Personne = em.merge(obj);
			tx.commit();
		} catch(Exception e) {
			if (tx != null && tx.isActive()) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		em.close();
		return Personne;
	}

	@Override
	public void delete(Personne obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch(Exception e) {
			if (tx != null && tx.isActive()) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		em.close();
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Personne.class, key));
			tx.commit();
		} catch(Exception e) {
			if (tx != null && tx.isActive()) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		em.close();
	}

}
