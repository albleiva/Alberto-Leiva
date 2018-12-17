package es.arelance.libreriasursl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.arelance.libreriasursl.model.Usuario;
import es.arelance.libreriasursl.service.UsuarioSvc;




public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public static final String ATT_USER = "sessionUser";
	private static final String INDEX = "/index.jsp";	
	private static final String LOGIN = "/login";
	
	@Autowired
	private UsuarioSvc svc;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);
        
        if(usuario == null){
        	if (!uri.endsWith(INDEX) && !uri.endsWith(LOGIN)){
        		response.sendRedirect(INDEX);
        		return false;
        	}
        }else{
           	if (!uri.endsWith(INDEX) && !uri.endsWith(LOGIN)){
        	
	        	boolean res = svc.comprobar(usuario, uri);
	        	
	        	if (!res){
	        		response.sendRedirect(INDEX);
	        		return false;
	        		        	
	        	}
        	} 	
        	
        }
        
        return true;
	}

}
