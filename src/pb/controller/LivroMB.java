package pb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pb.entity.Livro;
import pb.service.LivroService;

@ManagedBean(name="livroMB")
@ViewScoped
public class LivroMB extends AppMB {
	private static final long serialVersionUID = 1875014884451070556L;
	@EJB
	private LivroService service;
	private Livro livro;
	private List<Livro> livros;
	private Integer idLivro;
	private Integer idUsuario;

	public LivroMB(){
		super();
		this.livro = new Livro();
		this.setlivros(new ArrayList<Livro>());
	}

	public String add() {
		return "livros/add.xhtml";
	}

	// TODO adicionar validação de campos
	public void addPost() {
		System.out.println(" entrou");
		if(service.save(livro) != null){
			System.err.println(" salvou ");
			this.redirect("livros/index");
		}else{
			this.redirect("livros/add");
		}
	}

	public Livro getlivro() {
		return livro;
	}

	public void setlivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getlivros() {
		if(livros.isEmpty()){
			livros = service.findAll();
		}
		return livros;
	}

	public void setlivros(List<Livro> livros) {
		this.livros = livros;
	}

	public boolean isVazio(){
		return this.getlivros().isEmpty();
	}
	public boolean isNotVazio(){
		return !this.isVazio();
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}
