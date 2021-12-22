package ec.edu.ups.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelos.Capitulo;

@Stateless
public class FachadaCapitulo extends FachadaAbstracta<Capitulo, Integer>{

	@PersistenceContext(unitName = "jpa")
	private EntityManager gestor;
	
	public FachadaCapitulo() {
		super(Capitulo.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return gestor;
	}
}
