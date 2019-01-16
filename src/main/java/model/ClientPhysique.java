package model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("CP")
public class ClientPhysique extends Client {
	
	private String prenom;
	private TitrePhysique titre;
	
	public ClientPhysique() {
		super();
	}
	
	public ClientPhysique(String prenom, TitrePhysique titre) {
		super();
		this.prenom = prenom;
		this.titre = titre;
	}

	public ClientPhysique(String nom, String numeroTel, String numerofax, String email, Adresse adresse, String prenom, TitrePhysique titre){
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
