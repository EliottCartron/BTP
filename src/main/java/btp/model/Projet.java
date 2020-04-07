package btp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Projet {
	@Id
	@GeneratedValue
	private Long id;
	private Integer numeroDevis;
	@Temporal(TemporalType.DATE)
	private Date dtDebut;
	@Temporal(TemporalType.DATE)
	private Date dtFin;
	private Integer arret;
	private String rapport;
	@OneToMany(mappedBy = "projet")
	private List<Reunion> reunions = new ArrayList<Reunion>();
	@OneToMany(mappedBy = "projet")
	private List<PrestationSupplementaire> prestationSupplementaires = new ArrayList<PrestationSupplementaire>();
	@OneToMany(mappedBy = "projet")
	@Transient
	private List<Prestation> prestations = new ArrayList<Prestation>();
	@OneToOne(mappedBy = "projet")
	private Facture facture;
	@OneToOne
	@JoinColumn(name = "offre_id")
	private Offre offre;
	@OneToMany(mappedBy = "projet")
	private List<Action> actions = new ArrayList<Action>();
	
	public Projet() {
		super();
	}

	public Projet(Integer numeroDevis, Date dtDebut, Date dtFin, Integer arret, String rapport) {
		super();
		this.numeroDevis = numeroDevis;
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
		this.arret = arret;
		this.rapport = rapport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroDevis() {
		return numeroDevis;
	}

	public void setNumeroDevis(Integer numeroDevis) {
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

	public Integer getArret() {
		return arret;
	}

	public void setArret(Integer arret) {
		this.arret = arret;
	}

	public String getRapport() {
		return rapport;
	}

	public void setRapport(String rapport) {
		this.rapport = rapport;
	}

	public List<Reunion> getReunions() {
		return reunions;
	}

	public void setReunions(List<Reunion> reunions) {
		this.reunions = reunions;
	}
	
	public void addReunions(Reunion reunion) {
		this.reunions.add(reunion);
	}

	public List<PrestationSupplementaire> getPrestationSupplementaires() {
		return prestationSupplementaires;
	}

	public void setPrestationSupplementaires(List<PrestationSupplementaire> prestationSupplementaires) {
		this.prestationSupplementaires = prestationSupplementaires;
	}
	
	public void addPrestationSupplementaires(PrestationSupplementaire prestationSupplementaire) {
		this.prestationSupplementaires.add(prestationSupplementaire);
	}

	public List<Prestation> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}
	
	public void addPrestation(Prestation prestation) {
		this.prestations.add(prestation);
	}

}
