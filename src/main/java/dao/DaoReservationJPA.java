package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Reservation;
import util.Context;

class DaoReservationJPA implements DaoReservation {

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findAll() {
		List<Reservation> Reservations = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Reservation a");
		Reservations = query.getResultList();
		
		return Reservations;
	}

	@Override
	public Reservation findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Reservation f = null;
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		em.find(Reservation.class, key);
		tx.commit();
		em.close();
		return f;	}

	@Override
	public void insert(Reservation obj) {
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
	public Reservation update(Reservation obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Reservation Reservation = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Reservation = em.merge(obj);
			tx.commit();
		} catch(Exception e) {
			if (tx != null && tx.isActive()) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		em.close();
		return Reservation;
	}

	@Override
	public void delete(Reservation obj) {
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
			em.remove(em.find(Reservation.class, key));
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
