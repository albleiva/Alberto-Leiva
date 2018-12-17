package es.arelance.libreriasursl.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import es.arelance.libreriasursl.model.Pedido;
import es.arelance.libreriasursl.model.dao.DaoException;
import es.arelance.libreriasursl.model.dao.PedidoDao;
import es.arelance.libreriasursl.service.PedidoSvc;
import es.arelance.libreriasursl.service.SvcException;

@Service
@Transactional
public class PedidoSvcImpl implements PedidoSvc{
	
	@Autowired
	private PedidoDao dao;
	
	
	@Override
	public List<Pedido> buscarById(int idUsuario) throws SvcException {
		List<Pedido> res = null;
		    try{
			 res = dao.findById(idUsuario);
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
	    return res;
	} 
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Pedido pedido) throws SvcException{
		
		try{
			 dao.save(pedido);
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
		
  }
	@Override
	public List<Pedido> buscarByApellidosNombre(String apellidos,String nombre) throws SvcException {
		List<Pedido> res = null;
		    try{
			 res = dao.findByApellidosNombre(apellidos,nombre);
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
	    return res;
	} 
	
}