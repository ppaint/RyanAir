package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
@Entity
@DiscriminatorValue("CM")
public class ClientMoral extends Client {
	
	private String siret;
	private TitreMoral titre;
	
	public ClientMoral() {
		super();
	}
	
	public ClientMoral(String siret, TitreMoral titre) {
		super();
		this.siret = siret;
		this.titre = titre;
	}

	public ClientMoral(String nom, String numeroTel, String numerofax, String email, Adresse adresse, String siret, TitreMoral titre) {
		super(nom, numeroTel, numerofax, email, adresse);
		this.siret = siret;
		this.titre = titre;
	}

	public String getsiret() {
		return siret;
	}

	public void setsiret(String siret) {
		this.siret = siret;
	}

	public TitreMoral getTitre() {
		return titre;
	}

	public void setTitre(TitreMoral titre) {
		this.titre = titre;
	}
	
	

}
