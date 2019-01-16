package dao;

public class DaoLoginFactory {
	private static DaoLogin singleton = null;
	
	public static DaoLogin getInstance() {
		if(singleton == null) {
			singleton = new DaoLoginJPA();
		}
		return singleton;
	}

}
