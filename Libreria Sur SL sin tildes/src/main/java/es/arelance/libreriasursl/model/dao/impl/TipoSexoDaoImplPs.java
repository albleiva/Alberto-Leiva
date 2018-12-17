package es.arelance.libreriasursl.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.libreriasursl.model.TipoSexo;
import es.arelance.libreriasursl.model.dao.DaoException;
import es.arelance.libreriasursl.model.dao.TipoSexoDao;

@Repository
public class TipoSexoDaoImplPs implements TipoSexoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoSexo> findAll() throws DaoException {		
		List<TipoSexo> res = null;
		
		try{					
			String hql = "FROM TipoSexo";			
			res = sessionFactory.getCurrentSession().createQuery(hql).list();		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}

