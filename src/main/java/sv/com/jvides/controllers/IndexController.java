package sv.com.jvides.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class IndexController {

@Controller
@RequestMapping("/")
public class RootController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title","Asistente Hospitalario");
		return "index";
	}
}
}
