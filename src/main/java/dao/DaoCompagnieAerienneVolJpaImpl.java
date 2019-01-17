package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formationJpa.model.Ordinateur;
import model.CompagnieAerienneVol;
import model.CompagnieAerienneVolPk;
import util.Context;

public class DaoCompagnieAerienneVolJpaImpl implements DaoCompagnieAerienneVol {

	@Override
	public List<CompagnieAerienneVol> findAll() {
		// TODO Auto-generated method stub

		List<CompagnieAerienneVol> compagniesAerienneVol = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from CompagnieAerienneVol c");
		compagniesAerienneVol = query.getResultList();

		return compagniesAerienneVol;
	}

	@Override
	public CompagnieAerienneVol findByKey(CompagnieAerienneVolPk key) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		CompagnieAerienneVol c = null;
		c = em.find(CompagnieAerienneVol.class, key);
		em.close();
		return c;

	}

	@Override
	public void insert(CompagnieAerienneVol obj) {
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
	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		CompagnieAerienneVol compagnieAerienneVol = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			compagnieAerienneVol = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return compagnieAerienneVol;
	}

	@Override
	public void delete(CompagnieAerienneVol obj) {
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
	public void deleteByKey(CompagnieAerienneVolPk key) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(CompagnieAerienneVol.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

}
