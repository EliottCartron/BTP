package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Prestataire")
public class Prestataire extends Societe {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "nom")
	private String nom;

	@OneToMany(mappedBy = "prestataire")
	private List<Action> actions = new ArrayList<Action>();

	@OneToMany(mappedBy = "prestataire")
	private List<Facture> factures = new ArrayList<Facture>();

	@OneToMany(mappedBy = "prestataire")
	private List<Salarie> salarie = new ArrayList<Salarie>();

	@OneToMany(mappedBy = "prestataire")
	private List<PrestationSupplementaire> prestationSupplementaire = new ArrayList<PrestationSupplementaire>();

	@OneToMany(mappedBy = "prestataire")
	private List<Materiel> materiel = new ArrayList<Materiel>();

	@OneToMany(mappedBy = "prestataire")
	private List<Prestation> prestation = new ArrayList<Prestation>();

	public Prestataire() {
		super();
	}

	public Prestataire(String nom) {
		super();
		this.nom = nom;
	}
	
		public Prestataire(String nom, String siret, String telephone, String mail, String numeroDeTva) {
		super(nom, siret, telephone, mail, numeroDeTva);
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	public void addActions(Action action) {
		this.actions.add(action);
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	
	public void addFactures(Facture facture) {
		this.factures.add(facture);
	}

	public List<Salarie> getSalarie() {
		return salarie;
	}

	public void setSalarie(List<Salarie> salarie) {
		this.salarie = salarie;
	}
	
	public void addSalarie(Salarie salarie) {
		this.salarie.add(salarie);
	}

	public List<PrestationSupplementaire> getPrestationSupplementaire() {
		return prestationSupplementaire;
	}

	public void setPrestationSupplementaire(List<PrestationSupplementaire> prestationSupplementaire) {
		this.prestationSupplementaire = prestationSupplementaire;
	}
	
	public void addPrestationSupplementaires(PrestationSupplementaire prestationSupplementaire) {
		this.prestationSupplementaire.add(prestationSupplementaire);
	}

	public List<Materiel> getMateriel() {
		return materiel;
	}

	public void setMateriel(List<Materiel> materiel) {
		this.materiel = materiel;
	}
	
	public void addMateriel(Materiel materiel) {
		this.materiel.add(materiel);
	}

	public List<Prestation> getPrestation() {
		return prestation;
	}

	public void setPrestation(List<Prestation> prestation) {
		this.prestation = prestation;
	}
	
	public void addPrestation(Prestation prestation) {
		this.prestation.add(prestation);
	}

}
