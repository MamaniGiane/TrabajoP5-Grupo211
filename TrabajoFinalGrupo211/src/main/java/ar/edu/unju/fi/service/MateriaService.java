package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.MateriaDTO;


@Service
public interface MateriaService {

	public void guardarMateria(MateriaDTO materiaDTO);
	public List<MateriaDTO> mostrarMateria();
	public void borrarMateria(Integer codigo);
	public void modificarMateria(MateriaDTO materiaDTO);
	public MateriaDTO buscarMateria(Integer codigo);

}
