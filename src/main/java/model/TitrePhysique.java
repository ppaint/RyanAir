package model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;



public enum TitrePhysique {
	M("monsieur"), MME("madame"), MLLE("mademoiselle");
	
	private String titrePhysique;

	private TitrePhysique(String titrePhysique) {
		this.titrePhysique = titrePhysique;
	}

	public String getTitrePhysique() {
		return titrePhysique;
	}

	public void setTitrePhysique(String titrePhysique) {
		this.titrePhysique = titrePhysique;
	}
	
	

}
