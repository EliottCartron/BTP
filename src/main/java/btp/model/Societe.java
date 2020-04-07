package btp.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Societe {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private int siret;
	private int telephone;
	private String mail;
	private String type;
	private String numeroDeTva;
	
	@OneToOne
	private Utilisateur utilisateur;
	
	@Embedded
	private Adresse adresse;

// Constructeur

	public Societe(String nom, int siret, int telephone, String mail, String type, String numeroDeTva) {
		super();
		this.nom = nom;
		this.siret = siret;
		this.telephone = telephone;
		this.mail = mail;
		this.type = type;
		this.numeroDeTva = numeroDeTva;
	}

//Getters and setters

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

	public int getSiret() {
		return siret;
	}

	public void setSiret(int siret) {
		this.siret = siret;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumeroDeTva() {
		return numeroDeTva;
	}

	public void setNumeroDeTva(String numeroDeTva) {
		this.numeroDeTva = numeroDeTva;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	// toString

	@Override
	public String toString() {
		return "Societe [nom=" + nom + ", siret=" + siret + ", telephone=" + telephone + ", mail=" + mail + ", type="
				+ type + ", numeroDeTva=" + numeroDeTva + ", utilisateur=" + utilisateur + ", adresse=" + adresse + "]";
	}

}