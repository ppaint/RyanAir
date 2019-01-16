
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.DaoClient;
import dao.DaoClientFactory;
import dao.DaoLogin;
import dao.DaoLoginFactory;
import model.Adresse;
import model.Client;
import model.ClientEI;
import model.Login;
import model.TitrePhysique;
import util.Context;

public class Apptest {

	public static void main(String[] args) {
//		
//		DaoClient d1 = DaoClientFactory.getInstance();
//		DaoLogin d2 = DaoLoginFactory.getInstance();
//		Client c1 = new ClientEI("gozlan", "06xxxx", "05xxxxx", "gozlan@machin.fr", new Adresse("France", "rue du marbre", "75001", "Paris"), "olivier", TitrePhysique.M);
//		d1.insert(c1);
//		Login l1 = new Login("goz", "gozmdp", true);
//		c1.setLogin(l1);
//		
//		d2.insert(l1);
//		c1 = d1.update(c1);
//		
		Context.close();
		
		String pattern = "HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		try {
			Date date = simpleDateFormat.parse("09:00");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
 
}
 