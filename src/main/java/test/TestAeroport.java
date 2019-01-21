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
import model.Vol;




class TestAeroport {
	
	private static ClassPathXmlApplicationContext ctx = null;
	
	private DaoClient daoClient=null;
	private DaoAeroport daoAeroport=null;
	private DaoCompagnieAerienne daoCompagnieAerienne=null;
	private DaoLogin daoLogin=null;
	private DaoPassager daoPassager=null;
	private DaoReservation daoReservation=null;
	private DaoVille daoVille=null;
	private DaoVol daoVol=null;
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
		daoClient = ctx.getBean(DaoClient.class);
		daoAeroport = ctx.getBean(DaoAeroport.class);
		daoCompagnieAerienne = ctx.getBean(DaoCompagnieAerienne.class);
		daoLogin = ctx.getBean(DaoLogin.class);
		daoPassager = ctx.getBean(DaoPassager.class);
		daoReservation = ctx.getBean(DaoReservation.class);
		daoVille = ctx.getBean(DaoVille.class);
		daoVol = ctx.getBean(DaoVol.class);
		daoEscale = ctx.getBean(DaoEscale.class);
	}
	
	
	@org.junit.Test
	public List<Vol> findByVol(){
		return nul;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	


}
