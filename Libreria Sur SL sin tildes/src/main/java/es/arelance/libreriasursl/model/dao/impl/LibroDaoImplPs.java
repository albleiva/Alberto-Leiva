package es.arelance.libreriasursl.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.arelance.libreriasursl.model.Libro;
import es.arelance.libreriasursl.model.dao.DaoException;
import es.arelance.libreriasursl.model.dao.LibroDao;

@Repository
public class LibroDaoImplPs implements LibroDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Libro libro) throws DaoException{
		try{
			sessionFactory.getCurrentSession().save(libro);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
	}
	
	
	@Override
	public void update(Libro libro) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(libro);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void delete(Libro libro) throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(libro);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public Libro findById(int id) throws DaoException {
		Libro res = null;
		
		try{					
			res = (Libro) sessionFactory.getCurrentSession().get(Libro.class, id);
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> findByAll() throws DaoException{
		List<Libro> res = null;
		
		try{					
			String hql = "FROM Libro";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> findByNeaca(String neaca, int ascDesc) throws DaoException{
		List<Libro> res = new ArrayList<Libro>();
		
		try{
			String hql = "FROM Libro ";
						
			if (neaca=="nombre") {
			    hql = hql + "FETCH ALL PROPERTIES ORDER BY nombre"; 	
			}else if (neaca=="editorial") {
				hql = hql + " FETCH ALL PROPERTIES ORDER BY editorial";
			}else if (neaca=="autor") {
				hql = hql + " FETCH ALL PROPERTIES ORDER BY autor";
			}else if (neaca=="categoria") {
				hql = hql + "FETCH ALL PROPERTIES ORDER BY categoria";	
			}else if (ascDesc==0) {
				hql = hql + "FETCH ALL PROPERTIES ORDER BY precio";
			}else if (ascDesc==1) {
				hql = hql + "FETCH ALL PROPERTIES ORDER BY precio desc";
			}
			
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
			
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	
}
