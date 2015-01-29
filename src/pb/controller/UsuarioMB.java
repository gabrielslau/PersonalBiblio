package pb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pb.entity.Usuario;
import pb.service.UsuarioService;

@ManagedBean(name="usuarioMB")
@ViewScoped
public class UsuarioMB extends AppMB {
	private static final long serialVersionUID = 1875014884451070556L;
	@EJB
	private UsuarioService service;
	private Usuario usuario;
	private List<Usuario> usuarios;

	public UsuarioMB(){
		super();
		this.usuario = new Usuario();
		this.setUsuarios(new ArrayList<Usuario>());
	}

	public String add() {
		return "usuarios/add.xhtml";
	}

	// TODO adicionar validação de campos
	public String addPost() {
		if(usuario.getNome() != null && service.save(usuario) != null){
			this.redirect("usuarios/index");
		}
		return "usuarios/add.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		if(usuarios.isEmpty()){
			usuarios = service.findAll();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public boolean isVazio(){
		return this.getUsuarios().isEmpty();
	}
	public boolean isNotVazio(){
		return !this.isVazio();
	}
}
