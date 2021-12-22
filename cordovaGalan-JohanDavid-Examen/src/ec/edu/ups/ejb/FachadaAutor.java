package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelos.Autor;

public class FachadaAutor extends FachadaAbstracta<Autor, Integer>{
	
	public FachadaAutor() {
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
