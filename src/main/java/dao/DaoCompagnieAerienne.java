package dao;

import java.util.List;

import model.CompagnieAerienne;

public interface DaoCompagnieAerienne extends DaoGeneric <CompagnieAerienne, Long> {
	public List<CompagnieAerienne> findCompagnieAerienneVolByKeyWithCompagnie(Long key);

}
