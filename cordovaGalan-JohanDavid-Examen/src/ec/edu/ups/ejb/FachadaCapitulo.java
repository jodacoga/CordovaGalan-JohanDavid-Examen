package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelos.Capitulo;
import ec.edu.ups.modelos.Libro;

@Stateless
public class FachadaCapitulo extends FachadaAbstracta<Libro, Integer>{
	
	@PersistenceContext(unitName = "jpa")
	private EntityManager gestor;
	
	public FachadaCapitulo() {
		super(Libro.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return gestor;
	}

}
