package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import model.Client;
import model.Login;
import model.Reservation;

@Repository
class DaoClientJPA implements DaoClient {

	EntityManager em = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		return em.createQuery("select a from Client a").getResultList();
	}

	@Override
	public Client findByKey(Long key) {
		return em.find(Client.class, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Client obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Client update(Client obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Client obj) {
		obj = em.merge(obj);
		if (obj.getLogin() != null) {
			Login l = em.find(Login.class, obj.getLogin().getId());
			if (l != null) {
				em.remove(l);
			}
		}
		if (obj.getReservations() != null) {
			for (int i = 0; i < obj.getReservations().size(); i++) {
				Reservation r = em.find(Reservation.class, obj.getReservations().get(i).getId());
				if (r != null) {
					em.remove(r);
				}
			}
		}
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteByKey(Long key) {
			em.remove(em.find(Client.class, key));
	}

}
