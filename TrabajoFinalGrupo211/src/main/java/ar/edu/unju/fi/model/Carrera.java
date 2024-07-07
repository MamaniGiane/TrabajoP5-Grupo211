package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Component
@Entity

public class Carrera {

	@Id
	@Size (min=5, max=10, message="El codigo debe contener como mínimo 5 caracteres y como máximo 10 caracteres")
	@Pattern (regexp= "[a-z A-Z]*+[0-9]*", message="Debe ingresar únicamente letras y numeros")
	private String codigo;
	@NotBlank (message="Debe ingresar nombre de la carrera")
	@Size (min=3, max=20, message="El nombre debe contener como mínimo 3 caracteres y como máximo 20 caracteres")
	@Pattern (regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	private String nombre;
	@NotNull(message = "La cantidad de años no puede ser nula")
	 @Digits(integer = 1, fraction = 0, message = "Ingrese un valor numérico válido")
	 @Min(value = 1, message = "La cantidad de años debe ser como mínimo 1")
	 @Max(value = 6, message = "La cantidad de años debe ser como máximo 6")
	private Integer duracion;
	private Boolean estado;
	
	
	@OneToMany(mappedBy = "carrera", cascade=CascadeType.ALL)
    private List<Alumno> alumnos;

	@OneToMany(mappedBy="carrera", cascade=CascadeType.ALL)
	private List<Materia> materias;
}

