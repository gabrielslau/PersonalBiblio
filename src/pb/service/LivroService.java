package pb.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pb.entity.Livro;

@Stateless
public class LivroService extends AbstractPersistence<Livro, Long> {
	/**
	 * O container injeta a referência para o EntityManager.
	 */
	@PersistenceContext(unitName="personalBiblio")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public LivroService() {
		super(Livro.class);
	}
}
