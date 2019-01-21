package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="aeroport")
@SequenceGenerator(name="seqAeroport",sequenceName="seq_aeroport",allocationSize=1,initialValue=1)
public class Aeroport {

		@Id
		@GeneratedValue(generator="seqAeroport", strategy=GenerationType.SEQUENCE)
		private Long id;
		@Column(name="nom")
		private String nom;
		@Autowired
		@OneToMany(mappedBy = "arrivee")
		private List<Vol> volsArrivee;
		@Autowired
		@OneToMany(mappedBy = "depart")
		private List<Vol> volsDepart;
		@Autowired
		@ManyToMany(mappedBy="aeroports")
		private List<Ville> villes;
		@Version
		private int version;
		
		
		public int getVersion() {
			return version;
		}
		public void setVersion(int version) {
			this.version = version;
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

		public List<Vol> getVolsArrivee() {
			return volsArrivee;
		}
		public void setVolsArrivee(List<Vol> volsArrivee) {
			this.volsArrivee = volsArrivee;
		}
		public List<Vol> getVolsDepart() {
			return volsDepart;
		}
		public void setVolsDepart(List<Vol> volsDepart) {
			this.volsDepart = volsDepart;
		}
		public List<Ville> getVilles() {
			return villes;
		}
		public void setVilles(List<Ville> villes) {
			this.villes = villes;
		}
		public Aeroport() {
			super();
		}
		public Aeroport(String nom) {
			super();
			this.nom = nom;
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
			Aeroport other = (Aeroport) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		
		
}
