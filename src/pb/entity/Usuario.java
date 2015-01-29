package pb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements AbstractEntity {
	private static final long serialVersionUID = 5326833736706249574L;
	private Number id;
	private String nome, email, login, senha;
	private List<Livro> livros;
	private List<Emprestimo> emprestimos;

	public Usuario() {
		super();
		this.livros = new ArrayList<Livro>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	public Usuario(int id, String nome, String email, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.livros = new ArrayList<Livro>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}

	@Id
	@Override
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@OneToMany(mappedBy="usuario")
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@OneToMany(mappedBy="usuario")
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
}
