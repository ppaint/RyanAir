import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import dao.DaoClient;
import dao.DaoClientFactory;
import dao.DaoLogin;
import dao.DaoLoginFactory;
import dao.DaoReservation;
import dao.DaoReservationFactory;
import dao.DaoVol;
import dao.DaoVolFactory;
import model.Adresse;
import model.Aeroport;
import model.Client;
import model.ClientEI;
import model.Login;
import model.Reservation;
import model.TitrePhysique;
import model.Vol;
import util.Context;

public class AppPierre {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		try {
			date=sdf.parse("2000/10/10");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
//		Aeroport a = new Aeroport("Le Bel-Air");
//		Client c1 = new ClientEI("gozlan", "06xxxx", "07xxxxx", "gozlan@machin.fr", new Adresse("France", "rue du tir", "75001", "Paris"), "olivier", TitrePhysique.M);
//		Login l1 = new Login("log", "gozmdp", true);
//		c1.setLogin(l1);
//		Vol v = new Vol(date,date,date,date,a,a);
		Reservation r1 = new Reservation(date,15210);
		
		DaoClient dc1 = DaoClientFactory.getInstance();
		DaoLogin dl1 = DaoLoginFactory.getInstance();
		DaoReservation dr1 = DaoReservationFactory.getInstance();
		DaoVol dv1 = DaoVolFactory.getInstance();
		
		Client c1 = dc1.findByKey(new Long(101));
		c1.addReservation(r1);
		Long key = new Long(100);
//		dv1.insert(v);
		dr1.insert(r1);
//		dl1.insert(l1);
		c1 = dc1.update(c1);
//		dc1.insert(c1);
		System.out.println(c1);
//		dc1.delete(c1);


		
		
		Context.close();
	}

}
