package dao;

import java.util.List;

import model.ClientEI;
import model.CompagnieAerienneVol;
import model.Escale;
import model.Reservation;
import model.Vol;

public interface DaoVol extends DaoGeneric<Vol,Long>{

	public List<Vol> findEscaleByKeyWithVol(Long key);
	public List<Vol> findCompagnieByKeyWithVol(Long key);
	public List<Vol> findReservationByKeyWithVol(Long key);
	public Reservation findClientEIByVol (Vol v);
	public List<Vol> findAllVolWithEscale ();
	public Integer countEscales();
}
