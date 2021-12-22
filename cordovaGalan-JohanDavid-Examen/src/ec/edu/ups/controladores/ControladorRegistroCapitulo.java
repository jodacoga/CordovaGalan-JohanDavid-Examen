package ec.edu.ups.controladores;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
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
public class ControladorRegistroCapitulo{

	@EJB
	private FachadaCapitulo fachadaCapitulo;
	
	@EJB
	private FachadaRegistrarAutor fachadaAutor;

	private Libro libro;
	private Capitulo capitulo;
	private Autor autor;
	
	private String nombreLibro;
	private String nombreAutor="";
	private String mensaje;
	
	
	public ControladorRegistroCapitulo() {
		
	}
	
	@PostConstruct
	public void init() {		
		  if(fachadaAutor.listar().size()==0) {
		  Autor autor1= new Autor();
		  autor1.setNacionalidad("Chile");
		  autor1.setNombreAutor("Pablo Neruda"); fachadaAutor.crear(autor1);
		  
		  Autor autor2= new Autor();
		  autor2.setNacionalidad("Estados Unidos");
		  autor2.setNombreAutor("Dan Brown"); fachadaAutor.crear(autor2);
		  
		  Autor autor3= new Autor();
		  autor3.setNacionalidad("Brasil");
		  autor3.setNombreAutor("Paulo Coelho"); fachadaAutor.crear(autor3);
		  
		  Autor autor4= new Autor();
		  autor4.setNacionalidad("Gran Bretaña");
		  autor4.setNombreAutor("JRR Talkie"); fachadaAutor.crear(autor4);
		  
		  }
		 
		libro= new Libro();
		capitulo= new Capitulo();
		
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
	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public void agregarLibro() {
		if(capitulo != null) {
			libro.getCapitulosList().add(capitulo);
			capitulo = new Capitulo();
		}
	}
	public void validarAutor() {
		autor = fachadaAutor.buscar(nombreAutor);
		
		if(nombreAutor != null) {
			mensaje = "Autor Asociado con exito";
		} else {
			mensaje = "No se ecuentra el Autor";
		}
	}
	public void quitarLibro(Capitulo capitulo) {	
		libro.getCapitulosList().remove(capitulo);
	}
	
	public void realizarCapitulo() {	
		capitulo.setAutor(autor);
		fachadaCapitulo.crear(libro);
		capitulo = new Capitulo();
		libro = new Libro();
		autor=null;	
		nombreLibro = "";
		nombreAutor= "";
		mensaje = "";
		
	}
	
	
}
