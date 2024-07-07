package ar.edu.unju.fi.model;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Component
@Entity
public class Alumno {

    @Id
    @Size(min = 7, max = 10, message = "El DNI debe tener entre 7 y 10 caracteres")
    @Pattern(regexp = "[0-9]+", message = "El DNI debe contener solo números")
    private String dni;

    @NotBlank(message = "Debe ingresar nombre del alumno")
    @Size(min = 3, max = 50, message = "El nombre debe contener entre 3 y 50 caracteres")
    @Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+", message = "El nombre debe contener solo letras y espacios")
    private String nombre;

    @NotBlank(message = "Debe ingresar apellido del alumno")
    @Size(min = 3, max = 50, message = "El apellido debe contener entre 3 y 50 caracteres")
    @Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+", message = "El apellido debe contener solo letras y espacios")
    private String apellido;

    @NotBlank(message = "Debe ingresar un correo electrónico")
    @Email(message = "Ingrese un correo electrónico válido")
    private String email;

    @NotBlank(message = "Debe ingresar un número de teléfono")
    @Pattern(regexp = "[0-9]+", message = "El teléfono debe contener solo números")
    private String telefono;

    @NotBlank(message = "Debe ingresar la fecha de nacimiento")
    private String fechaNacimiento;

    @NotBlank(message = "Debe ingresar un domicilio")
    private String domicilio;

    @NotBlank(message = "Debe ingresar un número de LU")
    @Size(min = 5, max = 10, message = "El LU debe contener entre 5 y 10 caracteres")
    @Pattern(regexp = "[0-9]+", message = "El LU debe contener solo números")
    private String lu;

    @ManyToMany(mappedBy = "alumnos")
	private List<Materia> materia;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
}