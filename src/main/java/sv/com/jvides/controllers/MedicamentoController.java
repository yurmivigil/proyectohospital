package sv.com.jvides.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.jvides.models.entities.Medicamento;
import sv.com.jvides.models.services.IMedicamentoService;

@Controller
@SessionAttributes("medicamento")
public class MedicamentoController {

	@Autowired
	private IMedicamentoService medicamentoService;
	
	@RequestMapping(value="/Medicamento", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de medicamentos");
		model.addAttribute("medicamento", medicamentoService.findAll());
		return "Medicamento";
	}
	@RequestMapping(value="/formMedicamento")
	public String crear(Map<String, Object> model) {
		Medicamento medicamento = new Medicamento();
		model.put("medicamento", medicamento);
		model.put("titulo", "Formulario de Medicamentos");
		return "formMedicamento";
	}

	@RequestMapping(value="/formMedicamento", method=RequestMethod.POST)
	public String guardar(@Valid Medicamento medicamento, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formMedicamento";
		}
		medicamentoService.save(medicamento);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Cliente creado con exito");
		return "redirect:Medicamento";
	}
	
}
