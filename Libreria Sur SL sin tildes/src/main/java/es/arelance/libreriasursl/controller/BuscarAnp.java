package es.arelance.libreriasursl.controller;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.libreriasursl.model.Usuario;
import es.arelance.libreriasursl.service.PedidoSvc;

@Controller
public class BuscarAnp {
	
	private static final String ATT_ITEM = "lista";


	private static final String SUCCESS = "listapedidos";
	private static final String ERROR = "error";
	
	@Autowired
	private PedidoSvc svc;
	
	@RequestMapping(value = "/BuscarAnp", method=RequestMethod.GET)
    public String execute(@Valid Usuario usuario, BindingResult result, Model model, Locale locale) {
		try {
			System.out.println("hola");
			//Comprobar si hay errores de entrada
			if (result.hasFieldErrors("apellidos") || result.hasFieldErrors("nombre")){   
				return "formAn";
			}else{
				model.addAttribute(ATT_ITEM, svc.buscarByApellidosNombre(usuario.getApellidos(),usuario.getNombre()));
	    		model.addAttribute("apellidos", usuario.getApellidos());
	    		model.addAttribute("nombre", usuario.getNombre());
				return SUCCESS;	
			}
		} catch (Exception ex) {
			result.reject("mensaje.error");
			return ERROR;
		}
    }
	

}
