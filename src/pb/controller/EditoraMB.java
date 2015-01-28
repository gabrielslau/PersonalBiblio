package pb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pb.entity.Editora;
import pb.service.EditoraService;

@ManagedBean(name="editoraMB")
@ViewScoped
public class EditoraMB extends AppMB {
	private static final long serialVersionUID = 1875014884451070556L;
	@EJB
	private EditoraService service;
	private Editora editora;
	private List<Editora> editoras;

	public EditoraMB(){
		super();
		this.editora = new Editora();
		this.setEditoras(new ArrayList<Editora>());
	}

	public String add() {
		return "editoras/add.xhtml";
	}

	// TODO adicionar validação de campos
	public String addPost() {
		if(editora.getNome() != null && service.save(editora) != null){
			this.redirect("editoras/index");
		}
		return "editoras/add.xhtml";
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Editora> getEditoras() {
		if(editoras.isEmpty()){
			editoras = service.findAll();
		}
		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}

	public boolean isVazio(){
		return this.getEditoras().isEmpty();
	}
	public boolean isNotVazio(){
		return !this.isVazio();
	}
}
