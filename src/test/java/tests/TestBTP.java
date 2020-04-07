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
import btp.model.Action;
import btp.model.Facture;
import btp.model.Prestataire;
import btp.persistence.IActionDao;
import btp.persistence.IFactureDao;
import btp.persistence.IPrestataireDao;
import btp.persistence.ISalarieDao;
import btp.Application;
import btp.model.AppelOffre;
import btp.model.Etat;
import btp.model.MaitreOeuvre;
import btp.model.MaitreOuvrage;
import btp.model.Offre;
import btp.model.Utilisateur;
import btp.persistence.IAppelOffreDao;
import btp.persistence.IMaitreOeuvreDao;
import btp.persistence.IMaitreOuvrageDao;
import btp.persistence.IOffreDao;
import btp.persistence.IUtilisateurDao;

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

		IAppelOffreDao appelOffreDao = Application.getInstance().getAppelOffreDao();
		IMaitreOeuvreDao maitreOeuvreDao = Application.getInstance().getMaitreOeuvreDao();
		IMaitreOuvrageDao maitreOuvrageDao = Application.getInstance().getMaitreOuvrageDao();
		IOffreDao offreDao = Application.getInstance().getOffreDao();
		IUtilisateurDao utilisateurDao = Application.getInstance().getUtilisateurDao();


		AppelOffre appelOffre1 = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"), sdf.parse("15/12/2021"), false, null);
		AppelOffre appelOffre2 = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"), sdf.parse("15/12/2021"), true, 45000F);
		appelOffre1 = appelOffreDao.save(appelOffre1);
		appelOffre2 = appelOffreDao.save(appelOffre2);
		
		Utilisateur utilisateurbob = new Utilisateur("bob", "123456789");
		utilisateurbob = utilisateurDao.save(utilisateurbob);
		
		Utilisateur utilisateurtoto = new Utilisateur("toto", "azertyuiop");
		utilisateurtoto = utilisateurDao.save(utilisateurtoto);
		
		MaitreOeuvre bob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr", "354f435f41f");
		bob = maitreOeuvreDao.save(bob);
		
		MaitreOuvrage toto = new MaitreOuvrage("Toto", "4653413", "0618753492","totoMO@gmail.com","f6534r31e");
		toto = maitreOuvrageDao.save(toto);
	
		bob.setUtilisateur(utilisateurbob);
		toto.setUtilisateur(utilisateurtoto);
		
		bob = maitreOeuvreDao.save(bob);
		toto = maitreOuvrageDao.save(toto);
		
		appelOffre1.setMaitreOuvrage(toto);
		appelOffre1 = appelOffreDao.save(appelOffre1);
		
		Offre offre1 = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"));
		offre1 = offreDao.save(offre1);
		
		offre1.setEtat(Etat.clot);
	
		offre1.setMaitreOeuvre(bob);
		offre1.setMaitreOuvrage(toto);
		offre1.setAppelOffre(appelOffre1);
		
		offre1 = offreDao.save(offre1);
		
		
		
		
		
		
		IActionDao testAction = Application.getInstance().getActionDao();
		IFactureDao testFacture = Application.getInstance().getFactureDao();
		IPrestataireDao testPrestataire = Application.getInstance().getPrestataireDao();
//		ISalarieDao testSalarie = Application.getInstance().getSalarieDao();
		
		Prestataire colas = new Prestataire("Colas");
		colas = Application.getInstance().getPrestataireDao().save(colas);
		
		Action isolation = new Action("Isolation");
		isolation = Application.getInstance().getActionDao().save(isolation);
		isolation.setDescription("Laine de verre charpente");
		isolation = Application.getInstance().getActionDao().save(isolation);
		
		Facture factureIsolation = new Facture(111);
		factureIsolation =Application.getInstance().getFactureDao().save(factureIsolation);
		factureIsolation.setPrixHT(5000f);
		factureIsolation.setPrestataire(colas);
		factureIsolation =Application.getInstance().getFactureDao().save(factureIsolation);
		
		
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
