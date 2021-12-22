package ec.edu.ups.ejb;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class FachadaAbstracta<T, ID> {

	private Class<T> clase;
	
	public FachadaAbstracta(Class<T> clase) {
		this.clase = clase;
	}
	
	protected abstract EntityManager getEntityManager();
	
	public void crear(T entidad) {
		getEntityManager().persist(entidad);
	}
	
	public void modificar(T entidad) {
		getEntityManager().merge(entidad);
	}
	
	public T buscar(ID id) {
		return getEntityManager().find(clase, id);
	}
	
	public void eliminar(T entidad) {
		getEntityManager().remove(entidad);
	}
	
	public List<T> listar() {
		String jpql = "SELECT e FROM " + clase.getCanonicalName() + " e";
		return getEntityManager().createQuery(jpql, clase).getResultList();
	}
}
