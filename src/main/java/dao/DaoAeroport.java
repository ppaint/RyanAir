package dao;

import java.util.List;

import model.Aeroport;
import model.Vol;
import model.Aeroport;

public interface DaoAeroport extends DaoGeneric<Aeroport, Long>{

	public List<Aeroport> findAeroportsByVolArrive(Vol v);
}
