package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoVol;
import model.Aeroport;
import model.Vol;




public class TestVol {
	
	private static ClassPathXmlApplicationContext ctx = null;

	private DaoVol daoVol=null;
	
	@BeforeClass
	public static void initClassPathXmlApplicationContext() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@AfterClass
	public static void closeClassPathXmlApplicationContext() {
		ctx.close();
	}

	@Before
	public void initDaoVol() {
		daoVol = ctx.getBean(DaoVol.class);
	}
	
	
	
	
	
	@Test
	public void insertVol() {

		Vol vol = new Vol();
		daoVol.insert(vol);
		assertNotNull(vol.getId());
		assertNotNull(daoVol.findByKey(vol.getId()));
	}
	
	@Test
	public void deleteVol() {
		Vol vol = new Vol();
		daoVol.insert(vol);
	
		daoVol.delete(vol);
		
		assertNull(daoVol.findByKey(vol.getId()));
	}
	
	@Test
	public void updateVol() {
		Aeroport aeroport1=new Aeroport();
		Aeroport aeroport2=new Aeroport();
		Date date1=null;
		Date date2=null;
		Date date3=null;
		Date date4=null;
		//SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		//String dateArr="01/01/2019";
		//date2 = sdf2.parse(dateArr);
		
		Vol vol1= new Vol(date1, date2, date3, date4, aeroport1, aeroport2);
		daoVol.insert(vol1);
		assertEquals(aeroport1, vol1.getArrivee());
		assertEquals(aeroport2, vol1.getDepart());
		Aeroport aeroport3=new Aeroport();
		Aeroport aeroport4=new Aeroport();
		vol1.setArrivee(aeroport3);
		vol1.setDepart(aeroport4);
		daoVol.update(vol1);
		assertEquals(aeroport3, vol1.getArrivee());
		assertEquals(aeroport4, vol1.getDepart());
		
		
	}




}
