package pb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements AbstractEntity {
	private int id;
	private String nome, email, login, senha;
	private static final long serialVersionUID = 5326833736706249574L;

	public Usuario() {
		super();
	}
	public Usuario(int id, String nome, String email, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
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
}
