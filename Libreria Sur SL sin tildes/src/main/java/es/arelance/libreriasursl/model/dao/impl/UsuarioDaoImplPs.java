package es.arelance.libreriasursl.model.dao.impl;


import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.libreriasursl.model.Usuario;
import es.arelance.libreriasursl.model.dao.DaoException;
import es.arelance.libreriasursl.model.dao.UsuarioDao;

@Repository
public class UsuarioDaoImplPs implements UsuarioDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
    /**
     * Encuentra por email a un usuario y devuelve el usuario.
     */
	
	@Override
	public Usuario findByEmail(String email) throws DaoException {
		Usuario res = null;
		
		try{
			String hql = "FROM Usuario u WHERE u.email = :email";
			res = (Usuario)sessionFactory.getCurrentSession().createQuery(hql).
					        setParameter("email",email).uniqueResult();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override
		public List<Usuario> findByApellidosNombre(String apellidos, String nombre) throws DaoException {
		List<Usuario> res = null;
		
		try{					
			String hql = "FROM Usuario u WHERE u.apellidos = :apellidos AND u.nombre = :nombre " +
					 	  "FETCH ALL PROPIERTIES ORDER BY apellidos,nombre";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("apellidos", apellidos).setParameter("nombre", nombre)
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	
		
		return res;
	}
	
	@Override
	public Usuario findByEmailAndPassword(String email, String password) throws DaoException {
		Usuario res = null;
		
		try{
			String hql = "FROM Usuario u WHERE u.email = :email AND u.password = :password";
			res = (Usuario)sessionFactory.getCurrentSession().createQuery(hql).
					        setParameter("email",email).
					        setParameter("password",password).uniqueResult() ;
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}


	@Override
	public void save(Usuario usuario) throws DaoException {
		// TODO Auto-generated method stub
		
	}
}
