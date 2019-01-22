package model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "passenger")
@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passenger", allocationSize = 1, initialValue = 100)
public class Passager {
	
	// ------------------ Attributs --------------------------- //
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@Column(name = "person_number")
	private Long id;
	
	
	@Column(name = "first_name", length = 150, nullable = false)
	private String prenom;
	
	
	@Column(name = "last_name", length = 150, nullable = false)
	private String nom;
	
	
	@Autowired
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "pays", column = @Column(name = "country")),
			@AttributeOverride(name = "rue", column = @Column(name = "street", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "city", length = 150)) })
	private Adresse adresse;
	
	@Autowired
	@OneToMany(mappedBy = "passager")
	private List<Reservation> reservations;
	
	// ------------------ Constructeurs --------------------------- //

	public Passager() {
	}


	public Passager(String prenom, String nom, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
	}




	// ------------------ Methodes --------------------------- //

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Passager other = (Passager) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
