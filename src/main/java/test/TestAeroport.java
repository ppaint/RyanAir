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
import model.Vol;




class TestAeroport {
	
	private static ClassPathXmlApplicationContext ctx = null;

	private DaoAeroport daoAeroport=null;
	private DaoCompagnieAerienne daoCompagnieAerienne=null;
	private DaoVille daoVille=null;
	private DaoEscale daoEscale=null;
	
	@BeforeClass//une instruction ne s'effectue qu'une seule fois avant le 1er test-> remplace le constructeur
	public static void initClassPathXmlApplicationContext() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@AfterClass//s'effectue � la fin des tests
	public static void closeClassPathXmlApplicationContext() {
		ctx.close();
	}

	
	@Before//s'effectue avant chaque test
	public void initDao() {
		daoAeroport = ctx.getBean(DaoAeroport.class);
	}
	
	
	@org.junit.Test
	public List<Aeroport> FindAll(Aeroport a){
		fail("fail");
		return null;
	}
	@org.junit.Test
	public Aeroport findAeroport(Integer key) {
		fail("fail");
		return null;
	}
	@org.junit.Test
	public void insert (Aeroport v) {
		fail("fail");

	}
	@org.junit.Test
	public Aeroport update(Aeroport a){
		fail("fail");
		return null;
	}
	@org.junit.Test
	public void delete(Aeroport a){
		fail("fail");
	}
	@org.junit.Test
	public void deleteByKey(Integer key){
		fail("fail");
	}
	
	
	
	
	
	
	
	
	
	
	
	


}
