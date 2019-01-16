package dao;

public class DaoPersonneFactory {
	private static DaoPersonne singleton = null;
	
	public static DaoPersonne getInstance() {
		if(singleton == null) {
			singleton = new DaoPersonneJPA();
		}
		return singleton;
	}

}
