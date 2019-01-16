package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Passager;
import util.Context;

class DaoPassagerJPA implements DaoPassager {

	@SuppressWarnings("unchecked")
	@Override
	public List<Passager> findAll() {
		List<Passager> Passagers = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Passager a");
		Passagers = query.getResultList();
		
		return Passagers;
	}

	@Override
	public Passager findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Passager f = null;
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		em.find(Passager.class, key);
		tx.commit();
		em.close();
		return f;	}

	@Override
	public void insert(Passager obj) {
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
	public Passager update(Passager obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Passager Passager = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Passager = em.merge(obj);
			tx.commit();
		} catch(Exception e) {
			if (tx != null && tx.isActive()) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		em.close();
		return Passager;
	}

	@Override
	public void delete(Passager obj) {
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
			em.remove(em.find(Passager.class, key));
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
