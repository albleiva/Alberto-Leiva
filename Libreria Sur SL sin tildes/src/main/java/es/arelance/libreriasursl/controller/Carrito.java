package es.arelance.libreriasursl.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Carrito {
	
private static final String ATT_ERROR = "error"; 

private static final String SUCCESS = "carritow";

private static final String ERROR = "error";


@RequestMapping(value = "/Carrito", method=RequestMethod.GET)
public String view(Model model) {
	try {
		return SUCCESS;
	} catch (Exception e) {
		model.addAttribute(ATT_ERROR, e);
		return ERROR;
	}
}

}