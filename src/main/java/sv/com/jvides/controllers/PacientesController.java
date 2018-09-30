package sv.com.jvides.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.jvides.models.entities.Pacientes;
import sv.com.jvides.models.services.IPacienteService;

@Controller
@SessionAttributes("pacientes")
public class PacientesController {

	@Autowired
	private IPacienteService pacientesService;
	
	@RequestMapping(value="/pacientes", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de cliente");
		model.addAttribute("pacientes", pacientesService.findAll());
		return "pacientes";
	}
	
	@RequestMapping(value="/formPacientes")
	public String crear(Map<String, Object> model) {
		Pacientes pacientes = new Pacientes();
		model.put("pacientes", pacientes);
		model.put("titulo", "Formulario de pacientes");
		return "formPacientes";
	}
	
	@RequestMapping(value="/formPacientes", method=RequestMethod.POST)
	public String guardar(@Valid Pacientes pacientes, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formPacientes";
		}
		pacientesService.save(pacientes);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Paciente creado con exito");
		return "redirect:pacientes";
	}

	@RequestMapping(value="/formPacientes/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Pacientes pacientes = null;
		if (id > 0) {
			pacientes = pacientesService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del cliente no puede ser cero");
			return "redirect:/listar";
		}
		model.put("pacientes", pacientes);
		model.put("titulo", "Editar pacientes");
		return "form";
	}
	
	@RequestMapping(value="/eliminarPacientes/{dui}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			pacientesService.delete(id);
		}
		flash.addFlashAttribute("success","Cliente eliminado con exito");
		return "redirect:/listar";
	}

	@RequestMapping(value="/verPacientes/{dui}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "dui") Long dui, Map<String, Object> model, RedirectAttributes flashl) {
		Pacientes pacientes = pacientesService.findOne(dui);
		if (pacientes == null) {
			flashl.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/pacientes";
		}

		model.put("pacientes", pacientes);
		model.put("titulo", "Editar Cliente");
		return "verPacientes";
	}

}
