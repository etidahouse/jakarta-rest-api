package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import entities.Commande;
import exceptions.technical.DAOException;
import jpa.JpaEntityManager;

@Stateless
public class CommandeDao {

	private static EntityManager entityManager = JpaEntityManager.getEntityManager();

	public List<Commande> getAll() throws DAOException {
		try {
			return entityManager.createQuery("SELECT p FROM Commande p", Commande.class).getResultList();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
