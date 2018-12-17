package es.arelance.libreriasursl.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.arelance.libreriasursl.model.TipoSexo;
import es.arelance.libreriasursl.model.dao.TipoSexoDao;
import es.arelance.libreriasursl.service.SvcException;
import es.arelance.libreriasursl.service.TipoSexoSvc;

@Service
@Transactional
public class TipoSexoSvcImpl implements TipoSexoSvc{
	
	@Autowired
	private TipoSexoDao dao;
	
	
	@Override
	public Iterable<TipoSexo> listar() throws SvcException {
		Iterable<TipoSexo> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

}
