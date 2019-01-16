package dao;

public class DaoPassagerFactory {
	private static DaoPassager singleton = null;
	
	public static DaoPassager getInstance() {
		if(singleton == null) {
			singleton = new DaoPassagerJPA();
		}
		return singleton;
	}

}
