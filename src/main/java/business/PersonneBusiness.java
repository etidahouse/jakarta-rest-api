package business;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dao.PersonneDao;
import entities.Personne;
import exceptions.technical.DAOException;

@Singleton
public class PersonneBusiness {

	@Inject
	private PersonneDao personneDao;

	public List<Personne> getAllPersonnes() throws DAOException {
		return personneDao.getAll();
	}

	public Personne get(long id) throws DAOException {
		return personneDao.get(id);
	}

	public Personne add(Personne personne) throws DAOException {
		personneDao.create(personne);
		return personne;
	}

	public void delete(long id) throws DAOException {
		personneDao.delete(get(id));
	}

	public Personne update(Personne personne) throws DAOException {
		personneDao.update(personne);
		return personne;
	}

	public Personne search(String name) throws DAOException {
		return personneDao.getByName(name);
	}

}
