package pb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pb.entity.Autor;
import pb.service.AutorService;

@ManagedBean(name="autorMB")
@ViewScoped
public class AutorMB extends AppMB {
	private static final long serialVersionUID = 1875014884451070556L;
	@EJB
	private AutorService service;
	private Autor autor;
	private List<Autor> autores;

	public AutorMB(){
		super();
		this.autor = new Autor();
		this.setAutores(new ArrayList<Autor>());
	}

	public String add() {
		return "autores/add.xhtml";
	}

	// TODO adicionar validação de campos
	public String addPost() {
		if(autor.getNome() != null && service.save(autor) != null){
			this.redirect("autores/index");
		}
		return "autores/add.xhtml";
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		if(autores.isEmpty()){
			autores = service.findAll();
		}
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public boolean isVazio(){
		return this.getAutores().isEmpty();
	}
	public boolean isNotVazio(){
		return !this.isVazio();
	}
}
