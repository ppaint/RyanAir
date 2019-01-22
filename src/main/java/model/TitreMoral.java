package model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;



public enum TitreMoral {
	ETAT("etat"), CIE("societe"), ASS("association");
	
	private String titreMoral;

	private TitreMoral(String titreMoral) {
		this.titreMoral = titreMoral;
	}

	public String getTitreMoral() {
		return titreMoral;
	}

	public void setTitreMoral(String titreMoral) {
		this.titreMoral = titreMoral;
	}
	
	

}
