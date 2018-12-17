package es.arelance.libreriasursl.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import es.arelance.libreriasursl.model.Usuario;

@Controller
public class BuscarApellidosNombrePedido {

	private static final String ATT_ERROR = "error";
	private static final String SUCCESS = "formAn";
	private static final String ERROR = "error";
	
	@RequestMapping(value="/BuscarApellidosNombrePedido")
    public String execute(@ModelAttribute("usuario") Usuario usuario,Model model){
		try {	
    		
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
