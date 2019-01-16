package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.ClientEI;
import model.Reservation;
import model.Vol;
import util.Context;

public class DaoVolJpaImpl implements DaoVol{

	@Override
	public List<Vol> findAll() {
		// TODO Auto-generated method stub
		List<Vol> vols = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Vol v");
		vols = query.getResultList();

		return vols;
	}

	@Override
	public Vol findByKey(Long key) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Vol v = null;
		v = em.find(Vol.class, key);
		em.close();
		return v;

	}

	@Override
	public void insert(Vol obj) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	@Override
	public Vol update(Vol obj) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Vol vol=null;
		try {
			tx = em.getTransaction();
			tx.begin();
			vol=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return vol;
	}

	@Override
	public void delete(Vol obj) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}


	@Override
	public void deleteByKey(Long key) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Vol.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}
	
	public List<Vol> findEscaleByKeyWithVol(Long key) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("select distinct v from Vol v left join fetch v.escales where v.id=:key");
		query.setParameter("key", key);
		List<Vol> v=null;

		v=query.getResultList();
		
		em.close();
		return v;
		
	}
	
	public List<Vol> findCompagnieByKeyWithVol(Long key) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("select distinct v from Vol v left join fetch v.compagniesAerienneVol where v.id=:key");
		query.setParameter("key", key);
		List<Vol> v=null;

		v=query.getResultList();
		
		em.close();
		return v;
		
	}
	
	public List<Vol> findReservationByKeyWithVol(Long key) {
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("select distinct v from Vol v left join fetch v.reservations where v.id=:key");
		query.setParameter("key", key);
		List<Vol> v=null;

		v=query.getResultList();
		
		em.close();
		return v;
		
	}
	
	
	
	public Reservation findClientEIByVol (Vol v) {
		Reservation c = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select r from Reservation r where r.id=?1");
		query.setParameter(1, v.getId());
		c = (Reservation) query.getSingleResult();
		return c;
	}
	
	
	

}
