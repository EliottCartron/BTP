package btp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	private String identifiant;
	private String motDePasse;
	@OneToOne
	private Societe societe;

	// Constructeur

	public Utilisateur(String identifiant, String motDePasse, Societe societe) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.societe = societe;
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	// toString

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", identifiant=" + identifiant + ", motDePasse=" + motDePasse + ", societe="
				+ societe + "]";
	}

}
