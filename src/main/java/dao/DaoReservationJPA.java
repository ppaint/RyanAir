package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Reservation;

@Repository
class DaoReservationJPA implements DaoReservation {
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findAll() {
		return em.createQuery("select a from Reservation a").getResultList();
	}

	@Override
	public Reservation findByKey(Integer key) {
		return em.find(Reservation.class, key);
		}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Reservation obj) {
		em.persist(obj);
	}

	@Override
	public Reservation update(Reservation obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Reservation obj) {
			em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteByKey(Integer key) {
			em.remove(em.find(Reservation.class, key));
	}

}
