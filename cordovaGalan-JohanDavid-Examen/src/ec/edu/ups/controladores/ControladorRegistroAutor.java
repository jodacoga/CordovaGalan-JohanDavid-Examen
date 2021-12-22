package ec.edu.ups.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.inject.Named;

import ec.edu.ups.ejb.FachadaAutor;
import ec.edu.ups.modelos.Autor;

@FacesConfig(version = Version.JSF_2_3)
@Named
@SessionScoped
public class ControladorRegistroAutor implements Serializable{
	@EJB
	private FachadaAutor fachadaAutor;
	
	private Autor autor;
	
	
	
	

}
