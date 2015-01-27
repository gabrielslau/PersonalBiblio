package pb.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emprestimo implements AbstractEntity {
	private int id;
	private Calendar data, dataDevolucao;
	private static final long serialVersionUID = 5326833736706249574L;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Number getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}
