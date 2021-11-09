package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entities.Personne;
import exceptions.technical.DAOException;
import jpa.JpaEntityManager;

@Stateless
public class PersonneDao {

	private static EntityManager entityManager = JpaEntityManager.getEntityManager();

	public Personne get(long id) throws DAOException {
		try {
			return entityManager.find(Personne.class, id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public Personne getByName(String name) throws DAOException {
		try {
			Query query = entityManager.createQuery("SELECT p FROM Personne p WHERE p.name=:ma_var_name");
			query.setParameter("ma_var_name", name);
			return (Personne) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<Personne> getAll() throws DAOException {
		try {
			return entityManager.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void create(Personne entity) throws DAOException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void update(Personne entity) throws DAOException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void delete(Personne entity) throws DAOException {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
