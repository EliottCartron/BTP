package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MaitreOeuvre extends Societe {
	@OneToMany(mappedBy = "maitreOeuvre")
	private List<Offre> offres = new ArrayList<Offre>();
	
	@OneToOne
	private Facture facture;

	// Constructeur

	public MaitreOeuvre(String nom, int siret, int telephone, String mail, String type, String numeroDeTva) {
		super(nom, siret, telephone, mail, type, numeroDeTva);
	}

	// Getters and Setters

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

}