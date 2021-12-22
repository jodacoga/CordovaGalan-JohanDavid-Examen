package ec.edu.ups.controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.inject.Named;

import ec.edu.ups.ejb.FachadaCapitulo;
import ec.edu.ups.modelos.Libro;

@FacesConfig(version = Version.JSF_2_3)
@Named
@RequestScoped
public class ControladorListar {

	@EJB
	private FachadaCapitulo fachadaCapitulo;

	private List<Libro> libro;

	private String nombreAutor;
	private String nombreCapitulo;

	public ControladorListar() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		libro = fachadaCapitulo.listar();
	}

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}



	public String getNombreCapitulo() {
		return nombreCapitulo;
	}

	public void setNombreCapitulo(String nombreCapitulo) {
		this.nombreCapitulo = nombreCapitulo;
	}

	public void listarPorTituloCapitulo() {
		libro = fachadaCapitulo.buscarPorNombreTitulo(nombreCapitulo);
	}

}
