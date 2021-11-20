package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CommandeDao;
import entities.Commande;
import exceptions.technical.DAOException;

@Stateless
public class CommandeBusiness {

	@Inject
	private CommandeDao commandeDao;

	public List<Commande> getAll() throws DAOException {
		return commandeDao.getAll();
	}

}
