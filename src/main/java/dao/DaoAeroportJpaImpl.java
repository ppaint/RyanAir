package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Aeroport;
import util.Context;

public class DaoAeroportJpaImpl implements  DaoAeroport{

	@Override
	public List<Aeroport> findAll() {
		List<Aeroport> aeroports = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Aeroport a");
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

	@Override
	public Aeroport findByKey(Integer key) {
		EntityManager em =Context.getEntityManagerFactory().createEntityManager();
		Aeroport p =null;
		p=em.find(Aeroport.class, key);
		em.close();
		return p;
	}

	@Override
	public void insert(Aeroport obj) {
		Aeroport aeroport = null;
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
	public Aeroport update(Aeroport obj) {
		Aeroport aeroport = null;
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
	return aeroport;
	}

	@Override
	public void delete(Aeroport obj) {
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
			em.remove(em.find(Aeroport.class, key));
			tx.commit();
		}catch (Exception e ) {
			e.printStackTrace();
			if (tx!=null && tx.isActive()) {
				tx.rollback();
			}
		}em.close();
		
	}

}
