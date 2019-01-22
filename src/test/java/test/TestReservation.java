package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoReservation;
import model.Reservation;


public class TestReservation {

	private static ClassPathXmlApplicationContext ctx = null;

	private DaoReservation daoReservation=null;
	
	@BeforeClass
	public static void initClassPathXmlApplicationContext() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@AfterClass
	public static void closeClassPathXmlApplicationContext() {
		ctx.close();
	}

	@Before
	public void initDaoReservation() {
		daoReservation = ctx.getBean(DaoReservation.class);
	}
	
	
	@Test
	public void insertReservation() {

		Reservation reservation = new Reservation();
		daoReservation.insert(reservation);
		assertNotNull(reservation.getId());
		
	}
	
	@Test
	public void deleteReservation() {
		Reservation reservation = new Reservation();
		daoReservation.insert(reservation);
	
		daoReservation.delete(reservation);
		
		assertNull(reservation.getId());
	}
	
	@Test
	public void updateReservation() {
		Date date =null;
		Integer numero=4;
		Reservation reservation=new Reservation(date, numero);
		daoReservation.insert(reservation);
		assertEquals(numero, reservation.getNumero());
		reservation.setNumero(6);
		daoReservation.update(reservation);
		Integer numero2=6;
		assertEquals(numero2, reservation.getNumero());
		
		
	}
	

}
