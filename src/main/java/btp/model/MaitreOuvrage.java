package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MaitreOuvrage extends Societe {
	@OneToMany(mappedBy = "maitreOuvrage")
	private List<AppelOffre> appeloffres = new ArrayList<AppelOffre>();
	
	@OneToMany(mappedBy = "maitreOuvrage")
	private List<Offre> offres = new ArrayList<Offre>();
	
	@OneToMany(mappedBy = "maitreOuvrage")
	private List<Facture> factures = new ArrayList<Facture>();

	// Constructeur
	
	public MaitreOuvrage(String nom, int siret, int telephone, String mail, String type, String numeroDeTva,
			List<AppelOffre> appeloffres, List<Offre> offres, List<Facture> factures) {
		super(nom, siret, telephone, mail, type, numeroDeTva);
		this.appeloffres = appeloffres;
		this.offres = offres;
		this.factures = factures;
	}

	// getters and setters
	
	public List<AppelOffre> getAppeloffres() {
		return appeloffres;
	}

	public void setAppeloffres(List<AppelOffre> appeloffres) {
		this.appeloffres = appeloffres;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

}
