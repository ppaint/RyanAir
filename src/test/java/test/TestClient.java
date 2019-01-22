package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.DaoClient;
import model.Adresse;
import model.ClientEI;
import model.ClientMoral;
import model.ClientPhysique;
import model.TitreMoral;
import model.TitrePhysique;



public class TestClient {
	private static ClassPathXmlApplicationContext ctx = null;

	private DaoClient daoClient=null;
	//private ClientRepository ClientRepository =null;
	
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
	//	ClientRepository = ctx.getBean(ClientRepository.class); 
	}
	
	
	
	@Test
	public void FindAll(){	
		Adresse adr = new Adresse("pays", "rue","codeP","ville");
		ClientEI a = new ClientEI("nom","tel","fax","mail",adr,"oo",TitrePhysique.M);
		ClientMoral b = new ClientMoral("nom","tel","fax","mail",adr,"tt",TitreMoral.ETAT);
		ClientPhysique c = new ClientPhysique("nom","tel","fax","mail",adr,"dd",TitrePhysique.M);
		daoClient.insert(a);
		daoClient.insert(b);
		daoClient.insert(c);
		assertEquals(3, daoClient.findAll().size());
		daoClient.delete(a);
		daoClient.delete(b);
		daoClient.delete(c);
	}
	
	@Test
	public void findClient() {
		Adresse adr = new Adresse("pays", "rue","codeP","ville");
		ClientEI a = new ClientEI("nom","tel","fax","mail",adr,"oo",TitrePhysique.M);
		ClientMoral b = new ClientMoral("nom","tel","fax","mail",adr,"tt",TitreMoral.ETAT);
		ClientPhysique c = new ClientPhysique("nom","tel","fax","mail",adr,"dd",TitrePhysique.M);
		daoClient.insert(a);
		daoClient.insert(b);
		daoClient.insert(c);
		assertNotNull(daoClient.findByKey(a.getId()));
		assertNotNull(daoClient.findByKey(b.getId()));
		assertNotNull(daoClient.findByKey(c.getId()));
		daoClient.delete(a);
		daoClient.delete(b);
		daoClient.delete(c);
	}

	
	@Test
	public void update(){
		Adresse adr = new Adresse("pays", "rue","codeP","ville");
		ClientEI a = new ClientEI("nom","tel","fax","mail",adr,"oo",TitrePhysique.M);
		ClientMoral b = new ClientMoral("nom","tel","fax","mail",adr,"tt",TitreMoral.ETAT);
		ClientPhysique c = new ClientPhysique("nom","tel","fax","mail",adr,"dd",TitrePhysique.M);
		daoClient.insert(a);
		daoClient.insert(b);
		daoClient.insert(c);
		a.setPrenom("oooo");
		b.setsiret("tttt");
		c.setPrenom("dddd");
		a = (ClientEI) daoClient.update(a);
		b = (ClientMoral) daoClient.update(b);
		c = (ClientPhysique) daoClient.update(c);
		assertEquals("oooo", a.getPrenom());
		assertEquals("tttt", b.getsiret());
		assertEquals("dddd", c.getPrenom());
		daoClient.delete(a);
		daoClient.delete(b);
		daoClient.delete(c);
	}
	
	@Test
	public void deleteByKey(){
		Adresse adr = new Adresse("pays", "rue","codeP","ville");
		ClientEI a = new ClientEI("nom","tel","fax","mail",adr,"oo",TitrePhysique.M);
		ClientMoral b = new ClientMoral("nom","tel","fax","mail",adr,"tt",TitreMoral.ETAT);
		ClientPhysique c = new ClientPhysique("nom","tel","fax","mail",adr,"dd",TitrePhysique.M);
		daoClient.insert(a);
		daoClient.insert(b);
		daoClient.insert(c);
		daoClient.deleteByKey(a.getId());
		daoClient.deleteByKey(b.getId());
		daoClient.deleteByKey(c.getId());
		assertNull(daoClient.findByKey(a.getId()));
		assertNull(daoClient.findByKey(b.getId()));
		assertNull(daoClient.findByKey(c.getId()  ));
	}
	


}
