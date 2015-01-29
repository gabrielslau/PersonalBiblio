package pb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Editora implements AbstractEntity {
	private static final long serialVersionUID = 5326833736706249574L;
	private Integer id;
	private String nome;
	private List<Livro> livros;

	public Editora() {
		super();
		this.livros = new ArrayList<Livro>();
	}

	public Editora(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.livros = new ArrayList<Livro>();
	}

	@Id
	@Override
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

	@OneToMany(mappedBy="editora", cascade=CascadeType.ALL)
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
