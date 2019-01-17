package dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.CompagnieAerienne;
import model.CompagnieAerienneVol;
import model.CompagnieAerienneVolPk;
import model.Vol;
import util.Context;

public class DaoCompagnieAerienneJpaImpl implements DaoCompagnieAerienne {

	@Override
	public List<CompagnieAerienne> findAll() {
		// TODO Auto-generated method stub
		List<CompagnieAerienne> adherents = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from CompagnieAerienne c");
		adherents = query.getResultList();

		return adherents;
	}

	@Override
	public CompagnieAerienne findByKey(Long key) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		CompagnieAerienne a = null;
		a = em.find(CompagnieAerienne.class, key);
		em.close();
		return a;

	}

	@Override
	public void insert(CompagnieAerienne obj) {
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
	public CompagnieAerienne update(CompagnieAerienne obj) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		CompagnieAerienne compagnieAerienne = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			compagnieAerienne = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return compagnieAerienne;
	}

	@Override
	public void delete(CompagnieAerienne obj) {
		// TODO Auto-generated method stub

		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("delete from CompagnieAerienneVol c where c.key.compagnieAerienne=:key");
		query.setParameter("key", obj);
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em2.getTransaction();
			tx.begin();
			em2.remove(em2.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em2.close();
	}

	/*
	 * EntityManager em = Context.getEntityManagerFactory().createEntityManager();
	 * EntityTransaction tx = null; CompagnieAerienne compagnieAerienne = null;
	 * //CompagnieAerienneVol compagnieAerienneVol =null; if
	 * (obj.getId()==CompagnieAerienneVolPk this. class, obj.getId())!=null) {
	 * DaoCompagnieAerienneVol DaoCompagnieAerienneVol =
	 * DaoCompagnieAerienneVolFactory.getInstance(); Set<CompagnieAerienneVol> toto
	 * = (Set<CompagnieAerienneVol>) em.find(CompagnieAerienneVol.class,
	 * obj.getId()); for (CompagnieAerienneVol c : toto) {
	 * DaoCompagnieAerienneVol.delete(c); } }
	 */

	@Override
	public void deleteByKey(Long key) {
		// TODO Auto-generated method stub
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(CompagnieAerienne.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public List<CompagnieAerienne> findCompagnieAerienneVolByKeyWithCompagnie(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery(
				"select distinct c from CompagnieAerienne c left join fetch c.compagniesAerienneVol where c.id=:key");
		query.setParameter("key", key);
		List<CompagnieAerienne> c = null;

		c = query.getResultList();

		em.close();
		return c;

	}

}
