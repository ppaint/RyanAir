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

import dao.DaoCompagnieAerienneVol;

import dao.DaoEscale;
import dao.DaoVille;
import model.CompagnieAerienneVol;

class TestCompagnieAerienneCompagnieAerienneVol {

	private static ClassPathXmlApplicationContext ctx = null;


	private DaoCompagnieAerienneVol daoCompagnieAerienneVol=null;

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
		daoCompagnieAerienneVol = ctx.getBean(DaoCompagnieAerienneVol.class);
	}
	
	
	@org.junit.Test
	public List<CompagnieAerienneVol> FindAll(CompagnieAerienneVol v){
		fail("fail");
		return null;
	}
	@org.junit.Test
	public CompagnieAerienneVol findCompagnieAerienneVol(Integer key) {
		fail("fail");
		return null;
	}
	@org.junit.Test
	public void insert (CompagnieAerienneVol v) {
		fail("fail");

	}
	@org.junit.Test
	public CompagnieAerienneVol update(CompagnieAerienneVol v){
		fail("fail");
		return null;
	}
	@org.junit.Test
	public void delete(CompagnieAerienneVol v){
		fail("fail");
	}
	@org.junit.Test
	public void deleteByKey(Integer key){
		fail("fail");
	}
}
