package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.DaoVille;
import model.Ville;



public class TestVille {
	private static ClassPathXmlApplicationContext ctx = null;

	private DaoVille daoVille=null;
	//private VilleRepository villeRepository =null;
	
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
	//	villeRepository = ctx.getBean(VilleRepository.class); 
	}
	
	
	@org.junit.Test
	public void FindAll(){
		Ville a = new Ville("oo");
		Ville b = new Ville("tt");
		daoVille.insert(a);
		daoVille.insert(b);
		assertNotNull(daoVille.findAll());
	}
	@org.junit.Test
	public void findVille() {
		Ville a = new Ville("oo");
		daoVille.insert(a);
		assertNotNull(daoVille.findByKey(a.getId()));
	}
	
	@org.junit.Test
	public void update(){
		Ville a = new Ville("oo");
		daoVille.insert(a);
		a.setNom("pp");
		a = daoVille.update(a);
		assertEquals("pp", a.getNom());
	}
	@org.junit.Test
	public void delete(){
		Ville a = new Ville("oo");
		daoVille.insert(a);
		daoVille.delete(a);
		assertNull(daoVille.findByKey(a.getId()));
	}
	@org.junit.Test
	public void deleteByKey(){
		Ville a = new Ville("oo");
		daoVille.insert(a);
		daoVille.deleteByKey(a.getId());
		assertNull(daoVille.findByKey(a.getId()));
	}
	


}
