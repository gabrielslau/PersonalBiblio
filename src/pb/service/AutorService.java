package pb.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pb.entity.Autor;

@Stateless
public class AutorService extends AbstractPersistence<Autor, Long> {
	/**
	 * O container injeta a referência para o EntityManager.
	 */
	@PersistenceContext(unitName="personalBiblio")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AutorService() {
		super(Autor.class);
	}
}
