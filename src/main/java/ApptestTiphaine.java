import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.DaoCompagnieAerienne;
import dao.DaoCompagnieAerienneFactory;
import dao.DaoCompagnieAerienneVol;
import dao.DaoCompagnieAerienneVolFactory;
import dao.DaoVol;
import dao.DaoVolFactory;
import model.CompagnieAerienne;
import model.CompagnieAerienneVol;
import model.CompagnieAerienneVolPk;
import model.Vol;
import util.Context;

public class ApptestTiphaine {

	public static void main(String[] args) {
		
		//Context.getEntityManagerFactory();
		
		DaoVol daovol = DaoVolFactory.getInstance();
		Vol vol1 = new Vol();
		daovol.insert(vol1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol1.setDateDepart(sdf.parse("01/01/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		daovol.update(vol1);
		
		DaoCompagnieAerienne daocomp = DaoCompagnieAerienneFactory.getInstance();
		CompagnieAerienne comp1 = new CompagnieAerienne();
		daocomp.insert(comp1);
		
		comp1.setNom("Air France");
		daocomp.update(comp1);
		
		CompagnieAerienneVolPk pk1=new CompagnieAerienneVolPk(comp1, vol1);
		
		DaoCompagnieAerienneVol daocompvol = DaoCompagnieAerienneVolFactory.getInstance();
		CompagnieAerienneVol comp2 = new CompagnieAerienneVol(pk1, "30");
		daocompvol.insert(comp2);
		comp2.setNumero("44");
		daocompvol.update(comp2);
		
		//daovol.delete(vol1);
		
		daocomp.delete(comp1);
		
		//System.out.println(daovol.findEscaleByKeyWithVol(100L));
		
		//System.out.println(daovol.findCompagnieByKeyWithVol(100L));
		
		
		
		
		
		

		
		Context.close();
	}
 
}
 