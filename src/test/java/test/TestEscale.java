package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoEscale;
import model.Escale;
import model.Ville;

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
	public void FindAll(){
		Escale a = new Escale();
		Escale b = new Escale();
		daoEscale.insert(a);
		daoEscale.insert(b);
		assertNotNull(daoEscale.findAll());
	
	}
	

	@org.junit.Test
	public void delete(){
		Escale a = new Escale();
		daoEscale.insert(a);
		daoEscale.delete(a);
		assertNull(daoEscale.findAll());
	}

	

}
