package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="escale")
public class Escale {
	
	@EmbeddedId
	private EscalePk key;
	@Column(name="heure_depart")
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	@Temporal(TemporalType.TIME)
	@Column(name="heure_arrivee")
	private Date heureArrivee;
	
	public EscalePk getKey() {
		return key;
	}
	public void setKey(EscalePk key) {
		this.key = key;
	}
	public Date getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Date getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public Escale() {
		super();
	}

	
	
}
