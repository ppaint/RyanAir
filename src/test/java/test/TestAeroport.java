package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoAeroport;
import dao.DaoClient;
import dao.DaoCompagnieAerienne;
import dao.DaoEscale;
import dao.DaoLogin;
import dao.DaoPassager;
import dao.DaoReservation;
import dao.DaoVille;
import dao.DaoVol;
import model.Aeroport;
import model.Ville;
import model.Vol;




public class TestAeroport {
	
	private static ClassPathXmlApplicationContext ctx = null;

	private DaoAeroport daoAeroport=null;
	private DaoCompagnieAerienne daoCompagnieAerienne=null;
	private DaoVille daoVille=null;
	private DaoEscale daoEscale=null;
	
	@BeforeClass//une instruction ne s'effectue qu'une seule fois avant le 1er test-> remplace le constructeur
	public static void initClassPathXmlApplicationContext() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@AfterClass//s'effectue à la fin des tests
	public static void closeClassPathXmlApplicationContext() {
		ctx.close();
	}

	
	@Before//s'effectue avant chaque test
	public void initDao() {
		daoAeroport = ctx.getBean(DaoAeroport.class);
	}
	
	
	@org.junit.Test
	public void FindAll(){
		List<Aeroport> Aeroport=null;
		Aeroport a = new Aeroport("oo");
		Aeroport b = new Aeroport("tt");
		Aeroport.add(a);
		Aeroport.add(b);
		assertNotNull(Aeroport);
	}
	@org.junit.Test
	public void findVille() {
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		assertNotNull(a.getId());
	}
	@org.junit.Test
	public void insert () {
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		assertNotNull(a.getId());
	}
	@org.junit.Test
	public void update(){
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		a.setNom("pp");
		assertEquals("pp", a.getNom());
	}
	@org.junit.Test
	public void delete(){
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		daoAeroport.delete(a);
		assertNull(daoAeroport.findByKey(a.getId()));
	}
	@org.junit.Test
	public void deleteByKey(){
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		daoAeroport.delete(a);
		assertNull(daoAeroport.findByKey(a.getId()));
	}
	
	
	
	
	
	
	
	
	
	
	
	


}
