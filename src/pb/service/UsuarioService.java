package pb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pb.entity.Livro;
import pb.entity.Usuario;

@Stateless
public class UsuarioService extends AbstractPersistence<Usuario, Integer> {
	/**
	 * O container injeta a referência para o EntityManager.
	 */
	@PersistenceContext(unitName = "personalBiblio")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UsuarioService() {
		super(Usuario.class);
	}

	public List<Livro> findAllByUser(Integer id) {
		return em.createQuery("SELECT l FROM Livro l WHERE l.usuario.id = :id", Livro.class)
				.setParameter("id", id)
				.getResultList();
	}
}
