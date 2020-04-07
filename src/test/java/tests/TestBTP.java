package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import btp.Application;
import btp.model.Categorie;
import btp.model.Materiel;
import btp.model.Prestation;
import btp.model.PrestationSupplementaire;
import btp.model.Projet;
import btp.model.Reunion;
import btp.model.Unite;

public class TestBTP {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		Reunion reu1 = new Reunion("mise en place", 1, sdf.parse("08/04/2020"));
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		Materiel rouleauCompresseur = new Materiel("Rouleau Compresseur", 1f, Unite.unite);
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000f, sdf.parse("10/04/2020"), sdf.parse("10/05/2020"), false);
		PrestationSupplementaire supp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement", 2000f, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"));
		
		projet1 = Application.getInstance().getProjetDao().save(projet1);
		reu1 = Application.getInstance().getReunionDao().save(reu1);
		sable = Application.getInstance().getMaterielDao().save(sable);
		rouleauCompresseur = Application.getInstance().getMaterielDao().save(rouleauCompresseur);
		presta1 = Application.getInstance().getPrestationDao().save(presta1);
		supp1 = Application.getInstance().getPrestationSupplementaireDao().save(supp1);

		presta1.addMateriels(sable);
		presta1.setProjet(projet1);
		
		presta1 = Application.getInstance().getPrestationDao().save(presta1);

		supp1.addMateriels(rouleauCompresseur);
		supp1.setPrestation(presta1);
		supp1.setProjet(projet1);
		
		supp1 = Application.getInstance().getPrestationSupplementaireDao().save(supp1);
		
		reu1.setProjet(projet1);
		
		reu1 = Application.getInstance().getReunionDao().save(reu1);

		
	}

}
