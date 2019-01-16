package dao;

public class DaoReservationFactory {
	private static DaoReservation singleton = null;
	
	public static DaoReservation getInstance() {
		if(singleton == null) {
			singleton = new DaoReservationJPA();
		}
		return singleton;
	}

}
