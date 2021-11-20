package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "commande")
public class Commande {

	@Id
	private long id;
	private String name;
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "commande")
	private List<LigneCommande> ligneCommande;

}
