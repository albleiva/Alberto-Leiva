package es.arelance.libreriasursl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.arelance.libreriasursl.model.Libro;


@Controller
public class InsertarLibro {
	
private static final String ATT_ERROR = "error"; 

private static final String SUCCESS = "insertar";
private static final String ERROR = "error";



@RequestMapping(value = "/InsertarLibro", method=RequestMethod.GET)
public String view(@ModelAttribute Libro libro, Model model) {
	try {
		return SUCCESS;
	} catch (Exception e) {
		model.addAttribute(ATT_ERROR, e);
		return ERROR;
	}
}

}