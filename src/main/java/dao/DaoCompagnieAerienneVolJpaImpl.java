package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.CompagnieAerienneVol;
import model.CompagnieAerienneVolPk;

@Repository
public class DaoCompagnieAerienneVolJpaImpl implements DaoCompagnieAerienneVol {
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<CompagnieAerienneVol> findAll() {
		 return em.createQuery("from CompagnieAerienneVol c").getResultList();
	}

	@Override
	public CompagnieAerienneVol findByKey(CompagnieAerienneVolPk key) {
		return em.find(CompagnieAerienneVol.class, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(CompagnieAerienneVol obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(CompagnieAerienneVol obj) {
		em.remove(em.merge(obj));
	}


	@Override
	public void deleteByKey(CompagnieAerienneVolPk key) {
		em.remove(em.find(CompagnieAerienneVol.class, key));
	}
}