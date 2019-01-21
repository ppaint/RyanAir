package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import model.Passager;

@Repository
class DaoPassagerJPA implements DaoPassager {
	
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Passager> findAll() {
		return em.createQuery("select a from Passager a").getResultList();
	}

	@Override
	public Passager findByKey(Integer key) {
		return em.find(Passager.class, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Passager obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Passager update(Passager obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Passager obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteByKey(Integer key) {
		em.remove(em.find(Passager.class, key));
	}

}
