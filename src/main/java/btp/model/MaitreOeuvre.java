package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("MOeuvre")
public class MaitreOeuvre extends Societe {
	@OneToMany(mappedBy = "maitreOeuvre")
	private List<Offre> offres = new ArrayList<Offre>();

//	@OneToOne
//	private Facture facture;

	// Constructeur
	
	public MaitreOeuvre() {
		super();
	}
	
	public MaitreOeuvre(String nom, String siret, String telephone, String mail, String numeroDeTva) {
		super(nom, siret, telephone, mail, numeroDeTva);
	}

	// Getters and Setters

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

//	public Facture getFacture() {
//		return facture;
//	}
//
//	public void setFacture(Facture facture) {
//		this.facture = facture;
//	}

}