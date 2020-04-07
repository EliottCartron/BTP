package btp.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import btp.Application;
import btp.model.MaitreOuvrage;
import btp.persistence.IMaitreOuvrageDao;

public class MaitreOuvrageDaoJpa implements IMaitreOuvrageDao {

	@Override
	public List<MaitreOuvrage> findAll() {
		List<MaitreOuvrage> maitreOuvrages = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<MaitreOuvrage> query = em.createQuery("from MaitreOuvrage", MaitreOuvrage.class);

			maitreOuvrages = query.getResultList();

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

		return maitreOuvrages;
	}

	@Override
	public MaitreOuvrage find(Long id) {
		MaitreOuvrage maitreOuvrage = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			maitreOuvrage = em.find(MaitreOuvrage.class, id);

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

		return maitreOuvrage;
	}

	@Override
	public MaitreOuvrage save(MaitreOuvrage obj) {
		MaitreOuvrage maitreOuvrage = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			maitreOuvrage = em.merge(obj);

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

		return maitreOuvrage;
	}

	@Override
	public void delete(MaitreOuvrage obj) {
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
