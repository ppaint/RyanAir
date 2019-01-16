package dao;

import java.util.List;

import model.CompagnieAerienneVol;
import model.Escale;
import model.Reservation;
import model.Vol;

public interface DaoVol extends DaoGeneric<Vol,Long>{

	public List<Vol> findEscaleByKeyWithVol(Long key);
	public List<Vol> findCompagnieByKeyWithVol(Long key);
	public List<Vol> findReservationByKeyWithVol(Long key);
}
