package pb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro implements AbstractEntity {
	private int id, anoPub;
	private String titulo, isbn;
	private static final long serialVersionUID = 5326833736706249574L;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Number getId() {
		return id;
	}

	public void setId(int id) {
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
}
