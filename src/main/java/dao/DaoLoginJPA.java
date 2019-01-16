package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Login;
import util.Context;

class DaoLoginJPA implements DaoLogin {

	@SuppressWarnings("unchecked")
	@Override
	public List<Login> findAll() {
		List<Login> Logins = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Login a");
		Logins = query.getResultList();
		
		return Logins;
	}

	@Override
	public Login findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Login f = null;
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		em.find(Login.class, key);
		tx.commit();
		em.close();
		return f;	}

	@Override
	public void insert(Login obj) {
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
	public Login update(Login obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Login Login = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Login = em.merge(obj);
			tx.commit();
		} catch(Exception e) {
			if (tx != null && tx.isActive()) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		em.close();
		return Login;
	}

	@Override
	public void delete(Login obj) {
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
			em.remove(em.find(Login.class, key));
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
