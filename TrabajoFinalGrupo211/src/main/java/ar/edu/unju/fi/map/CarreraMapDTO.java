package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapDTO {

	@Mapping(source = "codigo", target = "codigo")
	@Mapping(source = "nombre", target = "nombre")
	@Mapping(source = "duracion", target = "duracion")
	@Mapping(source = "estado", target = "estado")

	CarreraDTO convertirCarreraACarreraDTO(Carrera m);
	@InheritInverseConfiguration
	Carrera convertirCarreraDTOACarrera(CarreraDTO m);

	List<CarreraDTO> convertirListaCarreraAListaCarreraDTO(List<Carrera> listaM);

	List<Carrera> convertirListaCarreraDTOAListaCarrera(List<CarreraDTO> listaMDTO);

}