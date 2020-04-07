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

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("btp");
	
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

	public EntityManagerFactory getEmf() {
		return emf;
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
