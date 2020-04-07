package btp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Offre {
	@Id
	@GeneratedValue
	private Long id;
	private Float prix;
	private int numeroDevis;
	private Date dtDebut;
	private Date dtFin;
	private Etat etat;
	
	@ManyToOne
	private MaitreOuvrage maitreOuvrage;
	
	@ManyToOne
	private MaitreOeuvre maitreOeuvre;
	
	@ManyToOne
	private AppelOffre appelOffre;
	
	@OneToMany(mappedBy = "offre")
	private List<Prestation> prestations = new ArrayList<Prestation>();
	
	@OneToOne (mappedBy = "offre")
	private Projet projet;
	

	// Constructeurs

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

	@Override
	public String toString() {
		return "Offre [prix=" + prix + ", numeroDevis=" + numeroDevis + ", dtDebut=" + dtDebut + ", dtFin=" + dtFin + ", etat=" + etat + "]";
	}

}
