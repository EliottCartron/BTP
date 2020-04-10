package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import btp.model.MaitreOeuvre;
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
	private IFactureRepository factureRepository ;
	@Autowired
	private IMaitreOeuvreRepository maitreOeuvreRepository;
	@Autowired
	private IMaitreOuvrageRepository maitreOuvrageRepository;
	@Autowired
	private IMaterielRepository materielRepository ;
	@Autowired
	private IOffreRepository offreRepository ;
	@Autowired
	private IPrestataireRepository prestataireRepository;
	@Autowired
	private IPrestationRepository prestationRepository;
	@Autowired
	private IPrestationSupplementaireRepository prestationSupplementaireRepository ;
	@Autowired
	private IProjetRepository projetRepository ;
	@Autowired
	private IReunionRepository reunionRepository ;
	@Autowired
	private ISalarieRepository salarieRepository;
	@Autowired
	private IUtilisateurRepository utilisateurRepository;
	
	@Test
	public void action() {
		
	}
	
	@Test
	public void appelOffre() {
		
	}
	
	@Test
	public void facture() {
		
	}
	
	@Test
	public void maitreOeuvre() {
		MaitreOeuvre maitreOeuvre = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr", "354f435f41f");
		maitreOeuvre = maitreOeuvreRepository.save(maitreOeuvre);
	}
	
	@Test
	public void maitreOuvrage() {
		
	}
	
	@Test
	public void materiel() {
		
	}
	
	@Test
	public void offre() {
		
	}
	
	@Test
	public void prestataire() {
		
	}
	
	@Test
	public void prestation() {
		
	}
	
	@Test
	public void prestationSupplementaire() {
		
	}
	
	@Test
	public void projet() {
		
	}
	
	@Test
	public void reunion() {
		
	}
	
	@Test
	public void salarie() {
		
	}
	
	@Test
	public void utilisateur() {
		
	}
}
