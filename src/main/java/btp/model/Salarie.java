package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
public class Salarie {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	
	private String nom;
	
	private String prenom;
	
	private String metier;
	
	@ManyToMany
	@JoinTable(name = "action_salarie", 
			uniqueConstraints = @UniqueConstraint(columnNames = { "salarie_id", "action_id" }),
			joinColumns = @JoinColumn(name="salarie_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name="action_id", referencedColumnName = "id"))
	private List<Action> actions = new ArrayList<Action>();
	
	@ManyToOne
	@JoinColumn(name = "prestataire_id")
	private Prestataire prestataire;
	
//	@ManyToMany
//	@JoinTable(name = "prestation_salarie", 
//			uniqueConstraints = @UniqueConstraint(columnNames = { "salarie_id", "prestation_id" }),
//			joinColumns = @JoinColumn(name="salarie_id", referencedColumnName = "id"), 
//			inverseJoinColumns = @JoinColumn(name="prestation_id", referencedColumnName = "id"))
//	private List<Prestation> prestations = new ArrayList<Prestation>();
//	
//	@ManyToMany
//	@JoinTable(name = "prestationsup_salarie", 
//			uniqueConstraints = @UniqueConstraint(columnNames = { "salarie_id", "prestationsup_id" }),
//			joinColumns = @JoinColumn(name="salarie_id", referencedColumnName = "id"), 
//			inverseJoinColumns = @JoinColumn(name="prestationsup_id", referencedColumnName = "id"))
//	private List<PrestationSupplementaire> prestationSupplementaires = new ArrayList<PrestationSupplementaire>();

	
	public Salarie() {
		super();
	}
	
	public Salarie(String nom, String prenom, String metier) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.metier = metier;
	}

	public Salarie(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

//	public List<Prestation> getPrestations() {
//		return prestations;
//	}
//
//	public void setPrestations(List<Prestation> prestations) {
//		this.prestations = prestations;
//	}
//
//	public List<PrestationSupplementaire> getPrestationSupplementaires() {
//		return prestationSupplementaires;
//	}
//
//	public void setPrestationSupplementaires(List<PrestationSupplementaire> prestationSupplementaires) {
//		this.prestationSupplementaires = prestationSupplementaires;
//	}

//	@Override
//	public String toString() {
//		return "Salarie [id=" + id + ", version=" + version + ", nom=" + nom + ", prenom=" + prenom + ", metier="
//				+ metier + "]";
//	}
	
	
}
