package dao;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import entities.Personne;

@Singleton
public class PersonneDao {

	private static PersonneDao personneDao;

	private static final List<Personne> personnes = Stream.of(
		new Personne(0, "Etienne", 28),
		new Personne(1, "Ernesto", 35)
	).collect(Collectors.toList());


	public Personne get(long id) {
		return personnes.stream().filter(personne -> personne.getId() == id).findAny().orElse(null);
	}

	public Personne getByName(String name) {
		return personnes.stream().filter(personne -> personne.getName().equals(name)).findAny().orElse(null);
	}

	public List<Personne> getAll() {
		return Collections.unmodifiableList(personnes);
	}

	public void create(Personne entity) {
		personnes.add(entity);
	}

	public void update(Personne entity) {
		Personne oldPersonne = personnes.stream().filter(personne -> entity.getId() == personne.getId()).findAny().orElse(null);
		if (oldPersonne != null) {
			personnes.remove((int) entity.getId());
			personnes.add(entity);
		}
	}

	public void delete(Personne entity) {
		personnes.remove((int) entity.getId());
	}

}
