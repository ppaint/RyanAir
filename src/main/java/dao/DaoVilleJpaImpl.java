package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Ville;

@Repository
class DaoVilleJpaImpl implements DaoVille{
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ville> findAll() {
		return em.createQuery("from Aeroport a").getResultList();
	}
	

	@Override
	public Ville findByKey(Long key) {
		return em.find(Ville.class, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Ville obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Ville update(Ville obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Ville obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteByKey(Long key) {
		em.remove(em.find(Ville.class, key));
		
	}

}
