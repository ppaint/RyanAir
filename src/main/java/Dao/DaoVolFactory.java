package Dao;

public class DaoVolFactory {

	private static DaoVol singleton;
	
	public static DaoVol getInstance() {
		if(singleton==null) {
			singleton = new DaoVolJpaImpl;
		}return singleton;
	}
}
