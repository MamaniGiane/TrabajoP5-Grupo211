package ar.edu.unju.fi.DTO;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class MateriaDTO {
	
	private Integer codigo;
	private String nombre;
	private String curso;
	private String cantHoras;
	private String modalidad;
	private Boolean estado;
}