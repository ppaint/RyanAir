package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoClient;
import dao.DaoLogin;
import dao.DaoPassager;
import dao.DaoReservation;
import model.Adresse;
import model.ClientEI;
import model.Login;
import model.Passager;
import model.Reservation;
import model.TitrePhysique;

public class TestReservation {

	private static ClassPathXmlApplicationContext ctx = null;

	private DaoReservation daoReservation = null;
	private DaoClient daoClient=null;
	private DaoLogin daoLogin=null;
	private DaoPassager daoPassager=null;
	// private VilleRepository villeRepository =null;

	@BeforeClass // une instruction ne s'effectue qu'une seule fois avant le 1er test-> remplace
					// le constructeur
	public static void initClassPathXmlApplicationContext() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@AfterClass // s'effectue à la fin des tests
	public static void closeClassPathXmlApplicationContext() {
		ctx.close();
	}

	@Before // s'effectue avant chaque test
	public void initDao() {
		daoReservation = ctx.getBean(DaoReservation.class);
		daoClient = ctx.getBean(DaoClient.class);
		daoLogin = ctx.getBean(DaoLogin.class);
		daoPassager = ctx.getBean(DaoPassager.class);
		
		// villeRepository = ctx.getBean(VilleRepository.class);
	}

	@org.junit.Test
	public void FindAll() {
		Passager passager1=new Passager("tt", "yy", new Adresse());
		Passager passager2=new Passager("tt", "yy", new Adresse());
		
		Login login1=new Login("tt", "uu", true);
		Login login2=new Login("tt", "uu", true);

		ClientEI client1 = new ClientEI("ee", "rr", "tt", "uu", new Adresse(), "ii", TitrePhysique.M);

		Reservation a = new Reservation(5, client1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			a.setDate(sdf.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoPassager.insert(passager1);
		a.setPassager(passager1);

		client1.addReservation(a);

		ClientEI client2 = new ClientEI("ee", "rr", "tt", "uu", new Adresse(), "ii", TitrePhysique.M);

		Reservation b = new Reservation(5, client2);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			b.setDate(sdf2.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoPassager.insert(passager2);
		b.setPassager(passager2);

		client2.addReservation(b);
		
		client1.setLogin(login1);
		daoLogin.insert(login1);
		
		client2.setLogin(login2);
		daoLogin.insert(login2);
		

		daoClient.insert(client1);
		daoClient.insert(client2);

		daoReservation.insert(a);
		daoReservation.insert(b);
		assertNotNull(daoReservation.findAll());
		 
	}

	@org.junit.Test
	public void findReservation() {
		Passager passager1=new Passager("tt", "yy", new Adresse());
		Login login1=new Login("tt", "uu", true);

		ClientEI client1 = new ClientEI("ee", "rr", "tt", "uu", new Adresse(), "ii", TitrePhysique.M);

		Reservation a = new Reservation(5, client1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			a.setDate(sdf.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	
			daoPassager.insert(passager1);
			a.setPassager(passager1);
		

		client1.addReservation(a);
		
		client1.setLogin(login1);
		daoLogin.insert(login1);
		
		daoClient.insert(client1);
		
	
		daoReservation.insert(a);
		assertNotNull(daoReservation.findByKey(a.getId()));
	}

	@org.junit.Test
	public void insert() {
		Passager passager1=new Passager("tt", "yy", new Adresse());

		Login login1=new Login("tt", "uu", true);

		ClientEI client1 = new ClientEI("ee", "rr", "tt", "uu", new Adresse(), "ii", TitrePhysique.M);

		Reservation a = new Reservation(5, client1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			a.setDate(sdf.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoPassager.insert(passager1);
		a.setPassager(passager1);
	

		client1.addReservation(a);
		client1.setLogin(login1);
		daoLogin.insert(login1);
		
		daoClient.insert(client1);
		daoReservation.insert(a);
		assertNotNull(a.getId());
	}

	@org.junit.Test
	public void update() {
		Passager passager1=new Passager("tt", "yy", new Adresse());
		Login login1=new Login("tt", "uu", true);

		ClientEI client1 = new ClientEI("ee", "rr", "tt", "uu", new Adresse(), "ii", TitrePhysique.M);

		Reservation a = new Reservation(5, client1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			a.setDate(sdf.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoPassager.insert(passager1);
		a.setPassager(passager1);
	

		client1.addReservation(a);
		
		client1.setLogin(login1);
		daoLogin.insert(login1);

		daoClient.insert(client1);
		daoReservation.insert(a);
		
		Integer numero2 = 2;
		a.setNumero(numero2);
		a = daoReservation.update(a);
		assertEquals(numero2, a.getNumero());
	}

	@org.junit.Test
	public void delete() {
		
		Passager passager1=new Passager("tt", "yy", new Adresse());
	Login login1=new Login("tt", "uu", true);

		ClientEI client1 = new ClientEI("ee", "rr", "tt", "uu", new Adresse(), "ii", TitrePhysique.M);

		Reservation a = new Reservation(5, client1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			a.setDate(sdf.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoPassager.insert(passager1);
		a.setPassager(passager1);
	

		client1.addReservation(a);
		client1.setLogin(login1);
		daoLogin.insert(login1);

		daoClient.insert(client1);
		
		daoReservation.insert(a);
		
		daoReservation.delete(a);
		assertNull(daoReservation.findByKey(a.getId()));
	}

	@org.junit.Test
	public void deleteByKey() {
		Passager passager1=new Passager("tt", "yy", new Adresse());
		Login login1=new Login("tt", "uu", true);
		ClientEI client1 = new ClientEI("ee", "rr", "tt", "uu", new Adresse(), "ii", TitrePhysique.M);

		Reservation a = new Reservation(5, client1);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			a.setDate(sdf.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoPassager.insert(passager1);
		a.setPassager(passager1);
	
		client1.addReservation(a);
		
		client1.setLogin(login1);
		daoLogin.insert(login1);
		daoClient.insert(client1);
		daoReservation.insert(a);
		daoReservation.deleteByKey(a.getId());
		assertNull(daoReservation.findByKey(a.getId()));
	}

}
