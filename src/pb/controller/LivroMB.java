package pb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pb.entity.Editora;
import pb.entity.Livro;
import pb.entity.Usuario;
import pb.service.EditoraService;
import pb.service.LivroService;
import pb.service.UsuarioService;

@ManagedBean(name = "livroMB")
@ViewScoped
public class LivroMB extends AppMB {
	private static final long serialVersionUID = 1875014884451070556L;
	@EJB
	private LivroService service;

	@EJB
	private UsuarioService usuarioService;

	@EJB
	private EditoraService editoraService;

	// private Editora editora;
	private Livro livro;
	private List<Livro> livros;
	// private List<Autor> autores;
	private Long idLivro;
	private Integer usuarioID;
	private Integer editoraID;
	private List<Integer> autores;

	public LivroMB() {
		super();
		// this.editora = new Editora();
		this.livro = new Livro();
		this.livros = new ArrayList<Livro>();
		// this.autores = new ArrayList<Autor>();
	}

	// TODO adicionar validação de campos
	public void addPost() {
		Usuario usuario = usuarioService.find(usuarioID);
		livro.setUsuario(usuario);

		Editora editora = editoraService.find(editoraID);
		livro.setEditora(editora);

		if (service.save(livro) != null) {
			this.redirect("livros/index");
		}

		// else {
		// TODO exibir mensagem
		// this.redirect("livros/add");
		// }
	}

	public Livro getlivro() {
		return livro;
	}

	public void setlivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getlivros() {
		if (livros.isEmpty()) {
			livros = service.findAll();
		}
		return livros;
	}

	public void setlivros(List<Livro> livros) {
		this.livros = livros;
	}

	public boolean isVazio() {
		return this.getlivros().isEmpty();
	}

	public boolean isNotVazio() {
		return !this.isVazio();
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public Integer getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(Integer usuarioID) {
		this.usuarioID = usuarioID;
	}

	// public List<Autor> getAutores() {
	// return autores;
	// }
	//
	// public void setAutores(List<Autor> autores) {
	// this.autores = autores;
	// }
	//
	// public Editora getEditora() {
	// return editora;
	// }
	//
	// public void setEditora(Editora editora) {
	// this.editora = editora;
	// }

	public Integer getEditoraID() {
		return editoraID;
	}

	public void setEditoraID(Integer editoraID) {
		this.editoraID = editoraID;
	}

	public List<Integer> getAutores() {
		return autores;
	}

	public void setAutores(List<Integer> autores) {
		this.autores = autores;
	}

}
