package dao;

public class DaoEscaleFactory {

	private static DaoEscale singleton;
	
	public static DaoEscale getInstance() {
		if(singleton==null) {
			singleton = new DaoEscaleJpaImpl();
		}return singleton;
	}
}
