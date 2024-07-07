package ar.edu.unju.fi.model;


import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
		    @Size(min=10, max=10,message="Ingrese un telefono valido (10 caracteres)")
		    private String telefono;

		    @Column(name = "estado", nullable = false)
		    private boolean estado;
		    
		    
		   
		    
	}
