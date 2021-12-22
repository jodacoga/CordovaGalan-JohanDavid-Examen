package ec.edu.ups.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable {

	@Id
	private int codigoAutor;
	private String nombreAutor;
	private String nacionalidad;
	
	public Autor() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoAutor() {
		return codigoAutor;
	}

	public void setCodigoAutor(int codigoAutor) {
		this.codigoAutor = codigoAutor;
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
	
	
}
