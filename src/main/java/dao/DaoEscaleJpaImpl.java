package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Aeroport;
import model.Escale;
import util.Context;

public class DaoEscaleJpaImpl implements DaoEscale {

	@Override
	public List<Escale> findAll() {
		List<Escale> escales = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Aeroport a");
		escales = query.getResultList();
		em.close();
		return escales;
	}

	@Override
	public Escale findByKey(Integer key) {
		EntityManager em =Context.getEntityManagerFactory().createEntityManager();
		Escale p =null;
		p=em.find(Escale.class, key);
		em.close();
		return p;
	}

	@Override
	public void insert(Escale obj) {
		Escale escale = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx=em.getTransaction();
			tx.begin();
			em.persist(obj);;
			tx.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Escale update(Escale obj) {
		Escale escale = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx=em.getTransaction();
			tx.begin();
			em.merge(obj);;
			tx.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		em.close();		
	return escale;
	}

	@Override
	public void delete(Escale obj) {
		EntityManager em =Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		try {
			tx=em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		}catch (Exception e ) {
			e.printStackTrace();
			if (tx!=null && tx.isActive()) {
				tx.rollback();
			}
		}em.close();
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em =Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		try {
			tx=em.getTransaction();
			tx.begin();
			em.remove(em.find(Escale.class, key));
			tx.commit();
		}catch (Exception e ) {
			e.printStackTrace();
			if (tx!=null && tx.isActive()) {
				tx.rollback();
			}
		}em.close();
		
	}

}
