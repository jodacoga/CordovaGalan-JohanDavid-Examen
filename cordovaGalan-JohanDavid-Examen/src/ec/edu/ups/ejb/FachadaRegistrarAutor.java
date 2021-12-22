package ec.edu.ups.ejb;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelos.Autor;

public class FachadaRegistrarAutor extends FachadaAbstracta<Autor, String>{
	
public FachadaRegistrarAutor() {
		super(Autor.class);
		// TODO Auto-generated constructor stub
	}

@PersistenceContext(unitName = "jpa")
	private EntityManager gestor;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return gestor;
	}

	
}
