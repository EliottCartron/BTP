package btp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import btp.persistence.IMaterielDao;
import btp.persistence.IPrestationDao;
import btp.persistence.IPrestationSupplementaireDao;
import btp.persistence.IProjetDao;
import btp.persistence.IReunionDao;
import btp.persistence.jpa.MaterielDaoJpa;
import btp.persistence.jpa.PrestationDaoJpa;
import btp.persistence.jpa.PrestationSupplementaireDaoJpa;
import btp.persistence.jpa.ProjetDaoJpa;
import btp.persistence.jpa.ReunionDaoJpa;

import btp.persistence.IAppelOffreDao;
import btp.persistence.IMaitreOeuvreDao;
import btp.persistence.IMaitreOuvrageDao;
import btp.persistence.IOffreDao;
import btp.persistence.IUtilisateurDao;
import btp.persistence.jpa.AppelOffreDaoJpa;
import btp.persistence.jpa.MaitreOeuvreDaoJpa;
import btp.persistence.jpa.MaitreOuvrageDaoJpa;
import btp.persistence.jpa.OffreDaoJpa;
import btp.persistence.jpa.UtilisateurDaoJpa;

import btp.persistence.IActionDao;
import btp.persistence.IFactureDao;
import btp.persistence.IPrestataireDao;
import btp.persistence.ISalarieDao;
import btp.persistence.jpa.ActionDaoJpa;
import btp.persistence.jpa.FactureDaoJpa;
import btp.persistence.jpa.PrestataireDaoJpa;
import btp.persistence.jpa.SalarieDaoJpa;



public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("btp");
	
	private final IAppelOffreDao appelOffreDao = new AppelOffreDaoJpa();
	private final IMaitreOeuvreDao maitreOeuvreDao = new MaitreOeuvreDaoJpa();
	private final IMaitreOuvrageDao maitreOuvrageDao = new MaitreOuvrageDaoJpa();
	private final IOffreDao offreDao = new OffreDaoJpa();
	private final IUtilisateurDao utilisateurDao = new UtilisateurDaoJpa();
	private final IActionDao actionDao = new ActionDaoJpa();
	private final IFactureDao factureDao = new FactureDaoJpa();
	private final IPrestataireDao prestataireDao = new PrestataireDaoJpa();
	private final ISalarieDao salarieDao = new SalarieDaoJpa();
	private final IProjetDao projetDao = new ProjetDaoJpa();
	private final IPrestationDao prestationDao = new PrestationDaoJpa();
	private final IPrestationSupplementaireDao prestationSupplementaireDao = new PrestationSupplementaireDaoJpa();
	private final IReunionDao reunionDao = new ReunionDaoJpa();
	private final IMaterielDao materielDao = new MaterielDaoJpa();

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
	public IAppelOffreDao getAppelOffreDao() {
		return appelOffreDao;
	}

	public IMaitreOeuvreDao getMaitreOeuvreDao() {
		return maitreOeuvreDao;
	}

	public IMaitreOuvrageDao getMaitreOuvrageDao() {
		return maitreOuvrageDao;
	}

	public IOffreDao getOffreDao() {
		return offreDao;
	}

	public IUtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public IActionDao getActionDao() {
		return actionDao;
	}

	public IFactureDao getFactureDao() {
		return factureDao;
	}

	public IPrestataireDao getPrestataireDao() {
		return prestataireDao;
	}

	public ISalarieDao getSalarieDao() {
		return salarieDao;
	}

	public IProjetDao getProjetDao() {
		return projetDao;
	}

	public IPrestationDao getPrestationDao() {
		return prestationDao;
	}

	public IPrestationSupplementaireDao getPrestationSupplementaireDao() {
		return prestationSupplementaireDao;
	}

	public IReunionDao getReunionDao() {
		return reunionDao;
	}

	public IMaterielDao getMaterielDao() {
		return materielDao;
	}
	
}
