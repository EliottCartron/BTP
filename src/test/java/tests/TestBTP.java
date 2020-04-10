package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import btp.model.AppelOffre;
import btp.model.MaitreOeuvre;
import btp.persistence.IAppelOffreRepository;
import btp.persistence.IMaitreOeuvreRepository;

public class TestBTP {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
//		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
//		Reunion reu1 = new Reunion("mise en place", 1, sdf.parse("08/04/2020"));
//		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
//		Materiel rouleauCompresseur = new Materiel("Rouleau Compresseur", 1f, Unite.unite);
//		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000f, sdf.parse("10/04/2020"), sdf.parse("10/05/2020"), false);
//		PrestationSupplementaire supp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement", 2000f, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"));
//		
//		projet1 = Application.getInstance().getProjetDao().save(projet1);
//		reu1 = Application.getInstance().getReunionDao().save(reu1);
//		sable = Application.getInstance().getMaterielDao().save(sable);
//		rouleauCompresseur = Application.getInstance().getMaterielDao().save(rouleauCompresseur);
//		presta1 = Application.getInstance().getPrestationDao().save(presta1);
//		supp1 = Application.getInstance().getPrestationSupplementaireDao().save(supp1);
//
//		IAppelOffreRepository appelOffreDao = Application.getInstance().getAppelOffreDao();
//		IMaitreOeuvreRepository maitreOeuvreDao = Application.getInstance().getMaitreOeuvreDao();
//		IMaitreOuvrageRepository maitreOuvrageDao = Application.getInstance().getMaitreOuvrageDao();
//		IOffreRepository offreDao = Application.getInstance().getOffreDao();
//		IUtilisateurRepository utilisateurDao = Application.getInstance().getUtilisateurDao();
//
//
//		AppelOffre appelOffre1 = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"), sdf.parse("15/12/2021"), false, null);
//		AppelOffre appelOffre2 = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"), sdf.parse("15/12/2021"), true, 45000F);
//		appelOffre1 = appelOffreDao.save(appelOffre1);
//		appelOffre2 = appelOffreDao.save(appelOffre2);
//		
//		Utilisateur utilisateurbob = new Utilisateur("bob", "123456789");
//		utilisateurbob = utilisateurDao.save(utilisateurbob);
//		
//		Utilisateur utilisateurtoto = new Utilisateur("toto", "azertyuiop");
//		utilisateurtoto = utilisateurDao.save(utilisateurtoto);
//		
//		MaitreOeuvre bob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr", "354f435f41f");
//		bob = maitreOeuvreDao.save(bob);
//		
//		MaitreOuvrage toto = new MaitreOuvrage("Toto", "4653413", "0618753492","totoMO@gmail.com","f6534r31e");
//		toto = maitreOuvrageDao.save(toto);
//	
//		bob.setUtilisateur(utilisateurbob);
//		toto.setUtilisateur(utilisateurtoto);
//		
//		bob = maitreOeuvreDao.save(bob);
//		toto = maitreOuvrageDao.save(toto);
//		
//		appelOffre1.setMaitreOuvrage(toto);
//		appelOffre1 = appelOffreDao.save(appelOffre1);
//		
//		Offre offre1 = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"));
//		offre1 = offreDao.save(offre1);
//		
//		offre1.setEtat(Etat.clot);
//	
//		offre1.setMaitreOeuvre(bob);
//		offre1.setMaitreOuvrage(toto);
//		offre1.setAppelOffre(appelOffre1);
//		
//		offre1 = offreDao.save(offre1);		
//		
//		IActionDao testAction = Application.getInstance().getActionDao();
//		IFactureRepository testFacture = Application.getInstance().getFactureDao();
//		IPrestataireRepository testPrestataire = Application.getInstance().getPrestataireDao();
//		ISalarieRepository testSalarie = Application.getInstance().getSalarieDao();
//		
//		Prestataire colas = new Prestataire();
//		colas = Application.getInstance().getPrestataireDao().save(colas);
//		
//		Action isolation = new Action("Isolation");
//		isolation = Application.getInstance().getActionDao().save(isolation);
//		isolation.setDescription("Laine de verre charpente");
//		isolation = Application.getInstance().getActionDao().save(isolation);
//		
//		Facture factureIsolation = new Facture(111);
//		factureIsolation =Application.getInstance().getFactureDao().save(factureIsolation);
//		factureIsolation.setPrixHT(5000f);
//		factureIsolation.setPrestataire(colas);
//		factureIsolation =Application.getInstance().getFactureDao().save(factureIsolation);
//		
//		
//		presta1.addMateriels(sable);
//		presta1.setProjet(projet1);
//		
//		presta1 = Application.getInstance().getPrestationDao().save(presta1);
//
//		supp1.addMateriels(rouleauCompresseur);
//		supp1.setPrestation(presta1);
//		supp1.setProjet(projet1);
//		
//		supp1 = Application.getInstance().getPrestationSupplementaireDao().save(supp1);
//		
//		reu1.setProjet(projet1);
//		
//		reu1 = Application.getInstance().getReunionDao().save(reu1);
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		IMaitreOeuvreRepository moeuvreDao = context.getBean(IMaitreOeuvreRepository.class);
		
		IAppelOffreRepository appelOffreDao = context.getBean(IAppelOffreRepository.class);
		
//		MaitreOeuvre bob2 = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr", "354f435f41f");
//		bob2 = moeuvreDao.save(bob2);
		
		try {
		MaitreOeuvre bob3 = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr", "354f435f41f");
		bob3 = moeuvreDao.save(bob3);
		}catch(DataIntegrityViolationException c) {
			System.out.println("adresse mail déjà utilisée");
		}
		
		
//		AppelOffre appelOffre1 = new AppelOffre("blablabla", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"), sdf.parse("15/12/2021"), false, null);
//		appelOffre1 = appelOffreDao.save(appelOffre1);
		
		
		context.close();
		
	}

}
