package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*rajouter hascode dès que vol est créé*/



@Embeddable
public class EscalePk implements Serializable{

	@ManyToOne
	@JoinColumn(name="aeroport_id")
	private Aeroport aeroport;
	@ManyToOne
	@JoinColumn(name="vol_id")
	private Vol vol;
	
	public Aeroport getAeroport() {
		return aeroport;
	}
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	public EscalePk() {
		super();
	}

	
	
}
