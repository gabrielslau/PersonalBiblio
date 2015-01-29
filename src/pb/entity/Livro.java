package pb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Livro implements AbstractEntity {
	private static final long serialVersionUID = 5326833736706249574L;
	private Integer id;
	private int anoPub;
	private String titulo, isbn;
	private Editora editora;
	private List<Autor> autores;
	private List<Resenha> resenhas;
	private List<Emprestimo> emprestimos;
	private Usuario usuario;

	public Livro() {
		super();
	}

	public Livro(int id, int anoPub, String titulo, String isbn) {
		super();
		this.id = id;
		this.anoPub = anoPub;
		this.titulo = titulo;
		this.isbn = isbn;
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

	public int getAnoPub() {
		return anoPub;
	}

	public void setAnoPub(int anoPub) {
		this.anoPub = anoPub;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	@ManyToMany(mappedBy="livros", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@OneToMany(mappedBy="livro")
	public List<Resenha> getResenhas() {
		return resenhas;
	}

	public void setResenhas(List<Resenha> resenhas) {
		this.resenhas = resenhas;
	}

	@OneToMany(mappedBy="livro")
	public List<Emprestimo> getEmprestimo() {
		return emprestimos;
	}

	public void setEmprestimo(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
