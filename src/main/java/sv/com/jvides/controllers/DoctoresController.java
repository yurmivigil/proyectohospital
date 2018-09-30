package sv.com.jvides.controllers;

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

import sv.com.jvides.models.entities.Doctores;
import sv.com.jvides.models.services.IDoctoresService;
//import sv.com.jvides.models.services.TurnoService;

@Controller
@SessionAttributes("Doctores")
public class DoctoresController {
	@Autowired
	private IDoctoresService doctoresService;
	
	//@Autowired
//	private TurnoService turnoService;
	
	@RequestMapping(value="/doctores", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de cliente");
		model.addAttribute("doctores", doctoresService.findAll());
		//model.addAttribute("turnos", turnoService.findAll());
		return "doctores";
	}
	
	@RequestMapping(value="/formDoctores")
	public String crear(Map<String, Object> model) {
		Doctores doctores = new Doctores();
		model.put("doctores", doctores);
		model.put("titulo", "Formulario de cliente");
		return "formDoctores";
	}
	
	@RequestMapping(value="/formDoctores", method=RequestMethod.POST)
	public String guardar(@Valid Doctores doctores, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formDoctores";
		}
		doctoresService.save(doctores);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Doctor creado con exito");
		return "redirect:doctores";
	}
		
	@RequestMapping(value="/formDoctores/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Doctores doctores = null;
		if (id > 0) {
			doctores = doctoresService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del cliente no puede ser cero");
			return "redirect:/formDoctores"; //Aqui era "redirec:/listar";
		}
		model.put("doctores", doctores);
		model.put("titulo", "Editar Doctores");
		
		return "formDoctores"; //aqui solo era "form"
	}
	
	@RequestMapping(value="/eliminarDoctores/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			doctoresService.delete(id);
		}
		flash.addFlashAttribute("success","Cliente eliminado con exito");
		return "redirect:/doctores";
	}

	@RequestMapping(value="/verDoctores/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flashl) {
		Doctores doctores = doctoresService.findOne(id);
		if (doctores == null) {
			flashl.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/doctores";
		}

		model.put("doctores", doctores);
		model.put("titulo", "Editar Cliente");
		return "ver";
	}

}
