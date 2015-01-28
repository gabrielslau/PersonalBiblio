package pb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Resenha implements AbstractEntity {
	private static final long serialVersionUID = 5326833736706249574L;
	Number id;
	private int nota;
	private String texto;
	private Livro livro;
	private Emprestimo emprestimo;

	public Resenha() {
		super();
	}

	public Resenha(int id, int nota, String texto) {
		super();
		this.id = id;
		this.nota = nota;
		this.texto = texto;
	}

	@Id
	@Override
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@ManyToOne
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@OneToOne
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
}
