package pb.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo implements AbstractEntity {
	private static final long serialVersionUID = 5326833736706249574L;
	private Number id;
	private Calendar data, dataDevolucao;
	private Usuario usuario;
	private Resenha resenha;
	private Livro livro;

	public Emprestimo() {
		super();
	}

	public Emprestimo(int id, Calendar data, Calendar dataDevolucao) {
		super();
		this.id = id;
		this.data = data;
		this.dataDevolucao = dataDevolucao;
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

	@Temporal(TemporalType.DATE)
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToOne(mappedBy="emprestimo")
	public Resenha getResenha() {
		return resenha;
	}

	public void setResenha(Resenha resenha) {
		this.resenha = resenha;
	}

	@ManyToOne
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
