package dao;

import java.util.List;

import model.Aeroport;
import model.Ville;
import model.Vol;

public interface DaoAeroport extends DaoGeneric<Aeroport, Long>{

	public List<Aeroport> findAeroportsByVolArrive(Vol v);
	public List<Ville> findVille(Aeroport v);
}
