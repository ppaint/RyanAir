package dao;

public class DaoAeroportFactory {

	private static DaoAeroport singleton;
	
	public static DaoAeroport getInstance() {
		if(singleton==null) {
			singleton = new DaoAeroportJpaImpl();
		}return singleton;
	}
}
