package ec.edu.ups.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.inject.Named;

import org.jboss.weld.context.ejb.Ejb;

import ec.edu.ups.ejb.FachadaRegistrarAutor;
import ec.edu.ups.modelos.Autor;
import ec.edu.ups.modelos.Capitulo;
import ec.edu.ups.modelos.Libro;

@FacesConfig(version = Version.JSF_2_3)
@Named
@SessionScoped
public class ControladorRegistroAutor implements Serializable{
	
	@Ejb
	private FachadaRegistrarAutor fachadaAutor;
	
	private Autor autor;

	private String nombreAutor;
	private String nacionalidad;
	
	@PostConstruct
	public void init() {
		autor= new Autor();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public void crearAutor() {
		
		autor.setNombreAutor(nombreAutor);
		autor.setNacionalidad(nacionalidad);
		fachadaAutor.crear(autor);
		
		autor=new Autor();
		
		
	}
	
}
