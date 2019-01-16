package dao;

public class DaoClientFactory {
	private static DaoClient singleton = null;
	
	public static DaoClient getInstance() {
		if(singleton == null) {
			singleton = new DaoClientJPA();
		}
		return singleton;
	}

}
