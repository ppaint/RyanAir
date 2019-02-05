package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoVol;
import model.Vol;




public class TestVol {
	
	private static ClassPathXmlApplicationContext ctx = null;

	private DaoVol daoVol=null;
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
		daoVol = ctx.getBean(DaoVol.class);
	//	villeRepository = ctx.getBean(VilleRepository.class); 
	}
	
	
	@org.junit.Test
	public void FindAll(){
		Vol a = new Vol();
		Vol b = new Vol();
		daoVol.insert(a);
		daoVol.insert(b);
		assertNotNull(daoVol.findAll());
	}
	@org.junit.Test
	public void findVol() {
		Vol a = new Vol();
		daoVol.insert(a);
		assertNotNull(daoVol.findByKey(a.getId()));
	}
	@org.junit.Test
	public void insert () {
		Vol a = new Vol();
		daoVol.insert(a);
		assertNotNull(a.getId());
	}
	
	@org.junit.Test
	public void update(){
		Vol a = new Vol();	
		daoVol.insert(a);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			a.setDateDepart(sdf.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		a = daoVol.update(a);
	}
	@org.junit.Test
	public void delete(){
		Vol a = new Vol();
		daoVol.insert(a);
		daoVol.delete(a);
		assertNull(daoVol.findByKey(a.getId()));
	}
	@org.junit.Test
	public void deleteByKey(){
		Vol a = new Vol();
		daoVol.insert(a);
		daoVol.deleteByKey(a.getId());
		assertNull(daoVol.findByKey(a.getId()));
	}
	


}
