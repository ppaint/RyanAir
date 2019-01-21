package test;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.DaoVille;
import model.Ville;


class TestVille {
	private static ClassPathXmlApplicationContext ctx = null;
;
	private DaoVille daoVille=null;

	
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
		daoVille = ctx.getBean(DaoVille.class);
	}
	
	
	@org.junit.Test
	public void FindAll(){
//		Ville ville = new Ville();
//		assertNotNull(object);
	}
	@org.junit.Test
	public void findVille() {
		fail("fail");
	}
	@org.junit.Test
	public void insert () {
		Ville ville = new Ville();
		daoVille.insert(ville);
		assertNotNull(ville.getId());
	}
	@org.junit.Test
	public void update(){
		fail("fail");
	}
	@org.junit.Test
	public void delete(){
		fail("fail");
	}
	@org.junit.Test
	public void deleteByKey(){
		fail("fail");
	}
	


}
