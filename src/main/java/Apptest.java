import dao.DaoPassager;
import dao.DaoPassagerFactory;
import model.Adresse;
import model.Passager;
import util.Context;

public class Apptest {

	public static void main(String[] args) {
		DaoPassager d = DaoPassagerFactory.getInstance();
		
		Passager p1 = new Passager("olivier", "gozlan", new Adresse("France", "rue du tir", "75009", "Paris"));
		d.insert(p1);
		Context.close();
	}
 
}
 