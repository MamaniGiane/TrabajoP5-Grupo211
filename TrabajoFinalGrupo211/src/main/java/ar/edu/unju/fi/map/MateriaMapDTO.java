package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MateriaMapDTO {

	@Mapping(source="codigo", target="codigo")
	@Mapping(source="nombre", target="nombre")
	@Mapping(source="curso", target="curso")
	@Mapping(source="cantHoras", target="cantHoras")
	
	
	
	MateriaDTO convertirMateriaAMateriaDTO(Materia m);
	
	@Mapping(target = "estado", ignore = true)
	@Mapping(target = "modalidad", ignore = true)
	@InheritInverseConfiguration
	Materia convertirMateriaDTOAMateria(MateriaDTO mdto);
	
	List<MateriaDTO> convertirListaMateriaAListaMateriasDTO (List<Materia> listaM);
	
	List<Materia> convertirListaMateriaDTOAListaMaterias (List<MateriaDTO> listaMDTO);
}
