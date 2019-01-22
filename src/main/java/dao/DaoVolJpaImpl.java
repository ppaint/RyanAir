package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Reservation;
import model.Vol;

@Repository
public class DaoVolJpaImpl implements DaoVol{
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Vol> findAll() {
		return em.createQuery("from Vol v").getResultList();
	}

	@Override
	public Vol findByKey(Long key) {
		return em.find(Vol.class, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Vol obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Vol update(Vol obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Vol obj) {
		em.remove(em.merge(obj));
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteByKey(Long key) {
		em.remove(em.find(Vol.class, key));
	}
	
	@SuppressWarnings("unchecked")
	public List<Vol> findEscaleByKeyWithVol(Long key) {
		Query query=em.createQuery("select distinct v from Vol v left join fetch v.escales where v.id=:key");
		query.setParameter("key", key);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vol> findCompagnieByKeyWithVol(Long key) {
		Query query=em.createQuery("select distinct v from Vol v left join fetch v.compagniesAerienneVol where v.id=:key");
		query.setParameter("key", key);
		return query.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List<Vol> findReservationByKeyWithVol(Long key) {
		Query query=em.createQuery("select distinct v from Vol v left join fetch v.reservations where v.id=:key");
		query.setParameter("key", key);
		return query.getResultList();
	}
		
	public Reservation findClientEIByVol (Vol v) {
		Query query = em.createQuery("select r from Reservation r where r.id=?1");
		query.setParameter(1, v.getId());
		return (Reservation) query.getSingleResult();
	}
	
}
