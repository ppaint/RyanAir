package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "compagnie_aerienne")
@SequenceGenerator(name = "seqCompagnieAerienne", sequenceName = "seq_compagnie_aerienne", allocationSize = 1, initialValue = 100)

public class CompagnieAerienne {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnieAerienne")
	@Column(name = "id_compagnie_aerienne")
	private Long id;
	@Column(name = "nom_compagnie_aerienne", length = 150)
	private String nom;
	@Autowired
	@OneToMany(mappedBy = "key.compagnieAerienne")
	private List<CompagnieAerienneVol> compagniesAerienneVol;
	@Version
	private int version;

	public CompagnieAerienne() {
	}

	public CompagnieAerienne(String nom) {
		this.nom = nom;
	}

	public CompagnieAerienne(Long id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<CompagnieAerienneVol> getCompagniesAerienneVol() {
		return compagniesAerienneVol;
	}

	public void setCompagniesAerienneVol(List<CompagnieAerienneVol> compagniesAerienneVol) {
		this.compagniesAerienneVol = compagniesAerienneVol;
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
		CompagnieAerienne other = (CompagnieAerienne) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
