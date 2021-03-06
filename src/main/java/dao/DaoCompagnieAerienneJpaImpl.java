package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Aeroport;
import model.CompagnieAerienne;

@Repository
@Transactional
public class DaoCompagnieAerienneJpaImpl implements DaoCompagnieAerienne {
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<CompagnieAerienne> findAll() {
		return em.createQuery("from CompagnieAerienne c").getResultList();
	}

	@Override
	public CompagnieAerienne findByKey(Long key) {
		return em.find(CompagnieAerienne.class, key);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(CompagnieAerienne obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CompagnieAerienne update(CompagnieAerienne obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(CompagnieAerienne obj) {
		em.remove(em.merge(obj));
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
		em.remove(em.find(CompagnieAerienne.class, key));
	}

	@SuppressWarnings("unchecked")
	public List<CompagnieAerienne> findCompagnieAerienneVolByKeyWithCompagnie(Long key) {
		Query query = em.createQuery(
				"select distinct c from CompagnieAerienne c left join fetch c.compagniesAerienneVol where c.id=:key");
		query.setParameter("key", key);
		return query.getResultList();

	}

}
