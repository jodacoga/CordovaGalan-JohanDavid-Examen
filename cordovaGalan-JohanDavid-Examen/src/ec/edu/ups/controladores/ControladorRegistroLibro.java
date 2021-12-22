package ec.edu.ups.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.inject.Named;

import ec.edu.ups.ejb.FachadaLibro;
import ec.edu.ups.modelos.Capitulo;
import ec.edu.ups.modelos.Libro;

@FacesConfig(version = Version.JSF_2_3)
@Named
@SessionScoped
public class ControladorRegistroLibro implements Serializable{

	@EJB
	private FachadaLibro fachadaLibro;
	
	
	private Libro libro;
	private Capitulo capitulo;
	
	private String nombreCapitulo;
	
	@PostConstruct
	public void init() {
		libro = new Libro();
		capitulo = new Capitulo();
	}



	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	public String getNombreCapitulo() {
		return nombreCapitulo;
	}

	public void setNombreCapitulo(String nombreCapitulo) {
		this.nombreCapitulo = nombreCapitulo;
	}
	
	public void agregarCapitulo() {
		if (capitulo != null) {
			libro.getListaCapitulos().add(capitulo);
			capitulo = new Capitulo();
		} 
	}
	
	public void quitarCapitulo(Capitulo capitulo) {
		libro.getListaCapitulos().remove(capitulo);
	}
	
	public void realizarLibro() {
		fachadaLibro.crear(libro);
		libro = new Libro();
		capitulo = new Capitulo();
		
		nombreCapitulo = "";
	}
	
	
	
	
	
}
