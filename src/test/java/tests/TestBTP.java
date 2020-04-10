package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import btp.model.Action;
import btp.model.AppelOffre;
import btp.model.Categorie;
import btp.model.Etat;
import btp.model.Facture;
import btp.model.MaitreOeuvre;
import btp.model.MaitreOuvrage;
import btp.model.Materiel;
import btp.model.Offre;
import btp.model.Prestataire;
import btp.model.Prestation;
import btp.model.PrestationSupplementaire;
import btp.model.Projet;
import btp.model.Reunion;
import btp.model.Unite;
import btp.model.Utilisateur;
import btp.persistence.IActionRepository;
import btp.persistence.IAppelOffreRepository;
import btp.persistence.IFactureRepository;
import btp.persistence.IMaitreOeuvreRepository;
import btp.persistence.IMaitreOuvrageRepository;
import btp.persistence.IMaterielRepository;
import btp.persistence.IOffreRepository;
import btp.persistence.IPrestataireRepository;
import btp.persistence.IPrestationRepository;
import btp.persistence.IPrestationSupplementaireRepository;
import btp.persistence.IProjetRepository;
import btp.persistence.IReunionRepository;
import btp.persistence.ISalarieRepository;
import btp.persistence.IUtilisateurRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBTP {

	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		Reunion reu1 = new Reunion("mise en place", 1, sdf.parse("08/04/2020"));
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		Materiel rouleauCompresseur = new Materiel("Rouleau Compresseur", 1f, Unite.unite);
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000f, sdf.parse("10/04/2020"),
				sdf.parse("10/05/2020"), false);
		PrestationSupplementaire supp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement", 2000f,
				sdf.parse("10/04/2020"), sdf.parse("12/04/2020"));

		IAppelOffreRepository appelOffreDao = context.getBean(IAppelOffreRepository.class);
		IMaitreOeuvreRepository maitreOeuvreDao = context.getBean(IMaitreOeuvreRepository.class);
		IMaitreOuvrageRepository maitreOuvrageDao = context.getBean(IMaitreOuvrageRepository.class);
		IOffreRepository offreDao = context.getBean(IOffreRepository.class);
		IUtilisateurRepository utilisateurDao = context.getBean(IUtilisateurRepository.class);
		IProjetRepository projetDao = context.getBean(IProjetRepository.class);
		IActionRepository actionDao = context.getBean(IActionRepository.class);
		IFactureRepository factureDao = context.getBean(IFactureRepository.class);
		IPrestataireRepository prestataireDao = context.getBean(IPrestataireRepository.class);
		ISalarieRepository testSalarie = context.getBean(ISalarieRepository.class);
		IReunionRepository reunionDao = context.getBean(IReunionRepository.class);
		IMaterielRepository materielDao = context.getBean(IMaterielRepository.class);
		IPrestationRepository prestationDao = context.getBean(IPrestationRepository.class);
		IPrestationSupplementaireRepository prestationSupplementaireDao = context.getBean(IPrestationSupplementaireRepository.class);

		projet1 = projetDao.save(projet1);
		reu1 = reunionDao.save(reu1);
		sable = materielDao.save(sable);
		rouleauCompresseur = materielDao.save(rouleauCompresseur);
		presta1 = prestationDao.save(presta1);
		supp1 = prestationSupplementaireDao.save(supp1);

		AppelOffre appelOffre1 = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"),
				sdf.parse("15/12/2021"), false, null);
		AppelOffre appelOffre2 = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"),
				sdf.parse("15/12/2021"), true, 45000F);
		appelOffre1 = appelOffreDao.save(appelOffre1);
		appelOffre2 = appelOffreDao.save(appelOffre2);

		Utilisateur utilisateurbob = new Utilisateur("bob", "123456789");
		utilisateurbob = utilisateurDao.save(utilisateurbob);

		Utilisateur utilisateurtoto = new Utilisateur("toto", "azertyuiop");
		utilisateurtoto = utilisateurDao.save(utilisateurtoto);

		MaitreOeuvre bob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr",
				"354f435f41f");
		bob = maitreOeuvreDao.save(bob);

		MaitreOuvrage toto = new MaitreOuvrage("Toto", "4653413", "0618753492", "totoMO@gmail.com", "f6534r31e");
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
		Prestataire colas = new Prestataire();
		colas = prestataireDao.save(colas);

		Action isolation = new Action("Isolation");
		isolation = actionDao.save(isolation);
		isolation.setDescription("Laine de verre charpente");
		isolation = actionDao.save(isolation);

		Facture factureIsolation = new Facture(111);
		factureIsolation = factureDao.save(factureIsolation);
		factureIsolation.setPrixHT(5000f);
		factureIsolation.setPrestataire(colas);
		factureIsolation = factureDao.save(factureIsolation);

		presta1.addMateriels(sable);
		presta1.setProjet(projet1);

		presta1 = prestationDao.save(presta1);

		supp1.addMateriels(rouleauCompresseur);
		supp1.setPrestation(presta1);
		supp1.setProjet(projet1);

		supp1 = prestationSupplementaireDao.save(supp1);

		reu1.setProjet(projet1);

		reu1 = reunionDao.save(reu1);

	}

}
