package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ligne_commande")
public class LigneCommande {

	@Id
	private long id;
	private long quantity;
	@Column(name = "commande")
	private long idCommande;

}
