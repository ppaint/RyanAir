import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.DaoAeroport;
import dao.DaoAeroportFactory;
import dao.DaoClient;
import dao.DaoClientFactory;
import dao.DaoReservation;
import dao.DaoReservationFactory;
import dao.DaoVille;
import dao.DaoVilleFactory;
import dao.DaoVol;
import dao.DaoVolFactory;
import model.Adresse;
import model.Aeroport;
import model.ClientEI;
import model.Reservation;
import model.TitrePhysique;
import model.Ville;
import model.Vol;
import util.Context;

public class MainAurelien2 {

	public static void main(String[] args) {
		DaoVille DaoVille = DaoVilleFactory.getInstance();
		Ville v = new Ville("Marseille");
		DaoAeroport daoAeroport = DaoAeroportFactory.getInstance();
		Aeroport a = new Aeroport("Le Bel-Air");
		Aeroport b = new Aeroport("Le Bel-Air");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date q = new Date();
		Date q1=new Date();
		Date q2=new Date();
		Date q3=new Date();
		try {
			q = sdf.parse("01/02/1990");
			q1 = sdf.parse("02/02/1990");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		
	
		try {
			q2 = sdf2.parse("09:00");
			q3 = sdf2.parse("16:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DaoVol DaoVol = DaoVolFactory.getInstance();
		
		Vol vo = new Vol(q2, q3, q1, q, b, a);
		
		
		v.addAeroport(a);
		v.addAeroport(b);	
		daoAeroport.insert(a);
		daoAeroport.insert(b);
//		System.out.println("--------------------vol--------------------");
		DaoVol.insert(vo);
		DaoVille.insert(v);
		
//		System.out.println(daoAeroport.findAeroportsByVolArrive(vo));
//		
//		
		ClientEI ei = new ClientEI("desplas", "desplas", "desplas", "desplas", new Adresse( "desplas", "desplas", "desplas", "desplas"), "desplas", TitrePhysique.M);
		DaoClient DaoClient = DaoClientFactory.getInstance();
		DaoClient.insert(ei);
		
//		Reservation r = new Reservation(q, 5, vo);
//		DaoReservation daoReservation = DaoReservationFactory.getInstance();
//		
//		daoReservation.insert(r);
		System.out.println("--------------------vol--------------------");
		System.out.println(daoAeroport.findVille(a));
		
		
		Context.close();
		
		

		
		
	
		
//		v.setNom("Paris");
//		a.setNom("LLLLLL");
//		v= DaoVille.update(v);
//		a= daoAeroport.update(a);
		
		
//		DaoVille.delete(v);
//		daoAeroport.delete(a);
		
		
	
		


	}

}
