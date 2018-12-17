package es.arelance.libreriasursl.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.arelance.libreriasursl.service.LibroSvc;

@Controller
public class OrdenarNombre {
	
	private static final String ATT_LISTA = "lista";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "libros";
	private static final String ERROR = "error";
	
	@Autowired
	private LibroSvc svc;

	@RequestMapping(value="/OrdenarNombre", method=RequestMethod.GET)
    public String execute(Model model){
    	try {
			
    		//Listado ordenado por autor
			model.addAttribute(ATT_LISTA, svc.buscarByNeaca("nombre",2));
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
}