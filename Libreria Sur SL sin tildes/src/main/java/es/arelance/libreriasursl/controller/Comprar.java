package es.arelance.libreriasursl.controller;
import es.arelance.libreriasursl.model.CarritoM;
import es.arelance.libreriasursl.model.Libro;
import es.arelance.libreriasursl.service.CarritoSvc;
import es.arelance.libreriasursl.service.LibroSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("carrito")
public class Comprar {
	
	public static final String ATT_EXITO = "msg";
	public static final String SUCCESS = "carritow";
	public static final String ERROR = "error";
	
	@Autowired
	private CarritoSvc cSvc;
	
	@Autowired
	private LibroSvc lSvc;
		
		
	@RequestMapping(value = "/Comprar", method=RequestMethod.GET)
    public String view(@RequestParam Integer id,@ModelAttribute("carrito") CarritoM carrito,Model model) {
		try{
			
			Libro libro = lSvc.buscar(id);

			//Agregar producto
			cSvc.agregar(carrito, libro);
			
			return SUCCESS;
			
		}catch (Exception ex){		
		
			model.addAttribute(ERROR, ex);
			return ERROR;
		}
		
	}
}