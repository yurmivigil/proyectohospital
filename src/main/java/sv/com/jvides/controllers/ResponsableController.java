package sv.com.jvides.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.jvides.models.entities.Pacientes;
import sv.com.jvides.models.entities.Responsable;
import sv.com.jvides.models.services.ICustomerService;
import sv.com.jvides.models.services.IPacienteService;
import sv.com.jvides.models.services.IResponsableService;

@Controller
@SessionAttributes("responsable")
public class ResponsableController {
	@Autowired
	private IResponsableService responsableService;
	
	@Autowired
	private IPacienteService pacientesService;
	
	@RequestMapping(value="/responsable", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de responsable");
		model.addAttribute("responsable", responsableService.findAll());
		return "responsable";
	}
	
	@RequestMapping(value="/responsable")
public String crear(Map<String, Object> model) {
	List<Responsable> pacientes = new ArrayList<Responsable>();
	Responsable responsable = new Responsable();
	model.put("pacientes", pacientes);
	model.put("responsable", responsable);
	model.put("title", "Formulario de cliente");
	return "responsable";
} /*
	@RequestMapping(value="/formResponsable")
	public String crear(Map<String, Object> model) {
		Responsable responsable = new Responsable();
		model.put("responsable", responsable);
		model.put("titulo", "Formulario de cliente");
		return "formResponsable";
	}
	*/
	@RequestMapping(value="/formResponsable", method=RequestMethod.POST)
	public String guardar(@Valid Responsable responsable, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formResponsable";
		}
		responsableService.save(responsable);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Cliente creado con exito");
		return "redirect:pacientes";
	}
	/*
	@RequestMapping(value="/formResponsable{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Responsable responsable = null;
		if (id > 0) {
			responsable = responsableService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del cliente no puede ser cero");
			return "redirect:/listar";
		}
		model.put("responsable", responsable);
		model.put("titulo", "Editar Cliente");
		
		return "formResponsable";
	}
	
	@RequestMapping(value="/eliminarResponsable/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			responsableService.delete(id);
		}
		flash.addFlashAttribute("success","Cliente eliminado con exito");
		return "redirect:/listar";
	}
	
	@RequestMapping(value="/ver/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flashl) {
		Responsable respondable = responsableService.findOne(id);
		if (respondable == null) {
			flashl.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		model.put("respondable", respondable);
		model.put("titulo", "Editar Cliente");
		return "ver";
	}*/
}

