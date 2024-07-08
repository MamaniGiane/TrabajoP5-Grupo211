package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.map.DocenteMapDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;
import lombok.extern.slf4j.Slf4j;

@Service("docenteServiceImp")
@Slf4j
public class DocenteServiceImp implements DocenteService {

    @Autowired
    DocenteMapDTO docenteMapDTO;

    @Autowired
    DocenteRepository docenteRepository;

    @Override
    public List<DocenteDTO> MostrarDocente() {
        log.info("Mostrando listado de docentes activos");
        List<DocenteDTO> docenteDTOs = docenteMapDTO.toDocenteDTOList(docenteRepository.findDocenteByEstado(true));
        return docenteDTOs;
    }

    @Override
    public DocenteDTO findByLegajo(String legajo) {
        Optional<Docente> docenteOpt = docenteRepository.findByLegajo(legajo);

        if (docenteOpt.isPresent()) {
            log.info("Docente encontrado por legajo: {}", legajo);
            return docenteOpt.map(docenteMapDTO::toDocenteDTO).orElse(null);
        } else {
            log.warn("Docente no encontrado por legajo: {}", legajo);
            return null;
        }
    }

    @Override
    public boolean save(DocenteDTO docenteDTO) {
        Docente docente = docenteMapDTO.toDocente(docenteDTO);
        docenteRepository.save(docente);
        log.info("Docente guardado correctamente: {}", docenteDTO.getLegajo());
        return true;
    }

    @Override
    public void deleteByLegajo(String legajo) {
        List<Docente> todosLosDocentes = docenteRepository.findAll();
        for (int i = 0; i < todosLosDocentes.size(); i++) {
            Docente docente = todosLosDocentes.get(i);
            if (docente.getLegajo().equals(legajo)) {
                docente.setEstado(false);
                docenteRepository.save(docente);
                log.info("Docente eliminado lógicamente por legajo: {}", legajo);
                break;
            }
        }
    }

    @Override
    public void edit(DocenteDTO docenteDTO) {
        Docente docente = docenteMapDTO.toDocente(docenteDTO);
        docenteRepository.save(docente);
        log.info("Docente editado correctamente: {}", docenteDTO.getLegajo());
    }

    @Override
    public Docente buscaDocente(String legajo) {
        return docenteRepository.findById(legajo).orElse(null);
    }
}
