package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoCompagnieAerienne;
import model.CompagnieAerienne;

public class TestCompagnieAerienne {

	private static ClassPathXmlApplicationContext ctx = null;

	private DaoCompagnieAerienne daoCompagnieAerienne=null;

	
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
		daoCompagnieAerienne = ctx.getBean(DaoCompagnieAerienne.class);
	}
	
	
	@org.junit.Test
	public void FindAll(){
		CompagnieAerienne a = new CompagnieAerienne("oo");
		CompagnieAerienne b = new CompagnieAerienne("tt");
		daoCompagnieAerienne.insert(a);
		daoCompagnieAerienne.insert(b);
		assertNotNull(daoCompagnieAerienne.findAll());	
	}
	@org.junit.Test
	public void findCompagnieAerienne() {
		CompagnieAerienne a = new CompagnieAerienne("oo");
		daoCompagnieAerienne.insert(a);
		assertNotNull(daoCompagnieAerienne.findByKey(a.getId()));
	}

	@org.junit.Test
	public void update(){
		CompagnieAerienne a = new CompagnieAerienne("oo");
		daoCompagnieAerienne.insert(a);
		a.setNom("pp");
		a = daoCompagnieAerienne.update(a);
		assertEquals("pp", a.getNom());
	}
	@org.junit.Test
	public void delete(){
		CompagnieAerienne a = new CompagnieAerienne("oo");
		daoCompagnieAerienne.insert(a);
		daoCompagnieAerienne.delete(a);
		assertNull(daoCompagnieAerienne.findByKey(a.getId()));
	}
	@org.junit.Test
	public void deleteByKey(){
		CompagnieAerienne a = new CompagnieAerienne("oo");
		daoCompagnieAerienne.insert(a);
		daoCompagnieAerienne.deleteByKey(a.getId());
		assertNull(daoCompagnieAerienne.findByKey(a.getId()));
	}
}
