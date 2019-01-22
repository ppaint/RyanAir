package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer>{

	
	@PersistenceContext
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Ville obj) {
		em.persist(obj);
	}
}
