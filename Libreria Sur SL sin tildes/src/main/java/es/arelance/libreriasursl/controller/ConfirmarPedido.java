package es.arelance.libreriasursl.controller;
import es.arelance.libreriasursl.model.CarritoM;
import es.arelance.libreriasursl.model.Pedido;
import es.arelance.libreriasursl.model.Usuario;
import es.arelance.libreriasursl.service.CarritoSvc;
import es.arelance.libreriasursl.service.PedidoSvc;
import es.arelance.libreriasursl.service.UsuarioSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"carrito","sessionUser"})
public class ConfirmarPedido {
	
	public static final String ATT_CARRITO = "carrito";
	
	
	public static final String SUCCESS = "resultado";
	public static final String ERROR = "error";
	
	@Autowired
	private CarritoSvc svc;
	
	@Autowired
	private UsuarioSvc uSvc;

	@Autowired
	private PedidoSvc pSvc;
	
	
	@RequestMapping(value = "/ConfirmarPedido", method=RequestMethod.POST)
    public String execute(@ModelAttribute("carrito") CarritoM carrito, @ModelAttribute ("sessionUser") Usuario usuario, Model model) {
		try{
			
			if (carrito == null){
				model.addAttribute("resultado", 0.0);
				model.addAttribute("cantidad", 0);
			}else{
				model.addAttribute("resultado", svc.total(carrito));
				model.addAttribute("cantidad", carrito.getLibro().size());
				
				Pedido pedido = new Pedido();
				
				pedido.setFechaCompra(new java.util.Date());
				pedido.setCantidad(carrito.getLibro().size());
				pedido.setImporte(new Float(svc.total(carrito)).floatValue());
				pedido.setCantidad(carrito.getLibro().size());
				Usuario u = uSvc.buscarByEmail(usuario.getEmail());
				
				if (u!=null) {
				 pedido.setUsuario(u);
		 		 pSvc.guardar(pedido);
		 		 model.addAttribute("pedido",pedido);
			    } 
				
			}						
			//Resetear el carrito
			model.addAttribute(ATT_CARRITO, new CarritoM());
			
		
			return SUCCESS;
			
		}catch (Exception e){	
			e.printStackTrace();
			model.addAttribute(ERROR, e);
			return ERROR;
		}
	
}
}
