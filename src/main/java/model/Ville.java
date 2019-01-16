package model;


import java.util.HashSet;
import java.util.Set;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="ville")
@SequenceGenerator (name="seqVille", sequenceName="seq_ville", allocationSize=1,initialValue=1)
public class Ville {
	@Id
	@GeneratedValue(generator="seqVille",strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(name="nom")
	private String nom;
	@ManyToMany
	@JoinTable(name="villeaeroport", joinColumns=@JoinColumn(name="ville_id"), inverseJoinColumns=@JoinColumn(name="aeroport_id"))
	private Set<Aeroport> aeroports= new HashSet<>();
	@Version
	private int version;
	
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
	public Set<Aeroport> getAeroports() {
		return aeroports;
	}
	public void setAeroports(Set<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}
	public Ville(String nom) {
		super();
		this.nom = nom;
	}
	public Ville() {
		super();
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
		Ville other = (Ville) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void addAeroport (Aeroport a) {
		this.aeroports.add(a);
	}

}
