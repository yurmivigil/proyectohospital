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

import sv.com.jvides.models.entities.Area;
import sv.com.jvides.models.services.AreaService;

@Controller
@SessionAttributes("area")
public class AreaController {


	@Autowired
	private AreaService areaService;
	/* 
	@RequestMapping(value="/area", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de cliente");
		model.addAttribute("area", areaService.findAll());
		return "area";
	}*/
	@RequestMapping(value="/area", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de cliente");
		model.addAttribute("area", areaService.findAll());
		return "area";
	}

	@RequestMapping(value="/formArea")
	public String crear(Map<String, Object> model) {
		Area area = new Area();
		model.put("area", area);
		model.put("titulo", "Formulario de Area");
		return "formArea";
	}
	
	@RequestMapping(value="/formArea", method=RequestMethod.POST)
	public String guardar(@Valid Area Area, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formArea";
		}
		areaService.save(Area);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Area creado con exito");
		return "redirect:area";
	}
	
	@RequestMapping(value="/formArea/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Area area = null;
		if (id > 0) {
			area = areaService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del cliente no puede ser cero");
			return "redirect:/area";
		}
		model.put("area", area);
		model.put("titulo", "Editar Cliente");
		
		return "formArea";
	}
	
	@RequestMapping(value="/eliminarArea/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			areaService.delete(id);
		}
		flash.addFlashAttribute("success","Cliente eliminado con exito");
		return "redirect:/area";
	}
	
	@RequestMapping(value="/verArea/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flashl) {
		Area area = areaService.findOne(id);
		if (area == null) {
			flashl.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/area";
		}

		model.put("area", area);
		model.put("titulo", "Editar Cliente");
		return "ver";
	}
	
	
}
