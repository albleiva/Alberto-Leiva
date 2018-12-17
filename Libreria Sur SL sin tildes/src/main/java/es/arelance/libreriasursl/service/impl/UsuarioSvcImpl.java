package es.arelance.libreriasursl.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.arelance.libreriasursl.model.Usuario;
import es.arelance.libreriasursl.model.dao.DaoException;
import es.arelance.libreriasursl.model.dao.UsuarioDao;
import es.arelance.libreriasursl.service.SvcException;
import es.arelance.libreriasursl.service.UsuarioSvc;

@Service
@Transactional
public class UsuarioSvcImpl implements UsuarioSvc{
	
	private static final String URI_INICIO = "Inicio";
	private static final String URI_CARRITO = "Carrito";
	private static final String URI_LISTALIBROS = "ListarLibro";
	private static final String URI_COMPRARLIBRO = "Comprar";
	private static final String URI_CONFIRMARPEDIDO = "ConfirmarPedido";
	
	
	
	@Autowired
	private UsuarioDao dao;
	
	@Override
	public List<Usuario> buscarByApellidosNombre(String apellidos, String nombre) throws SvcException {
		List<Usuario> res = null;
		
		try{
			res = dao.findByApellidosNombre(apellidos,nombre);
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
		
		return res;
	}
	
	@Override
	public Usuario buscarByEmail(String email) throws SvcException {
		Usuario res = null;
		try{
			res = dao.findByEmail(email);
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
		
		return res;
	}
	

	@Override
	public Usuario identificar(Usuario usuario) throws SvcException {
		Usuario res = null;
		
		try{
			res = dao.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}
	
	@Override
	public boolean comprobar(Usuario usuario, String uri) throws SvcException {
		switch (usuario.getTipoUsuario().getId()){
		case 1:
			return true;
		case 2:
			return (uri.contains(URI_INICIO) || 
					uri.contains(URI_LISTALIBROS) || 
					uri.contains(URI_CARRITO) ||
					uri.contains(URI_COMPRARLIBRO) ||
					uri.contains(URI_CONFIRMARPEDIDO));
		default:
			return false;
		}
	}
}

