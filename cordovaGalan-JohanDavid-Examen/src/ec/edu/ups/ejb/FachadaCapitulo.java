package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public List<Libro> buscarPorNombreComida(String nombre) {
		String jpql = "SELECT p FROM Pedido p JOIN p.listaComidas c WHERE c.nombre = '" + nombre + "'";
		return gestor.createQuery(jpql, Libro.class).getResultList();
	}
	

}
