package ar.edu.unju.fi.model;


import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Component
@Entity
	public class Docente {
	
			@Id
			
			@Size (min=5, max=10, message="El legajo debe contener como mínimo 5 caracteres y como máximo 10 caracteres")
			@Pattern (regexp= "[a-z A-Z]*+[0-9]*", message="Debe ingresar únicamente letras y numeros")
		 	private String legajo;
			@NotBlank (message="Debe ingresar nombre del docente")
			@Size (min=3, max=20, message="El nombre debe contener como mínimo 3 caracteres y como máximo 20 caracteres")
			@Pattern (regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
		    private String nombre;
			@NotBlank (message="Debe ingresar apellido del docente")
			@Size (min=3, max=20, message="El apellido debe contener como mínimo 3 caracteres y como máximo 20 caracteres")
			@Pattern (regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
			private String apellido;
			@Email (message="Ingrese un correo valido")
		    private String email;
		    private String telefono;
		    private boolean estado;
		    
		    
		    //relacion 
		    @OneToOne 
		    @JoinColumn(name="codigo")
		    private Materia materia; 
		   
		    
	}
