package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Aeroport;
import model.Ville;
import model.Vol;

@Repository
class DaoAeroportJpaImpl implements  DaoAeroport{
	
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Aeroport> findAll() {
		return em.createQuery("from Aeroport a").getResultList();
	}

	@Override
	public Aeroport findByKey(Long key) {
		return em.find(Aeroport.class, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Aeroport obj) {
		em.persist(obj);		
	}

	@Override	
	@Transactional(propagation = Propagation.REQUIRED)
	public Aeroport update(Aeroport obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Aeroport obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public void deleteByKey(Long key) {
		em.remove(em.find(Aeroport.class, key));
		
	}

	@SuppressWarnings("unchecked")
	public List<Aeroport> findAeroportsByVolArrive(Vol v) {
		List<Aeroport> aeroports = null;
		Query query = em.createQuery("from Aeroport a lef join fetch a.volsArrivee v where v.id=?1 ");
		query.setParameter(1, v.getId());
		aeroports = query.getResultList();
		return aeroports;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ville> findVille(Aeroport a) {
		List<Ville> villes = null;
		Query query = em.createQuery("select v from Ville v join Aeroport a where a.id=?1 ");
		query.setParameter(1, a.getId());
		villes = query.getResultList();
		return villes;
	}
}
