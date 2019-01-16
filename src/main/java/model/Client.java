package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", allocationSize = 1, initialValue = 100)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 10)
public abstract class Client {
	
	// ------------------ Attributs --------------------------- //
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "client_number")
	private Long id;
	
	
	@Column(name = "last_name", length = 150, nullable = false)
	private String nom;
	
	
	@Column(name = "tel_number", length = 150, nullable = false)
	private String numeroTel;
	
	
	@Column(name = "fax_number", length = 150, nullable = false)
	private String numerofax;
	
	
	@Column(name = "mail", length = 150, nullable = false)
	private String email;
	
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "pays", column = @Column(name = "country")),
			@AttributeOverride(name = "rue", column = @Column(name = "street", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "city", length = 150)) })
	private Adresse adresse;
	
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations = new ArrayList<>();
	
	@OneToOne
	private Login login;
	
	@Version
	private int version;
	
	// ------------------ Constructeurs --------------------------- //

	public Client() {
	}

	
	public Client(String nom, String numeroTel, String numerofax, String email, Adresse adresse) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numerofax = numerofax;
		this.email = email;
		this.adresse = adresse;
	}


	// ------------------ Methodes --------------------------- //

	public void addReservation (Reservation r) {
		this.reservations.add(r);
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


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getNumeroTel() {
		return numeroTel;
	}


	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}


	public String getNumerofax() {
		return numerofax;
	}


	public void setNumerofax(String numerofax) {
		this.numerofax = numerofax;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
