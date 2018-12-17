package es.arelance.libreriasursl.model.dao.impl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.libreriasursl.model.Pedido;
import es.arelance.libreriasursl.model.dao.DaoException;
import es.arelance.libreriasursl.model.dao.PedidoDao;


@Repository
public class PedidoDaoImplPs implements PedidoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Pedido pedido) throws DaoException{
		try{
			sessionFactory.getCurrentSession().save(pedido);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
		public List<Pedido> findById(int id) throws DaoException {
		List<Pedido> res = null;
		
		try{					
			String hql = "FROM Pedido p WHERE p.usuarioid = :idusuario";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("idusuario", id)
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override
		public List<Pedido> findByApellidosNombre(String apellidos,String nombre) throws DaoException {
		List<Pedido> res = null;
		
		try{					
			String hql = "FROM Pedido p WHERE upper(p.usuario.apellidos)=upper(:apellidos) " +
		                 "AND upper(p.usuario.nombre)=upper(:nombre)";
			res = sessionFactory.getCurrentSession().createQuery(hql).setParameter("apellidos",apellidos).
				  setParameter("nombre",nombre).list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	
		
		return res;
	}
	
	
	
	
	
}
