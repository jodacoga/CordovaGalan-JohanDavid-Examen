package ec.edu.ups.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Libro implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroLibro;
	private String nombreLibro;
	private String ISBN;
	private String numpagina;
	
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public int getNumeroLibro() {
		return numeroLibro;
	}

	public void setNumeroLibro(int numeroLibro) {
		this.numeroLibro = numeroLibro;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getNumpagina() {
		return numpagina;
	}

	public void setNumpagina(String numpagina) {
		this.numpagina = numpagina;
	}
	
	

}
