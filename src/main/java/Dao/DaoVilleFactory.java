package Dao;

public class DaoVilleFactory {

	private static DaoVille singleton;
	
	public static DaoVille getInstance() {
		if(singleton==null) {
			singleton = new DaoVilleJpaImpl;
		}return singleton;
	}
}
