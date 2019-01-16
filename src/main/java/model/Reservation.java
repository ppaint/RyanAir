package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", allocationSize = 1, initialValue = 100)
public class Reservation {

	//--------- Attributs -----------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name = "reservation_number")
	private Long id;
	
	
	@Column(name = "departureDate", length = 150, nullable = false)
	private Date date;
	
	
	@Column(name = "number", length = 150, nullable = false)
	private Integer numero;
	
	
	@ManyToOne
	@JoinColumn(name = "passenger",nullable = false)
	private Passager passager;
	
	
	@ManyToOne
	@JoinColumn(name = "client", nullable = false)
	private Client client;
	
	
	@ManyToOne
	@JoinColumn(name = "fly", nullable = true)
	private Vol vol;


	//--------- Constructeurs -------------
	
	public Reservation() {
		super();
	}


	public Reservation(Date date, Integer numero, Vol vol) {
		super();
		this.date = date;
		this.numero = numero;
		this.vol = vol;
	}


	//--------- Methodes -----------------
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Passager getPassager() {
		return passager;
	}


	public void setPassager(Passager passager) {
		this.passager = passager;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Vol getVol() {
		return vol;
	}


	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	
	
	
	


}
