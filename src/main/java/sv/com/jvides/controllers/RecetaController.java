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

import sv.com.jvides.models.entities.Receta;
import sv.com.jvides.models.services.RecetaService;
import sv.com.jvides.models.entities.Medicamento;
import sv.com.jvides.models.services.IMedicamentoService;

@Controller
@SessionAttributes("Receta")
public class RecetaController {
	@Autowired
	private RecetaService recetasService;
	@Autowired
	private IMedicamentoService IMedicamentoService;
	
	@RequestMapping(value="/Receta", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de Receta");
		model.addAttribute("Receta", recetasService.findAll());
		return "Receta";
	}
	
	@RequestMapping(value="/formReceta")
	public String crear(Map<String, Object> model) {
		List<Medicamento> medicamento= new ArrayList<Medicamento>();
		Receta Receta = new Receta();
		medicamento = IMedicamentoService.findAll();
		model.put("Receta", Receta);
		model.put("medicamento", medicamento);
		model.put("titulo", "Formulario de Receta");
		return "formReceta";
	}
	
	@RequestMapping(value="/formReceta", method=RequestMethod.POST)
	public String guardar(@Valid Receta Receta, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formReceta";
		}
		recetasService.save(Receta);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Receta creado con exito");
		return "redirect:Receta";
	}
		
	@RequestMapping(value="/formReceta/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Receta Receta = null;
		if (id > 0) {
			Receta= recetasService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del cliente no puede ser cero");
			return "redirect:/Receta";
		}
		model.put("Receta", Receta);
		model.put("titulo", "Editar Recetas");
		
		return "formReceta";
	}
	
	@RequestMapping(value="/eliminarReceta/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			recetasService.delete(id);
		}
		flash.addFlashAttribute("success","Receta eliminado con exito");
		return "redirect:/Receta";
	}

	@RequestMapping(value="/verReceta/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flashl) {
		Receta Receta = recetasService.findOne(id);
		if (Receta == null) {
			flashl.addFlashAttribute("error", "La receta no existe en la base de datos");
			return "redirect:/Receta";
		}

		model.put("Receta", Receta);
		model.put("titulo", "Editar Receta");
		return "verReceta";
	}
	}

