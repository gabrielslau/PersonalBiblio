package pb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor implements AbstractEntity {
	private int id;
	private String nome;
	private static final long serialVersionUID = 5326833736706249574L;

	public Autor() {
		super();
	}

	public Autor(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Id
	@Override
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Number getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
