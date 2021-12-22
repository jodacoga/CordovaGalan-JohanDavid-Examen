package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelos.Autor;

@Stateless
public class FachadaRegistrarAutor extends FachadaAbstracta<Autor, String> {

	@PersistenceContext(unitName = "jpa")
	private EntityManager gestor;

	public FachadaRegistrarAutor() {
		super(Autor.class);

	}

	@Override
	protected EntityManager getEntityManager() {
		return gestor;
	}

}
