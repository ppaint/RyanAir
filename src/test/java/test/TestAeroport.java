package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoAeroport;
import dao.DaoVille;
import model.Aeroport;
import model.Ville;
import repository.AeroportRepository;

public class TestAeroport {
	
	private static ClassPathXmlApplicationContext ctx = null;

	private DaoAeroport daoAeroport=null;
	
	private DaoVille daoVille=null;

	private AeroportRepository aeroportRepository;
	
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
		daoAeroport = ctx.getBean(DaoAeroport.class);
		daoVille=ctx.getBean(DaoVille.class);
	}
	
	
	@Before
	public void initRepo() {
		aeroportRepository = ctx.getBean(AeroportRepository.class);
	}
	
	
	@org.junit.Test
	public void FindAll(){
		Aeroport a = new Aeroport("oo");
		Aeroport b = new Aeroport("tt");
		daoAeroport.insert(a);
		daoAeroport.insert(b);
		assertNotNull(daoAeroport.findAll());
	}
	@org.junit.Test
	public void findAeroport() {
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		assertNotNull(a.getId());
	}
	@org.junit.Test
	public void insert () {
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		assertNotNull(a.getId());
	}
	@org.junit.Test
	public void update(){
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		a.setNom("pp");
		assertEquals("pp", a.getNom());
	}
	@org.junit.Test
	public void delete(){
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		daoAeroport.delete(a);
		assertNull(daoAeroport.findByKey(a.getId()));
	}
	@org.junit.Test
	public void deleteByKey(){
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		daoAeroport.delete(a);
		assertNull(daoAeroport.findByKey(a.getId()));
	}
	
	
	@org.junit.Test
	public void findAeroportByNomLike(){
		Aeroport a = new Aeroport("oo");
		daoAeroport.insert(a);
		assertNotNull(aeroportRepository.findAeroportByNomLike("%o"));
	}
	
	@SuppressWarnings("null")
	@org.junit.Test
	public void findAeroportByVilles() {
		Ville v = new Ville("marseille");
		Aeroport a = new Aeroport("Le Bel Air 5");
		Set<Aeroport>aeroports = new HashSet<>();
		daoAeroport.insert(a);
		a = daoAeroport.update(a);
		aeroports.add(a);
		v.setAeroports(aeroports);
		daoVille.insert(v);
		assertNotNull(aeroportRepository.findAeroportByVilles(v));
	}

	
	
	
	
	
	
	


}
