package business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import entities.Personne;

@Singleton
public class PersonneBusiness {

	private List<Personne> dao;

	public PersonneBusiness() {
		this.dao = new ArrayList<>();
		dao.add(Personne.builder().name("etienne").age(26).build());
		dao.add(Personne.builder().name("ernesto").age(32).build());
		dao.add(Personne.builder().name("chirac").age(95).build());
	}

	public List<Personne> getAllPersonnes() {
		return dao;
	}

	public Personne get(String name) {
		return dao.stream().filter(personne -> name.equals(personne.getName())).findAny().orElse(null);
	}

	public List<Personne> add(Personne personne) {
		dao.add(personne);
		return dao;
	}

	public void delete(String name) {
		dao.removeIf(personne -> name.contains(personne.getName()));
	}

	public Personne update(Personne personne) {
		return personne;
	}

	public List<Personne> search(String name) {
		return dao.stream()
				.filter(personne -> personne.getName().contains(name)).collect(Collectors.toList());
	}

}
