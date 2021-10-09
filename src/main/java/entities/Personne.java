package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Personne {

	private String name;
	private int age;

}
