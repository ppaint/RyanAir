package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import model.Ville;
import util.Context;

class DaoVilleJpaImpl implements DaoVille{

	@Override
	public List<Ville> findAll() {
		List<Ville> villes = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Aeroport a");
		villes = query.getResultList();
		em.close();
		return villes;
	}
	

	@Override
	public Ville findByKey(Long key) {
		EntityManager em =Context.getEntityManagerFactory().createEntityManager();
		Ville p =null;
		p=em.find(Ville.class, key);
		em.close();
		return p;
	}

	@Override
	public void insert(Ville obj) {
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
	public Ville update(Ville obj) {
		Ville ville = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx=em.getTransaction();
			tx.begin();
			ville = em.merge(obj);;
			tx.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		em.close();		
	return ville;
	}

	@Override
	public void delete(Ville obj) {
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
	public void deleteByKey(Long key) {
		EntityManager em =Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		try {
			tx=em.getTransaction();
			tx.begin();
			em.remove(em.find(Ville.class, key));
			tx.commit();
		}catch (Exception e ) {
			e.printStackTrace();
			if (tx!=null && tx.isActive()) {
				tx.rollback();
			}
		}em.close();
		
	}

}
