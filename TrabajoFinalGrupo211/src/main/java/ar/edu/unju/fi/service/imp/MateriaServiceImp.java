package ar.edu.unju.fi.service.imp;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.map.MateriaMapDTO;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.MateriaService;

@Service
public class MateriaServiceImp implements MateriaService{

	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	MateriaMapDTO materiaMapDTO;
	
	@Override
	public void guardarMateria(MateriaDTO materiaDTO) {
		// TODO Auto-generated method stub
		materiaRepository.save(materiaMapDTO.convertirMateriaDTOAMateria(materiaDTO));
		
	}
	
	@Override
	public List<MateriaDTO> mostrarMateria() {
		// TODO Auto-generated method stub
		return materiaMapDTO.convertirListaMateriaAListaMateriasDTO(materiaRepository.findMateriaByEstado(true));
	}
	
	@Override
	public void borrarMateria(Integer codigo) {
		// TODO Auto-generated method stub
		System.out.println("este es el codigo: "+codigo);
		List<MateriaDTO> m = materiaMapDTO.convertirListaMateriaAListaMateriasDTO(materiaRepository.findAll());
		m.forEach(materia -> {
			if(materia.getCodigo().equals(codigo)) {
				materia.setEstado(false);
				materiaRepository.save(materiaMapDTO.convertirMateriaDTOAMateria(materia));
			}
		});

	}
	
	@Override
	public void modificarMateria(MateriaDTO materiaDTO) {
		// TODO Auto-generated method stub
		materiaRepository.save(materiaMapDTO.convertirMateriaDTOAMateria(materiaDTO));
	}
	
	@Override
	public MateriaDTO buscarMateria(Integer codigo) {
		// TODO Auto-generated method stub
		List<MateriaDTO> m = materiaMapDTO.convertirListaMateriaAListaMateriasDTO(materiaRepository.findAll());
		for(MateriaDTO materias : m) {
			if(materias.getCodigo().equals(codigo)) {
				return materias;
			}
		}
		return null;
	}
	
	
}
