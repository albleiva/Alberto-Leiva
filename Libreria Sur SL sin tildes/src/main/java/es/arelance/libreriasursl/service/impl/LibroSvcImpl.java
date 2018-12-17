package es.arelance.libreriasursl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.arelance.libreriasursl.model.Libro;
import es.arelance.libreriasursl.model.dao.DaoException;
import es.arelance.libreriasursl.model.dao.LibroDao;
import es.arelance.libreriasursl.service.LibroSvc;
import es.arelance.libreriasursl.service.SvcException;

@Service
@Transactional
public class LibroSvcImpl implements LibroSvc{
	
	@Autowired
	private LibroDao dao;
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Libro libro) throws SvcException {
	    try{
			 dao.save(libro);
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
		
	}
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Libro libro) throws SvcException {
		try{
			dao.update(libro);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Libro libro) throws SvcException {
		try{
			dao.delete(libro);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}
	
	@Override
	public List<Libro> listar() throws SvcException {
		List<Libro> res = null;
		    try{
			 res = dao.findByAll();
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
	    return res;
	} 
	
	@Override
	public List<Libro> buscarByNeaca(String neaca,int ascDesc) throws SvcException{
		List<Libro> res = null;
		
		try{
			res = dao.findByNeaca(neaca,ascDesc);
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
		
		return res;
	}
	
	@Override
	public Libro buscar(Integer id) throws SvcException {
		Libro res = null;
		
		try{
			res = dao.findById(id);
		}catch (DaoException ex){
			throw new SvcException(ex);
		}
		
		return res;
	}
}