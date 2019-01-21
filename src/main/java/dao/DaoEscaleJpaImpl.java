package dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Escale;

@Repository
public class DaoEscaleJpaImpl implements DaoEscale {
	
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Escale> findAll() {
		return em.createQuery("from Aeroport a").getResultList();
	}

	@Override
	public Escale findByKey(Integer key) {
		return em.find(Escale.class, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Escale obj) {
		em.persist(obj);
	}

	@Override
	public Escale update(Escale obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Escale obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void deleteByKey(Integer key) {
		em.remove(em.find(Escale.class, key));		
	}

}
