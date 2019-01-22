package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.DaoLogin;
import model.Login;



public class TestLogin {
	private static ClassPathXmlApplicationContext ctx = null;

	private DaoLogin daoLogin=null;
	//private LoginRepository LoginRepository =null;
	
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
		daoLogin = ctx.getBean(DaoLogin.class);
	//	LoginRepository = ctx.getBean(LoginRepository.class); 
	}
	
	
	
	@Test
	public void FindAll(){	
		Login l = new Login("login","m",true);
		daoLogin.insert(l);
		assertEquals(1, daoLogin.findAll().size());
		daoLogin.delete(l);
	}
	
	@Test
	public void findLogin() {
		Login l = new Login("login","mdp",true);
		daoLogin.insert(l);
		assertNotNull(daoLogin.findByKey(l.getId()));
		daoLogin.delete(l);
	}

	
	@Test
	public void update(){
		Login l = new Login("login","mdp",true);
		daoLogin.insert(l);
		l.setLogin("newlogin");
		l = daoLogin.update(l);
		assertEquals("newlogin", l.getLogin());
		daoLogin.delete(l);
	}
	
	@Test
	public void deleteByKey(){
		Login l = new Login("login","mdp",true);
		daoLogin.insert(l);
		daoLogin.deleteByKey(l.getId());
		assertNull(daoLogin.findByKey(l.getId()));
	}

}
