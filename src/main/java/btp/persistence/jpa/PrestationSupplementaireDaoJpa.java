package btp.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import btp.Application;
import btp.model.PrestationSupplementaire;
import btp.persistence.IPrestationSupplementaireDao;

public class PrestationSupplementaireDaoJpa implements IPrestationSupplementaireDao{
	@Override
	public List<PrestationSupplementaire> findAll() {
		List<PrestationSupplementaire> prestationSupplementaires = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<PrestationSupplementaire> query = em.createQuery("from PrestationSupplementaire", PrestationSupplementaire.class);

			prestationSupplementaires = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return prestationSupplementaires;
	}

	@Override
	public PrestationSupplementaire find(Long id) {
		PrestationSupplementaire prestationSupplementaire = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			prestationSupplementaire = em.find(PrestationSupplementaire.class, id);

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return prestationSupplementaire;
	}

	@Override
	public PrestationSupplementaire save(PrestationSupplementaire obj) {
		PrestationSupplementaire prestationSupplementaire = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			prestationSupplementaire = em.merge(obj);

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return prestationSupplementaire;
	}

	@Override
	public void delete(PrestationSupplementaire obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			em.remove(em.merge(obj));

			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
