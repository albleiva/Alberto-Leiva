package es.arelance.libreriasursl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.arelance.libreriasursl.service.LibroSvc;



@Controller
public class BuscarLibro {
	
	private static final String ATT_ITEM = "libro";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "insertar";
	private static final String ERROR = "error";
	
	@Autowired
	private LibroSvc svc;
	
	
	@RequestMapping(value="/BuscarLibro", method=RequestMethod.GET)
    public String execute(@RequestParam int id, Model model){
    	try {
			model.addAttribute(ATT_ITEM, svc.buscar(id));
						
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
