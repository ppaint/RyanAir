import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.DaoAeroport;
import dao.DaoAeroportFactory;
import dao.DaoPassager;
import dao.DaoPassagerFactory;
import dao.DaoVille;
import dao.DaoVilleFactory;
import model.Adresse;
import model.Aeroport;
import model.Passager;
import model.Ville;
import util.Context;

public class Apptest {

	public static void main(String[] args) {
		DaoVille DaoVille = DaoVilleFactory.getInstance();
		Ville v = new Ville("Marseille");
		DaoAeroport daoAeroport = DaoAeroportFactory.getInstance();
		Aeroport a = new Aeroport("Le Bel-Air");
		Aeroport b = new Aeroport("Le Bel-Air");
		
		
		v.addAeroport(a);
		v.addAeroport(b);
		
		DaoVille.insert(v);
		daoAeroport.insert(a);
		daoAeroport.insert(b);
		v.setNom("Paris");
		a.setNom("LLLLLL");
		DaoVille.update(v);
		daoAeroport.update(a);
//		DaoVille.delete(v);
//		daoAeroport.delete(a);
		
		
		
		
		
		Context.close();
	}
 
}
 