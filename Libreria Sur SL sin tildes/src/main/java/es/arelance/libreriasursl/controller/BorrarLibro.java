package es.arelance.libreriasursl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.libreriasursl.model.Libro;
import es.arelance.libreriasursl.service.LibroSvc;



@Controller
public class BorrarLibro {
	
	private static final String ATT_ERROR = "error"; 

	private static final String SUCCESS = "forward:/ListarLibro";
	private static final String ERROR = "error";
	
	@Autowired
	private LibroSvc svc;
	
	@RequestMapping(value="/BorrarLibro", method=RequestMethod.GET)
    public String borrar(@RequestParam int id, Model model){
		try {
			Libro l = new Libro();
			l.setId(id);
			
			svc.eliminar(l);
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
