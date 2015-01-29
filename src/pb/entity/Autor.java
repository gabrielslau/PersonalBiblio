package pb.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autor implements AbstractEntity {
	private static final long serialVersionUID = 5326833736706249574L;
	private Integer id;
	private String nome;
	private Set<Livro> livros;

	public Autor() {
		super();
		this.livros = new HashSet<Livro>();
	}

	public Autor(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.livros = new HashSet<Livro>();
	}

	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany
	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
}
