package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", allocationSize = 1, initialValue = 100)
public class Vol {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	@Column(name = "id_vol")
	private long id;
	@Temporal(TemporalType.TIME)
	@Column(name="heure_depart")
	private Date heureDepart;
	@Temporal(TemporalType.TIME)
	@Column(name="heure_arrivee")
	private Date heureArrivee;
	@Temporal(TemporalType.DATE)
	@Column(name="date_depart")
	private Date dateDepart;
	@Temporal(TemporalType.DATE)
	@Column(name="date_arrivee")
	private Date dateArrivee;
	@ManyToOne
	@JoinColumn(name="aeroport_arrivee")
	private Aeroport arrivee;
	@ManyToOne
	@JoinColumn(name="aeroport_depart")
	private Aeroport depart;
	
	@Autowired
	@OneToMany(mappedBy = "key.vol")
	private List<Escale> escales;
	@Autowired
	@OneToMany(mappedBy = "key.vol")
	private List<CompagnieAerienneVol> compagniesAerienneVol;
	@Autowired
	@OneToMany(mappedBy = "vol")
	private List<Reservation> reservations;
	@Version
	private int version;

	public Vol(long id, Date heureDepart, Date heureArrivee, Date dateDepart, Date dateArrivee, Aeroport arrivee,
			Aeroport depart) {
		this.id = id;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.arrivee = arrivee;
		this.depart = depart;
	}

	public Vol(Date heureDepart, Date heureArrivee, Date dateDepart, Date dateArrivee, Aeroport arrivee,
			Aeroport depart) {
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.arrivee = arrivee;
		this.depart = depart;
	}

	public Vol() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Aeroport getArrivee() {
		return arrivee;
	}

	public void setArrivee(Aeroport arrivee) {
		this.arrivee = arrivee;
	}

	public Aeroport getDepart() {
		return depart;
	}

	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}

	public List<Escale> getEscales() {
		return escales;
	}

	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}

	public List<CompagnieAerienneVol> getCompagniesAerienneVol() {
		return compagniesAerienneVol;
	}

	public void setCompagniesAerienneVol(List<CompagnieAerienneVol> compagniesAerienneVol) {
		this.compagniesAerienneVol = compagniesAerienneVol;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vol other = (Vol) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
