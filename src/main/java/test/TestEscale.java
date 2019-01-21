package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoAeroport;
import dao.DaoCompagnieAerienne;
import dao.DaoEscale;
import dao.DaoVille;
import model.Escale;

class TestEscale {

	private static ClassPathXmlApplicationContext ctx = null;

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
		daoEscale = ctx.getBean(DaoEscale.class);
	}
	
	
	@org.junit.Test
	public List<Escale> FindAll(Escale v){
		fail("fail");
		return null;
	}
	@org.junit.Test
	public Escale findEscale(Integer key) {
		fail("fail");
		return null;
	}
	@org.junit.Test
	public void insert (Escale v) {
		fail("fail");

	}
	@org.junit.Test
	public Escale update(Escale v){
		fail("fail");
		return null;
	}
	@org.junit.Test
	public void delete(Escale v){
		fail("fail");
	}
	@org.junit.Test
	public void deleteByKey(Integer key){
		fail("fail");
	}
	

}
