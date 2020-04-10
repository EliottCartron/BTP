package btp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Offre {
	@Id
	@GeneratedValue
	private Long id;
	private Float prix;
	private int numeroDevis;
	@Temporal(TemporalType.DATE)
	private Date dtDebut;
	@Temporal(TemporalType.DATE)
	private Date dtFin;
	
	@Enumerated(EnumType.STRING)
	private Etat etat;

	@ManyToOne
	private MaitreOuvrage maitreOuvrage;

	@ManyToOne
	private MaitreOeuvre maitreOeuvre;

	@ManyToOne
	private AppelOffre appelOffre;


	@OneToMany(mappedBy = "offre")
	private List<Prestation> prestations = new ArrayList<Prestation>();
	
	@OneToOne (mappedBy = "offre", fetch = FetchType.EAGER)
	private Projet projet;

	// Constructeurs
	
	public Offre() {
		super();
	}

	

	public Offre(Float prix, int numeroDevis, Date dtDebut, Date dtFin) {
		super();
		this.prix = prix;
		this.numeroDevis = numeroDevis;
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public int getNumeroDevis() {
		return numeroDevis;
	}

	public void setNumeroDevis(int numeroDevis) {
		this.numeroDevis = numeroDevis;
	}

	public Date getDtDebut() {
		return dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	public Date getDtFin() {
		return dtFin;
	}

	public void setDtFin(Date dtFin) {
		this.dtFin = dtFin;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public List<Prestation> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public MaitreOuvrage getMaitreOuvrage() {
		return maitreOuvrage;
	}

	public void setMaitreOuvrage(MaitreOuvrage maitreOuvrage) {
		this.maitreOuvrage = maitreOuvrage;
	}

	public MaitreOeuvre getMaitreOeuvre() {
		return maitreOeuvre;
	}

	public void setMaitreOeuvre(MaitreOeuvre maitreOeuvre) {
		this.maitreOeuvre = maitreOeuvre;
	}

	public AppelOffre getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffre appelOffre) {
		this.appelOffre = appelOffre;
	}
	
	@Override
	public String toString() {
		return "Offre [prix=" + prix + ", numeroDevis=" + numeroDevis + ", dtDebut=" + dtDebut + ", dtFin=" + dtFin
				+ ", etat=" + etat + "]";
	}

}
