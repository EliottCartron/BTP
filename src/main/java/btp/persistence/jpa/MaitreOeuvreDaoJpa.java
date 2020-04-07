package btp.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import btp.Application;
import btp.model.MaitreOeuvre;
import btp.persistence.IMaitreOeuvreDao;

public class MaitreOeuvreDaoJpa implements IMaitreOeuvreDao{

	@Override
	public List<MaitreOeuvre> findAll() {
		List<MaitreOeuvre> maitreOeuvres = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<MaitreOeuvre> query = em.createQuery("from MaitreOeuvre", MaitreOeuvre.class);

			maitreOeuvres = query.getResultList();

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

		return maitreOeuvres;
	}

	@Override
	public MaitreOeuvre find(Long id) {
		MaitreOeuvre maitreOeuvre = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			maitreOeuvre = em.find(MaitreOeuvre.class, id);

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

		return maitreOeuvre;
	}

	@Override
	public MaitreOeuvre save(MaitreOeuvre obj) {
		MaitreOeuvre maitreOeuvre = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			maitreOeuvre = em.merge(obj);

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

		return maitreOeuvre;
	}

	@Override
	public void delete(MaitreOeuvre obj) {
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
