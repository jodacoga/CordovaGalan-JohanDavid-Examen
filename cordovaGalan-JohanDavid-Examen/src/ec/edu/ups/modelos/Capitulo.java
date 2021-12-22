package ec.edu.ups.modelos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Capitulo  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private int numeroCap;
	private String titulo;
	
	

	@JoinColumn(name = "numeroAutor", referencedColumnName = "numeroAutor")
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Autor autor;
	
	

}
