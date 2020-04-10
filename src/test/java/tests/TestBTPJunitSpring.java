package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import btp.model.Action;
import btp.model.Adresse;
import btp.model.AppelOffre;
import btp.model.Etat;
import btp.model.Facture;
import btp.model.MaitreOeuvre;
import btp.model.MaitreOuvrage;
import btp.model.Materiel;
import btp.model.Offre;
import btp.model.Prestataire;
import btp.model.Unite;
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
public class TestBTPJunitSpring {

	@Autowired
	private IActionRepository actionRepository;
	@Autowired
	private IAppelOffreRepository appelOffreRepository;
	@Autowired
	private IFactureRepository factureRepository;
	@Autowired
	private IMaitreOeuvreRepository maitreOeuvreRepository;
	@Autowired
	private IMaitreOuvrageRepository maitreOuvrageRepository;
	@Autowired
	private IMaterielRepository materielRepository;
	@Autowired
	private IOffreRepository offreRepository;
	@Autowired
	private IPrestataireRepository prestataireRepository;
	@Autowired
	private IPrestationRepository prestationRepository;
	@Autowired
	private IPrestationSupplementaireRepository prestationSupplementaireRepository;
	@Autowired
	private IProjetRepository projetRepository;
	@Autowired
	private IReunionRepository reunionRepository;
	@Autowired
	private ISalarieRepository salarieRepository;
	@Autowired
	private IUtilisateurRepository utilisateurRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void action() throws ParseException {
		Action isolation = new Action("Isolation", sdf.parse("12/04/2020"), sdf.parse("15/05/2020"),
				"Laine de verre charpente", false);
		Action cloture = new Action("Clôture", sdf.parse("15/07/2020"), sdf.parse("25/07/2020"), "Réparer clôture",
				true);

		isolation = actionRepository.save(isolation);
		cloture = actionRepository.save(cloture);
	}

	@Test
	public void appelOffre() throws ParseException {
		// appel offre
		AppelOffre appelOffreMaison = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"),
				sdf.parse("15/12/2021"), false, null);
		AppelOffre appelOffreImmeuble = new AppelOffre("immeuble", 65000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"),
				sdf.parse("15/12/2021"), true, 45000F);
		
		appelOffreImmeuble.setAdresse(new Adresse("18 Avenue JFK",null,"33700","Mérignac"));
		appelOffreMaison.setAdresse(new Adresse("35 Boulevard JFK", null, "33000", "Bordeaux"));
		
		// maitre d'ouvrage
		MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Toto", "4653413", "0618753492", "toto@maitredouvrage.fr", "f6534r31e");
		MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Bobby", "1675923", "0679315862", "bobby@maitredouvrage.fr", "f23s5642fq12s674");

		maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
		maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);
		
		// lien appel d'offre - maitre d'ouvrage
		appelOffreMaison.setMaitreOuvrage(maitreOuvrageToto);
		appelOffreImmeuble.setMaitreOuvrage(maitreOuvrageBobby);

		appelOffreMaison = appelOffreRepository.save(appelOffreMaison);
		appelOffreImmeuble = appelOffreRepository.save(appelOffreImmeuble);
	}

	@Test
	public void facture() throws ParseException {
		// facture
		Facture factureIsolation = new Facture(111, sdf.parse("15/05/2020"), 5000F, 0F,sdf.parse("15/06/2020"),0F);
		Facture factureCloture = new Facture(45, sdf.parse("18/01/2021"), 5000F, 15F,sdf.parse("21/02/2022"),52F);
		
		// maitre d'oeuvre
		MaitreOeuvre maitreOeuvreBob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr",
				"354f435f41f");
		MaitreOeuvre maitreOeuvreGeorges = new MaitreOeuvre("Georges", "16793458", "0734159382", "georges@maitredoeuvre.fr",
				"531p5v7q26846s");
		
		maitreOeuvreBob = maitreOeuvreRepository.save(maitreOeuvreBob);
		maitreOeuvreGeorges = maitreOeuvreRepository.save(maitreOeuvreGeorges);
		
		// maitre d'ouvrage
		MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Toto", "4653413", "0618753492", "toto@maitredouvrage.fr", "f6534r31e");
		MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Bobby", "1675923", "0679315862", "bobby@maitredouvrage.fr", "f23s5642fq12s674");

		maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
		maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);
		
		// liens facture - maitre d'oeuvre / maitre d'ouvrage
		factureIsolation.setMaitreOeuvre(maitreOeuvreBob);
		factureIsolation.setMaitreOuvrage(maitreOuvrageBobby);
		factureCloture.setMaitreOeuvre(maitreOeuvreGeorges);
		factureCloture.setMaitreOuvrage(maitreOuvrageToto);
		
		factureIsolation = factureRepository.save(factureIsolation);
		factureCloture = factureRepository.save(factureCloture);
	}

	@Test
	public void maitreOeuvre() {
		MaitreOeuvre maitreOeuvreBob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr",
				"354f435f41f");
		MaitreOeuvre maitreOeuvreGeorges = new MaitreOeuvre("Georges", "16793458", "0734159382", "georges@maitredoeuvre.fr",
				"531p5v7q26846s");
		
		maitreOeuvreBob = maitreOeuvreRepository.save(maitreOeuvreBob);
		maitreOeuvreGeorges = maitreOeuvreRepository.save(maitreOeuvreGeorges);
	}

	@Test
	public void maitreOuvrage() {
		MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Toto", "4653413", "0618753492", "toto@maitredouvrage.fr", "f6534r31e");
		MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Bobby", "1675923", "0679315862", "bobby@maitredouvrage.fr", "f23s5642fq12s674");

		maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
		maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);
	}

	@Test
	public void materiel() {
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		Materiel grillage = new Materiel("Grillage", 18F, Unite.metreLineaire);
		Materiel rouleauCompresseur = new Materiel("Rouleau Compresseur", 1f, Unite.unite);
		
		sable = materielRepository.save(sable);
		grillage = materielRepository.save(grillage);
		rouleauCompresseur = materielRepository.save(rouleauCompresseur);
	}

	@Test
	public void offre() throws ParseException {
		// offre
		Offre offreToto = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"), Etat.consult);
		Offre offreBobby = new Offre(32000F, 12, sdf.parse("08/08/2020"), sdf.parse("09/12/2024"), Etat.val);
		
		// maitre d'oeuvre
		MaitreOeuvre maitreOeuvreBob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr",
				"354f435f41f");
		MaitreOeuvre maitreOeuvreGeorges = new MaitreOeuvre("Georges", "16793458", "0734159382", "georges@maitredoeuvre.fr",
				"531p5v7q26846s");
		
		maitreOeuvreBob = maitreOeuvreRepository.save(maitreOeuvreBob);
		maitreOeuvreGeorges = maitreOeuvreRepository.save(maitreOeuvreGeorges);
		
		// maitre d'ouvrage
		MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Toto", "4653413", "0618753492", "toto@maitredouvrage.fr", "f6534r31e");
		MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Bobby", "1675923", "0679315862", "bobby@maitredouvrage.fr", "f23s5642fq12s674");

		maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
		maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);
		
		// appel d'offre
		AppelOffre appelOffreMaison = new AppelOffre("maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"),
				sdf.parse("15/12/2021"), false, null);
		AppelOffre appelOffreImmeuble = new AppelOffre("immeuble", 65000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"),
				sdf.parse("15/12/2021"), true, 45000F);
		
		appelOffreImmeuble.setAdresse(new Adresse("18 Avenue JFK",null,"33700","Mérignac"));
		appelOffreMaison.setAdresse(new Adresse("35 Boulevard JFK", null, "33000", "Bordeaux"));
		
		appelOffreMaison = appelOffreRepository.save(appelOffreMaison);
		appelOffreImmeuble = appelOffreRepository.save(appelOffreImmeuble);
		
		// liens offre - maitre d'oeuvre / maitre d'ouvrage / appel d'offre
		offreToto.setMaitreOeuvre(maitreOeuvreGeorges);
		offreBobby.setMaitreOeuvre(maitreOeuvreBob);
		offreToto.setMaitreOuvrage(maitreOuvrageToto);
		offreBobby.setMaitreOuvrage(maitreOuvrageBobby);
		offreToto.setAppelOffre(appelOffreMaison);
		offreBobby.setAppelOffre(appelOffreImmeuble);
		
		offreToto = offreRepository.save(offreToto);
		offreBobby = offreRepository.save(offreBobby);
	}

//	
//	@Test
//	public void prestataire() {
//		Prestataire colas = new Prestataire();
//	}
//	
//	@Test
//	public void prestation() {
//		
//	}
//	
//	@Test
//	public void prestationSupplementaire() {
//		
//	}
//	
//	@Test
//	public void projet() {
//		
//	}
//	
//	@Test
//	public void reunion() {
//		
//	}
//	
//	@Test
//	public void salarie() {
//		
//	}
//	
//	@Test
//	public void utilisateur() {
//		
//	}
}
