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
import sv.com.jvides.models.entities.Doctores;
import sv.com.jvides.models.entities.Ingresos;
import sv.com.jvides.models.entities.Area;
import sv.com.jvides.models.services.IIngresosService;

import sv.com.jvides.models.services.IDoctoresService;
import sv.com.jvides.models.services.AreaService;
import sv.com.jvides.models.services.IPacienteService;

@Controller
@SessionAttributes("ingresos")
public class IngresosController {



	@Autowired
	private IIngresosService IIngresosService;

	@Autowired
	private IPacienteService IPacientesService;

	@Autowired
	private IDoctoresService IDoctoresService;

	@Autowired
	private AreaService IAreaService;
	/* 
	@RequestMapping(value="/area", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de cliente");
		model.addAttribute("area", areaService.findAll());
		return "area";
	}*/
	@RequestMapping(value="/ingresos", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","lista de ingresos");
		model.addAttribute("ingresos", IIngresosService.findAll());
		return "ingresos";
	}

	@RequestMapping(value="/formIngresos")
	public String crear(Map<String, Object> model) {
		List<Pacientes> pacientes = new ArrayList<Pacientes>();
		List<Doctores> doctores = new ArrayList<Doctores>();
		List<Area> area = new ArrayList<Area>();
		
		Ingresos ingresos = new Ingresos();
		pacientes =IPacientesService.findAll();
		doctores =IDoctoresService.findAll();
		area =IAreaService.findAll();
		model.put("ingresos", ingresos);
		model.put("pacientes", pacientes);
		model.put("area", area);
		model.put("doctores", doctores);
		model.put("titulo", "Formulario de cliente");
		return "formIngresos";
	}
		
	@RequestMapping(value="/formIngresos", method=RequestMethod.POST)
	public String guardar(@Valid Ingresos ingresos, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formDoctores";
		}
		IIngresosService.save(ingresos);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Exito");
		return "redirect:ingresos";
	}
		
}
