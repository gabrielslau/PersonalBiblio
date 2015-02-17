package pb.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pb.entity.Editora;

@Stateless
public class EditoraService extends AbstractPersistence<Editora, Integer> {

	/**
	 * O container injeta a referência para o EntityManager.
	 */
	@PersistenceContext(unitName="personalBiblio")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EditoraService() {
		super(Editora.class);
	}
}
