package dao;

public class DaoCompagnieAerienneVolFactory {

	private static DaoCompagnieAerienneVol singleton;
	
	public static DaoCompagnieAerienneVol getInstance() {
		if(singleton==null) {
			singleton = new DaoCompagnieAerienneVolJpaImpl();
		}return singleton;
	}
}

	
