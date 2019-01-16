package model;

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
