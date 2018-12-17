package es.arelance.libreriasursl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para el cambio de idioma,
 * simplemente redirige a p�gina de inicio
 * @author Alberto Leiva
 *
 */
@Controller
public class Inicio {
	
	private static final String SUCCESS = "home";

	@RequestMapping(value="/Inicio", method=RequestMethod.GET)
    public String execute(Model model){
		return SUCCESS;
    }

}
