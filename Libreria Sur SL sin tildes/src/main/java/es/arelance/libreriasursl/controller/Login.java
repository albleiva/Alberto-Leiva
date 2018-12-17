package es.arelance.libreriasursl.controller;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.arelance.libreriasursl.interceptor.LoginInterceptor;
import es.arelance.libreriasursl.model.CarritoM;
import es.arelance.libreriasursl.model.Usuario;
import es.arelance.libreriasursl.service.UsuarioSvc;

@Controller
@SessionAttributes({"carrito","sessionUser"})
@RequestMapping(value = "/login")
public class Login {
	
	private static final String MSG_ERROR = "usuario.login.error";
	
	private static final String ATT_CARRITO = "carrito";
	private static final String FORM = "form";	
	private static final String ERROR = "form";
	private static final String SUCCESS = "home";
	
	@Autowired
	private UsuarioSvc svc;
	

	
	@RequestMapping(method=RequestMethod.GET)
    public String view(@ModelAttribute Usuario usuario, Model model) {
		return FORM;
	}
	
	@RequestMapping(method=RequestMethod.POST)
    public String execute(@Valid Usuario usuario, BindingResult result, Model model,HttpServletRequest request){
		try {
			if (result.hasFieldErrors("email") || result.hasFieldErrors("password")){
				return FORM;
			}else{
				usuario = svc.identificar(usuario);
				if (usuario == null){
					result.rejectValue("id", MSG_ERROR);
					return ERROR;
				}else{
					//Crear nuevo carrito para el cliente
//					session.setAttribute(ATT_CARRITO, new Carrito());
									
					   request.getSession().removeAttribute("sesionUser");
						model.addAttribute(ATT_CARRITO, new CarritoM());
										
					//Agregar el usuario a la sesión para el interceptor
//					session.setAttribute(LoginInterceptor.ATT_USER, usuario);
					model.addAttribute(LoginInterceptor.ATT_USER, usuario);
					return SUCCESS;
				}
			}
		} catch (Exception e) {
			result.reject(MSG_ERROR);
			return ERROR;
		}
    }
    

}
