package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Client;
import model.Login;
import model.Reservation;
import util.Context;

class DaoClientJPA implements DaoClient {

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		List<Client> Clients = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Client a");
		Clients = query.getResultList();
		
		return Clients;
	}

	@Override
	public Client findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Client f = null;
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		f = em.find(Client.class, key);
		tx.commit();
		em.close();
		return f;	}

	@Override
	public void insert(Client obj) {
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
	public Client update(Client obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Client client = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			client = em.merge(obj);
			tx.commit();
		} catch(Exception e) {
			if (tx != null && tx.isActive()) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		em.close();
		return client;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			if(obj.getLogin() != null) {
				Login l = em.find(Login.class, obj.getLogin().getId());
				if (l != null) {
					em.remove(l);
				}
			}
			if(obj.getReservations()!= null) {
				for(int i=0; i<obj.getReservations().size(); i++) {
			
					Reservation r = em.find(Reservation.class, obj.getReservations().get(i).getId());
					if (r != null) {
						em.remove(r);
					}
				}
			}
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
	public void deleteByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Client.class, key));
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
