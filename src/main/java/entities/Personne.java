package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "personne")
@Entity
public class Personne {

	@Id
	private long id;
	@Column(name = "name") // que si le nom de la variable est différent du nom du champ
	private String name;
	private int age;

}
