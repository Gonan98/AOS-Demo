package edu.colegio.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.colegio.app.entities.Alumno;
import edu.colegio.app.service.IAlumnoService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("/lista")
	public String listarAlumnos(Model model) {
		try {
			model.addAttribute("listadoAlumnos", alumnoService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return "/alumno/lista";
	}
	
	@GetMapping("/searchByApellidos")
	public String buscarAlumnosPorApellidos(@RequestParam("apellido") String apellido, Model model) {
		try {
			if(!apellido.isEmpty()) {
				List<Alumno> alumnos = alumnoService.findByApellidos(apellido);
				if(!alumnos.isEmpty())
					model.addAttribute("listadoAlumnos", alumnos);
				else {
					model.addAttribute("info", "No existen alumnos con ese apellido");
					model.addAttribute("listadoAlumnos", alumnoService.findAll());
				}
			}
			else {
				model.addAttribute("info", "Ingrese un apellido");
				model.addAttribute("listadoAlumnos", alumnoService.findAll());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "/alumno/lista";
	}
	
	@GetMapping("/search")
	public String buscarAlumnosPorDni(@RequestParam("dni") String dni, Model model) {
		try {
			if(!dni.isEmpty() && dni.length()==8) {
				Alumno a = alumnoService.findByDni(dni);
				if(a != null)
					model.addAttribute("listadoAlumnos", a);
				else {
					model.addAttribute("info", "No existe alumno con ese DNI");
					model.addAttribute("listadoAlumnos", alumnoService.findAll());
				}
			}
			else {
				model.addAttribute("info", "Ingrese un DNI correcto");
				model.addAttribute("listadoAlumnos", alumnoService.findAll());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		
		return "/alumno/lista";
	}
	
	@GetMapping("/details/{id}")
	public String detalleAlumnoPorId(@PathVariable(value = "id") Integer id, Model model) {
		try {
			Optional<Alumno> alumno = alumnoService.findById(id);
			
			if(!alumno.isPresent()) {
				model.addAttribute("info", "El alumno no existe");
				//Redirect hace redireccion con el controller <alumnos>
				return "redirect:/alumnos/lista";
			}
			else {
				model.addAttribute("alumno", alumno.get());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		//Retorna la ruta de la carpeta y archivo
		return "/alumno/details";
	}
}
