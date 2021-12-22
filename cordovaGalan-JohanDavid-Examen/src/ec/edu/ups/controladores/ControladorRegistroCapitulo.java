package ec.edu.ups.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.inject.Named;

import org.jboss.weld.context.ejb.Ejb;

import ec.edu.ups.ejb.FachadaCapitulo;
import ec.edu.ups.ejb.FachadaRegistrarAutor;
import ec.edu.ups.modelos.Autor;
import ec.edu.ups.modelos.Capitulo;
import ec.edu.ups.modelos.Libro;


@FacesConfig(version = Version.JSF_2_3)
@Named
@SessionScoped
public class ControladorRegistroCapitulo implements Serializable {

	@EJB
	private FachadaCapitulo fachadaCapitulo;
	
	@Ejb
	private FachadaRegistrarAutor fachadaAutor;

	private Libro libro;
	private Capitulo capitulo;
	private Autor autor;
	
	private String nombreLibro;
	private String nombreAutor;
	private String mensaje;
	
	@PostConstruct
	public void init() {
		
		libro= new Libro();
		capitulo= new Capitulo();
	}

	
	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
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


	public void agregarLibro() {
//		if (libro != null) {
//			capitulo.getListaLibro().add(libro);
//			libro = new Libro();
//		} 
	
		if(capitulo != null) {
			//libro.getListaCapitulo().add(capitulo);
			//capitulo = new Capitulo();
			libro.getCapitulosList().add(capitulo);
//			capitulo.getListaCapitulo().add(capitulo);
			capitulo = new Capitulo();
		
		}
	
	
	}
	public void validarAutor() {
		autor = fachadaAutor.buscar(nombreAutor);
		if(autor == null) {
			mensaje = "No se ecuentra el Autor";
		} else {
			mensaje = "Autor Encontrado";
		}
	}
	public void quitarLibro(Capitulo capitulo) {
		
//		libro.getListaCapitulo().remove(capitulo);
		libro.getCapitulosList().remove(capitulo);
	}
	
	public void realizarCapitulo() {
		
		capitulo.setAutor(autor);
		fachadaCapitulo.crear(libro);
		capitulo = new Capitulo();
		libro = new Libro();
		autor=null;
		
		nombreLibro = "";
		nombreAutor="";
		mensaje = "";
		
	}
	
	
}
