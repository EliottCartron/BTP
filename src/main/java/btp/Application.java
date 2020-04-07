package btp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("btp");

	private final IAppelOffreDao appelOffreDao = new AppelOffreDaoJpa();
	private final IMaitreOeuvreDao maitreOeuvreDao = new MaitreOeuvreDaoJpa();
	private final IMaitreOuvrageDao maitreOuvrageDao = new MaitreOuvrageDaoJpa();
	private final IOffreDao offreDao = new OffreDaoJpa();
	private final IUtilisateurDao utilisateurDao = new UtilisateurDaoJpa();

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
}
