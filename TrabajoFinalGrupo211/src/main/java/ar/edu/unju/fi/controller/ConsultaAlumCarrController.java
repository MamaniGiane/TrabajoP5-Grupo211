package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.service.CarreraService;
import ar.edu.unju.fi.model.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConsultaAlumCarrController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping("/consulta-alumnos")
    public String mostrarFormularioConsulta(Model model) {
        model.addAttribute("carreras", carreraService.getAllCarreras());
        return "consulta-alumnos";
    }

    @GetMapping("/alumnos-por-carrera")
    public String consultarAlumnos(@RequestParam Long carreraId, Model model) {
    	Carrera carrera = carreraService.getCarreraByCodigo(carreraId);
        model.addAttribute("carrera", carrera);
        model.addAttribute("alumnos", carrera.getAlumnos());
        return "lista-alumnos";
    }
}