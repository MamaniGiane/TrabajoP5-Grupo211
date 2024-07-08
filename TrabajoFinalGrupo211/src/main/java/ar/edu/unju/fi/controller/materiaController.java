package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.service.MateriaService;
import jakarta.validation.Valid;


@Controller
public class materiaController {

	@Autowired
	MateriaDTO nuevaMateriaDTO;
	
	@Autowired
	MateriaService materiaService;
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista formMateria.html
		ModelAndView modelView = new ModelAndView("formMateria");
		
		//agrega el objeto
		modelView.addObject("nuevaMateria", nuevaMateriaDTO);
		modelView.addObject("flag", false);
		return modelView;
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@Valid @ModelAttribute("nuevaMateria") MateriaDTO materiaparaGuardar, BindingResult result) {
		ModelAndView modelView = new ModelAndView("listadoDeMateria");
		try {
			if(result.hasErrors()){
				modelView.setViewName("formMateria");
				modelView.addObject("flag", false);
			}else {
			materiaService.guardarMateria(materiaparaGuardar);
		}
		}catch(Exception e) {
			modelView.addObject("errors", true);
			modelView.addObject("cargaMateriaErrorMessage", "Error al cargar en la BD" + e.getMessage());
			System.out.println(e.getMessage());
		}
		modelView.addObject("listadoMateria", materiaService.mostrarMateria());
		
		return modelView;
	}
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") Integer codigo) {
		//borrar
		System.out.println("este es el codigo: "+ codigo);
		materiaService.borrarMateria(codigo);
		//nuevo listado
		ModelAndView modelView = new ModelAndView("listadoDeMaterias");
		modelView.addObject("listadoMateria", materiaService.mostrarMateria());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView editarMateria(@PathVariable(name="codigo") Integer codigo) {
		//buscar
		MateriaDTO m = materiaService.buscarMateria(codigo);
		//mostrar el nuevo formulario
		ModelAndView modelView=new ModelAndView("formMateria");	
		modelView.addObject("nuevaMateria",m);
		modelView.addObject("flag",true);
		return modelView;
	}
	
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateriaListado(@Valid @ModelAttribute("nuevaMateria") MateriaDTO m, BindingResult resultado) {
		ModelAndView modelView=new ModelAndView();
		try {
			if (resultado.hasErrors()) {
				modelView.setViewName("formMateria");
			}
			else {		
				//modificar la materia
				materiaService.modificarMateria(m);
				System.out.println("Materia modificada correctamente");				
			}					
		}
		catch( Exception e){
			boolean errors = true;
			modelView.addObject("errors", errors);
			modelView.addObject("cargaMateriaErrorMessage", "Error al cargar en la BD " + e.getMessage());
			System.out.println(e.getMessage());
		}
		if (!resultado.hasErrors()) {
			modelView.setViewName("listaDeMaterias");
			modelView.addObject("listadoMaterias",materiaService.mostrarMateria());
		}
		return modelView;
	}
	
	@GetMapping("/listadoMaterias")
	public ModelAndView showMaterias() {
		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", materiaService.mostrarMateria());
		return modelView;

	}
	
}