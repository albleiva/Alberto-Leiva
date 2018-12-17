package es.arelance.libreriasursl.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.libreriasursl.model.TipoUsuario;
import es.arelance.libreriasursl.model.dao.DaoException;
import es.arelance.libreriasursl.model.dao.TipoUsuarioDao;


@Repository
public class TipoUsuarioDaoImplPs implements TipoUsuarioDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoUsuario> findAll() throws DaoException {		
		List<TipoUsuario> res = null;
		
		try{					
			String hql = "FROM TipoUsuario";			
			res = sessionFactory.getCurrentSession().createQuery(hql).list();		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}

