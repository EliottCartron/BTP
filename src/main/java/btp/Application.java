package btp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import btp.persistence.IMaterielRepository;
import btp.persistence.IPrestationRepository;
import btp.persistence.IPrestationSupplementaireRepository;
import btp.persistence.IProjetRepository;
import btp.persistence.IReunionRepository;
import btp.persistence.jpa.MaterielDaoJpa;
import btp.persistence.jpa.PrestationDaoJpa;
import btp.persistence.jpa.PrestationSupplementaireDaoJpa;
import btp.persistence.jpa.ProjetDaoJpa;
import btp.persistence.jpa.ReunionDaoJpa;

import btp.persistence.IAppelOffreRepository;
import btp.persistence.IMaitreOeuvreRepository;
import btp.persistence.IMaitreOuvrageRepository;
import btp.persistence.IOffreRepository;
import btp.persistence.IUtilisateurRepository;
import btp.persistence.jpa.AppelOffreDaoJpa;
import btp.persistence.jpa.MaitreOeuvreDaoJpa;
import btp.persistence.jpa.MaitreOuvrageDaoJpa;
import btp.persistence.jpa.OffreDaoJpa;
import btp.persistence.jpa.UtilisateurDaoJpa;

import btp.persistence.IActionDao;
import btp.persistence.IFactureRepository;
import btp.persistence.IPrestataireRepository;
import btp.persistence.ISalarieRepository;
import btp.persistence.jpa.ActionDaoJpa;
import btp.persistence.jpa.FactureDaoJpa;
import btp.persistence.jpa.PrestataireDaoJpa;
import btp.persistence.jpa.SalarieDaoJpa;



public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("btp");
	
	private final IAppelOffreRepository appelOffreDao = new AppelOffreDaoJpa();
	private final IMaitreOeuvreRepository maitreOeuvreDao = new MaitreOeuvreDaoJpa();
	private final IMaitreOuvrageRepository maitreOuvrageDao = new MaitreOuvrageDaoJpa();
	private final IOffreRepository offreDao = new OffreDaoJpa();
	private final IUtilisateurRepository utilisateurDao = new UtilisateurDaoJpa();
	private final IActionDao actionDao = new ActionDaoJpa();
	private final IFactureRepository factureDao = new FactureDaoJpa();
	private final IPrestataireRepository prestataireDao = new PrestataireDaoJpa();
	private final ISalarieRepository salarieDao = new SalarieDaoJpa();
	private final IProjetRepository projetDao = new ProjetDaoJpa();
	private final IPrestationRepository prestationDao = new PrestationDaoJpa();
	private final IPrestationSupplementaireRepository prestationSupplementaireDao = new PrestationSupplementaireDaoJpa();
	private final IReunionRepository reunionDao = new ReunionDaoJpa();
	private final IMaterielRepository materielDao = new MaterielDaoJpa();

	private Application() {
	}
	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}
	public static void setInstance(Application instance) {
		Application.instance = instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
	public IAppelOffreRepository getAppelOffreDao() {
		return appelOffreDao;
	}

	public IMaitreOeuvreRepository getMaitreOeuvreDao() {
		return maitreOeuvreDao;
	}

	public IMaitreOuvrageRepository getMaitreOuvrageDao() {
		return maitreOuvrageDao;
	}

	public IOffreRepository getOffreDao() {
		return offreDao;
	}

	public IUtilisateurRepository getUtilisateurDao() {
		return utilisateurDao;
	}

	public IActionDao getActionDao() {
		return actionDao;
	}

	public IFactureRepository getFactureDao() {
		return factureDao;
	}

	public IPrestataireRepository getPrestataireDao() {
		return prestataireDao;
	}

	public ISalarieRepository getSalarieDao() {
		return salarieDao;
	}

	public IProjetRepository getProjetDao() {
		return projetDao;
	}

	public IPrestationRepository getPrestationDao() {
		return prestationDao;
	}

	public IPrestationSupplementaireRepository getPrestationSupplementaireDao() {
		return prestationSupplementaireDao;
	}

	public IReunionRepository getReunionDao() {
		return reunionDao;
	}

	public IMaterielRepository getMaterielDao() {
		return materielDao;
	}
	
}
