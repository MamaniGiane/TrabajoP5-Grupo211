package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Component
@Entity

public class Materia {

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@NotBlank(message="Campo obligatorio")
	@Size(min=8, max=50)
	private String nombre;
	@NotBlank(message="Campo obligatorio")
	@Size(min=8, max=50)
	private String curso;
	@NotEmpty(message="Campo obligatorio")
	@Min(value=60, message="Debe tener minimo 60 horas")
	@Max(value=250, message="Maximo 250 horas")
	private int cantHoras;
	private String modalidad;
	private Boolean estado;

}
