package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import model.Login;

@Repository
class DaoLoginJPA implements DaoLogin {
	
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Login> findAll() {
		return em.createQuery("select a from Login a").getResultList();
	}

	@Override
	public Login findByKey(Integer key) {
		return em.find(Login.class, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Login obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Login update(Login obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Login obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteByKey(Integer key) {
		em.remove(em.find(Login.class, key));
	}

}
