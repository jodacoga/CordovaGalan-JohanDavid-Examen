package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelos.Libro;


@Stateless
public class FachadaCapitulo extends FachadaAbstracta<Libro, String>{
	
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
	public List<Libro> buscarPorNombreTitulo(String nombre) {
		String jpql="SELECT ISBN,NOMBRELIBRO,NUMPAGINA, capitulo.TITULO FROM examenapli.libro inner join capitulo where capitulo.TITULO= '"+nombre+"'";
		
		return gestor.createQuery(jpql, Libro.class).getResultList();
	}
	

}
