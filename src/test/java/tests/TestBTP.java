package tests;

import btp.Application;
import btp.model.Action;
import btp.model.Facture;
import btp.model.Prestataire;
import btp.persistence.IActionDao;
import btp.persistence.IFactureDao;
import btp.persistence.IPrestataireDao;
import btp.persistence.ISalarieDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import btp.Application;
import btp.model.AppelOffre;
import btp.model.MaitreOeuvre;
import btp.model.Utilisateur;
import btp.persistence.IAppelOffreDao;
import btp.persistence.IMaitreOeuvreDao;
import btp.persistence.IMaitreOuvrageDao;
import btp.persistence.IOffreDao;
import btp.persistence.IUtilisateurDao;

public class TestBTP {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		IAppelOffreDao appelOffreDao = Application.getInstance().getAppelOffreDao();
		IMaitreOeuvreDao maitreOeuvreDao = Application.getInstance().getMaitreOeuvreDao();
		IMaitreOuvrageDao maitreOuvrageDao = Application.getInstance().getMaitreOuvrageDao();
		IOffreDao offreDao = Application.getInstance().getOffreDao();
		IUtilisateurDao utilisateurDao = Application.getInstance().getUtilisateurDao();


		AppelOffre appelOffre1 = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"), sdf.parse("15/12/2021"), false, null);
		AppelOffre appelOffre2 = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"), sdf.parse("15/12/2021"), true, 45000F);
		appelOffre1 = appelOffreDao.save(appelOffre1);
		appelOffre2 = appelOffreDao.save(appelOffre2);
		
		Utilisateur utilisateur = new Utilisateur("aaa", "123456789");
		utilisateur = utilisateurDao.save(utilisateur);
		
		MaitreOeuvre bob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr", "354f435f41f");
		bob = maitreOeuvreDao.save(bob);
		
		
	
		
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
		
		
	}

}
