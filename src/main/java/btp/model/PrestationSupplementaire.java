package btp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PrestationSupplementaire {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	private String nom;
	private Float prix;
	@Temporal(TemporalType.DATE)
	private Date dtDebut ;
	@Temporal(TemporalType.DATE)
	private Date dtFin;
	@OneToOne 
	@JoinColumn(name = "prestation_id")
	private Prestation prestation;
	@ManyToMany
	@JoinTable(name ="matos_prestaSupp",
	joinColumns = @JoinColumn (name = "prestationSupplementaire_id ", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn (name = "materiel_id ", referencedColumnName = "id"))
	private List<Materiel> materiels = new ArrayList<Materiel>();
	@ManyToOne
	@JoinColumn(name = "projet_id")
	private Projet projet;
	@ManyToOne
	@JoinColumn(name = "prestataire_id")
	private Prestataire prestataire;
	@ManyToMany
	@JoinTable(name ="salarie_presta_Supp", 
	joinColumns = @JoinColumn (name = "salarie_id ", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn (name = "prestationSupplementaire_id ", referencedColumnName = "id"))
	private List<Salarie> salaries = new ArrayList<Salarie>();
	@OneToOne(mappedBy = "prestationSupplementaire") 
	private Facture facture;
	
	
	
	public PrestationSupplementaire() {
		super();
	}
	
	public PrestationSupplementaire(Categorie categorie, String nom, Float prix, Date dtDebut, Date dtFin) {
		super();
		this.categorie = categorie;
		this.nom = nom;
		this.prix = prix;
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
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

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public List<Materiel> getMateriels() {
		return materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	
	public void addMateriels(Materiel materiel) {
		this.materiels.add(materiel);
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public List<Salarie> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salarie> salaries) {
		this.salaries = salaries;
	}
	
	public void addSalaries(Salarie salarie) {
		this.salaries.add(salarie);
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	

}
