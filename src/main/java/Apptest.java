import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.DaoPassager;
import dao.DaoPassagerFactory;
import dao.DaoVille;
import dao.DaoVilleFactory;
import model.Adresse;
import model.Aeroport;
import model.Passager;
import util.Context;

public class Apptest {

	public static void main(String[] args) {
		
		Context.getEntityManagerFactory();
		Context.close();
	}
 
}
 