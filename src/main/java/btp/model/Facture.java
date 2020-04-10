package btp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Facture {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	
	private int numeroFacture;
	
	@Temporal(TemporalType.DATE)
	private Date dtFacturation;
	
	private Float prixHT;
	
	private Float remise;
	
	@Temporal(TemporalType.DATE)
	private Date dtEcheance;
	
	private Float penaliteRetard;
	
	private Boolean payee;
	
	@ManyToOne
	@JoinColumn(name = "prestataire_id")
	private Prestataire prestataire;
	
	@ManyToOne
	private MaitreOeuvre maitreOeuvre;
	
	@ManyToOne
	private MaitreOuvrage maitreOuvrage;
	
	@OneToOne
	private Projet projet;
	
	@OneToOne
	private PrestationSupplementaire prestationSupplementaire;
	
	@OneToOne
	private Prestation prestation;
	
	
	public Facture() {
		super();
	}

	public Facture(int numeroFacture, Date dtFacturation, Float prixHT, Float remise,
			Date dtEcheance, Float penaliteRetard) {
		super();
		this.numeroFacture = numeroFacture;
		this.dtFacturation = dtFacturation;
		this.prixHT = prixHT;
		this.remise = remise;
		this.dtEcheance = dtEcheance;
		this.penaliteRetard = penaliteRetard;
	}
	
	public Facture(int numeroFacture) {
		super();
		this.numeroFacture = numeroFacture;
	}



	public MaitreOeuvre getMaitreOeuvre() {
		return maitreOeuvre;
	}

	public void setMaitreOeuvre(MaitreOeuvre maitreOeuvre) {
		this.maitreOeuvre = maitreOeuvre;
	}

	public MaitreOuvrage getMaitreOuvrage() {
		return maitreOuvrage;
	}

	public void setMaitreOuvrage(MaitreOuvrage maitreOuvrage) {
		this.maitreOuvrage = maitreOuvrage;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public PrestationSupplementaire getPrestationSupplementaire() {
		return prestationSupplementaire;
	}

	public void setPrestationSupplementaire(PrestationSupplementaire prestationSupplementaire) {
		this.prestationSupplementaire = prestationSupplementaire;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
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

	public int getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public Date getDtFacturation() {
		return dtFacturation;
	}

	public void setDtFacturation(Date dtFacturation) {
		this.dtFacturation = dtFacturation;
	}

	public Float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(Float prixHT) {
		this.prixHT = prixHT;
	}

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public Date getDtEcheance() {
		return dtEcheance;
	}

	public void setDtEcheance(Date dtEcheance) {
		this.dtEcheance = dtEcheance;
	}

	public Float getPenaliteRetard() {
		return penaliteRetard;
	}

	public void setPenaliteRetard(Float penaliteRetard) {
		this.penaliteRetard = penaliteRetard;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}
	
	public Boolean getPayee() {
		return payee;
	}

	public void setPayee(Boolean payee) {
		this.payee = payee;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", version=" + version + ", numeroFacture=" + numeroFacture + ", dtFacturation="
				+ dtFacturation + ", prixHT=" + prixHT + ", remise=" + remise + ", dtEcheance=" + dtEcheance
				+ ", penaliteRetard=" + penaliteRetard + "]";
	}

	
	
}
