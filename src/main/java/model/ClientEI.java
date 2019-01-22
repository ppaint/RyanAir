package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Entity
@Component
@DiscriminatorValue("EI")
public class ClientEI extends Client {
	
	private String prenom;
	
	private TitrePhysique titre;
	
	public ClientEI() {
		super();
	}
	
	public ClientEI(String prenom, TitrePhysique titre) {
		super();
		this.prenom = prenom;
		this.titre = titre;
	}

	public ClientEI(String nom, String numeroTel, String numerofax, String email, Adresse adresse, String prenom, TitrePhysique titre) {
		super(nom, numeroTel, numerofax, email, adresse);
		this.prenom = prenom;
		this.titre = titre;

	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public TitrePhysique getTitre() {
		return titre;
	}

	public void setTitre(TitrePhysique titre) {
		this.titre = titre;
	}
	
	

}
