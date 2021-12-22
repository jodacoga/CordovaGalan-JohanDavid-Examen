package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelos.Libro;

@Stateless
public class FachadaLibro extends FachadaAbstracta<Libro, Integer>{
	
	@PersistenceContext(unitName = "jpa")
	private EntityManager gestor;

	
	public FachadaLibro() {
		super(Libro.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return gestor;
	}

}
