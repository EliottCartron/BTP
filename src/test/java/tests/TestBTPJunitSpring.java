package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import btp.model.Action;
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
import btp.model.Salarie;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
//@ContextConfiguration(classes = ApplicationConfig.class)
public class TestBtpJunitSpring {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private IActionRepository actionDao;

	@Autowired
	private IAppelOffreRepository appelOffreDao;

	@Autowired
	private IFactureRepository factureDao;

	@Autowired
	private IMaitreOeuvreRepository maitreOeuvreDao;
	
	@Autowired
	private IMaitreOuvrageRepository maitreOuvrageDao;
	
	@Autowired
	private IMaterielRepository materielDao;
	
	@Autowired
	private IOffreRepository offreDao;
	
	@Autowired
	private IPrestataireRepository prestataireDao;
	
	@Autowired
	private IPrestationRepository prestationDao;
	
	@Autowired
	private IPrestationSupplementaireRepository prestationSupplementaireDao;
	
	@Autowired
	private IProjetRepository projetDao;
	
	@Autowired
	private IReunionRepository reunionDao;
	
	@Autowired
	private ISalarieRepository salarieDao;
	
	@Autowired
	private IUtilisateurRepository utilisateurDao;
	
	@Test
	public void prestataire() throws ParseException {
		
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		sable = materielDao.save(sable);
		
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000f, sdf.parse("10/04/2020"), sdf.parse("10/05/2020"), false);
		presta1 = prestationDao.save(presta1);
		
		PrestationSupplementaire supp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement", 2000f, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"));
		supp1 = prestationSupplementaireDao.save(supp1);
		
		Facture factureIsolation = new Facture(111);
		factureIsolation.setPrixHT(5000f);
		factureIsolation = factureDao.save(factureIsolation);
		
		Salarie jeanLouis = new Salarie ("DUCHMON", "Jean-Louis", "Cariste");
		jeanLouis = salarieDao.save(jeanLouis);
		
		Action isolation = new Action("Isolation");
		isolation = actionDao.save(isolation);
		
		Prestataire colas = new Prestataire("COLAS");
		
		colas.addActions(isolation);
		colas.addFactures(factureIsolation);
		colas.addMateriel(sable);
		colas.addPrestation(presta1);
		colas.addPrestationSupplementaires(supp1);
		colas.addSalarie(jeanLouis);
		
		colas = prestataireDao.save(colas);
		
	}
	
	@Test
	public void prestation() throws ParseException {
		
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		projet1 = projetDao.save(projet1);
		
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		sable = materielDao.save(sable);
		
		Offre offre1 = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"),Etat.clot);
		offre1 = offreDao.save(offre1);
		
		Prestataire colas = new Prestataire("COLAS");
		colas = prestataireDao.save(colas);
		
		Salarie jeanLouis = new Salarie ("DUCHMON", "Jean-Louis", "Cariste");
		jeanLouis = salarieDao.save(jeanLouis);
		
		Facture factureIsolation = new Facture(111);
		factureIsolation.setPrixHT(5000f);
		factureIsolation = factureDao.save(factureIsolation);
		
		PrestationSupplementaire supp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement", 2000f, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"));
		supp1 = prestationSupplementaireDao.save(supp1);
		
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000f, sdf.parse("10/04/2020"), sdf.parse("10/05/2020"), false);
		
		presta1.addMateriels(sable);
		presta1.setProjet(projet1);
		presta1.setOffre(offre1);
		presta1.setPrestataire(colas);
		presta1.addSalaries(jeanLouis);
		presta1.setFacture(factureIsolation);
		presta1.setPrestationSupplementaire(supp1);	
		
		
		presta1 = prestationDao.save(presta1);
	}
	
	@Test
	public void prestationSupplementaire() throws ParseException {
		
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		projet1 = projetDao.save(projet1);
		
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		sable = materielDao.save(sable);
		
		Prestataire colas = new Prestataire("COLAS");
		colas = prestataireDao.save(colas);
		
		Salarie jeanLouis = new Salarie ("DUCHMON", "Jean-Louis", "Cariste");
		jeanLouis = salarieDao.save(jeanLouis);
		
		Facture factureIsolation = new Facture(111);
		factureIsolation.setPrixHT(5000f);
		factureIsolation = factureDao.save(factureIsolation);
		
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000f, sdf.parse("10/04/2020"), sdf.parse("10/05/2020"), false);
		presta1 = prestationDao.save(presta1);
		
		PrestationSupplementaire supp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement", 2000f, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"));
		
		supp1.addMateriels(sable);
		supp1.setProjet(projet1);
		supp1.setPrestataire(colas);
		supp1.addSalaries(jeanLouis);
		supp1.setFacture(factureIsolation);
		supp1.setPrestation(presta1);
			
		supp1 = prestationSupplementaireDao.save(supp1);
		
	}

	@Test
	public void projet() throws ParseException {
		
		Reunion reu1 = new Reunion("mise en place", 1, sdf.parse("08/04/2020"));
		reu1 = reunionDao.save(reu1);
		
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000f, sdf.parse("10/04/2020"), sdf.parse("10/05/2020"), false);
		presta1 = prestationDao.save(presta1);
		
		PrestationSupplementaire supp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement", 2000f, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"));
		supp1 = prestationSupplementaireDao.save(supp1);
		
		Facture factureIsolation = new Facture(111);
		factureIsolation.setPrixHT(5000f);
		factureIsolation = factureDao.save(factureIsolation);
		
		Offre offre1 = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"),Etat.clot);
		offre1 = offreDao.save(offre1);
		
		Action isolation = new Action("Isolation");
		isolation = actionDao.save(isolation);
		
		
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		projet1.addPrestation(presta1);
		projet1.addPrestationSupplementaires(supp1);
		projet1.addReunions(reu1);
		projet1.addActions(isolation);
		projet1.setFacture(factureIsolation);
		projet1.setOffre(offre1);
		
		projet1 = projetDao.save(projet1);
		
	}
	
	@Test
	public void reunion() throws ParseException {	
	
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");		
		projet1 = projetDao.save(projet1);
		
		Reunion reu1 = new Reunion("mise en place", 1, sdf.parse("08/04/2020"));
		
		reu1.setProjet(projet1);
		
		reu1 = reunionDao.save(reu1);
		
	}
	
	@Test
	public void salarie() throws ParseException {	
	
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000f, sdf.parse("10/04/2020"), sdf.parse("10/05/2020"), false);
		presta1 = prestationDao.save(presta1);
		
		PrestationSupplementaire supp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement", 2000f, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"));
		supp1 = prestationSupplementaireDao.save(supp1);
		
		Prestataire colas = new Prestataire("COLAS");
		colas = prestataireDao.save(colas);
		
		Action isolation = new Action("Isolation");
		isolation = actionDao.save(isolation);
		
		Salarie jeanLouis = new Salarie ("DUCHMON", "Jean-Louis", "Cariste");
		
		jeanLouis.addPrestation(presta1);
		jeanLouis.addPrestationSupplementaires(supp1);
		jeanLouis.addActions(isolation);
		jeanLouis.setPrestataire(colas);		
		
		jeanLouis = salarieDao.save(jeanLouis);
		
	}
	
	@Test
	public void utilisateur() throws ParseException {
		
		MaitreOeuvre bob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr", "354f435f41f");
		bob = maitreOeuvreDao.save(bob);
	
		Utilisateur utilisateurbob = new Utilisateur("bob", "123456789");
		
		utilisateurbob.setSociete(bob);
		
		utilisateurbob = utilisateurDao.save(utilisateurbob);
		
	}

}
