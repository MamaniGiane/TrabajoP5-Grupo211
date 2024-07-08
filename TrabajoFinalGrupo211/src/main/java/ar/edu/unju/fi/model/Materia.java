package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.persistence.Column;
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
	
	@Column(name = "cantHoras", nullable = false)
	@Size(min = 50, max = 170, message = "La Cantidad de horas debe ser entre 50 y 170 horas.")
	private String cantHoras;
	private String modalidad;
	private Boolean estado;

}
