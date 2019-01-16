package model;

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
