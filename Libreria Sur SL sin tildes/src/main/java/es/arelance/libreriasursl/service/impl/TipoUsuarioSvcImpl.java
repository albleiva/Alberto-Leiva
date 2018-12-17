package es.arelance.libreriasursl.service.impl;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.arelance.libreriasursl.model.TipoUsuario;
import es.arelance.libreriasursl.model.dao.TipoUsuarioDao;
import es.arelance.libreriasursl.service.SvcException;
import es.arelance.libreriasursl.service.TipoUsuarioSvc;

@Service
@Transactional
public class TipoUsuarioSvcImpl implements TipoUsuarioSvc{
	
	@Autowired
	private TipoUsuarioDao dao;
	
	
	@Override
	public Iterable<TipoUsuario> listar() throws SvcException {
		Iterable<TipoUsuario> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

}
