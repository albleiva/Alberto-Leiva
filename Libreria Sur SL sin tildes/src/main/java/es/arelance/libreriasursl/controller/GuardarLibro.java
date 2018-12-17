package es.arelance.libreriasursl.controller;



import es.arelance.libreriasursl.model.Libro;
import es.arelance.libreriasursl.service.LibroSvc;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GuardarLibro {
	
	public static final String ATT_ITEM = "libro";
	public static final String ATT_EXITO = "msg";
	
	public static final String SUCCESS = "forward:/ListarLibro";
	public static final String ERROR = "insertar";
	
	@Autowired
	private LibroSvc svc;
	
	
	@Autowired  
    private MessageSource messageSource;
	

	@RequestMapping(value = "/GuardarLibro", method=RequestMethod.GET)
    public String execute(@Valid Libro libro, BindingResult result, Model model, Locale locale) {
		try {
			
			//Comprobar si hay errores de entrada
			if (result.hasErrors()){
				return "insertar";
			}else{
				//Guardar
				if (libro.getId() == null){
					svc.guardar(libro);
				}else{
					svc.modificar(libro);
				}
				
			//Mensaje de �xito
			model.addAttribute(ATT_EXITO, messageSource.getMessage("mensaje.exito", null, locale));
			return SUCCESS;
			}
		} catch (Exception ex) {
			result.reject("mensaje.error");
			return ERROR;
		}
    }

}