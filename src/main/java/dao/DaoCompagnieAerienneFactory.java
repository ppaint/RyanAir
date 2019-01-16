package dao;

public class DaoCompagnieAerienneFactory {
	
private static DaoCompagnieAerienne singleton;
	
	public static DaoCompagnieAerienne getInstance() {
		if(singleton==null) {
			singleton = new DaoCompagnieAerienneJpaImpl();
		}return singleton;
	}
}

	
	


