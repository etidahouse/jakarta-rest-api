package business;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dao.PersonneDao;
import entities.Personne;

@Singleton
public class PersonneBusiness {

	@Inject
	private PersonneDao personneDao;

	public List<Personne> getAllPersonnes() {
		return personneDao.getAll();
	}

	public Personne get(long id) {
		return personneDao.get(id);
	}

	public void add(Personne personne) {
		personneDao.create(personne);
	}

	public void delete(long id) {
		personneDao.delete(get(id));
	}

	public void update(Personne personne) {
		personneDao.update(personne);
	}

	public Personne search(String name) {
		return personneDao.getByName(name);
	}

}
