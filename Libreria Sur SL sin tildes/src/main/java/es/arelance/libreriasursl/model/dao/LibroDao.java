package es.arelance.libreriasursl.model.dao;

import java.util.List;

import es.arelance.libreriasursl.model.Libro;


public interface LibroDao {

/**
 * Guardar un registro
 * @param libro elemento a guardar
 * @throws DaoException error de bdd
 */
public void save(Libro libro) throws DaoException;

/**
 * Actualizar un registro
 * @param libro elemento a actualizar
 * @throws DaoException error de bdd
 */
public void update(Libro libro) throws DaoException;

/**
 * Eliminar un registro
 * @param libro elemento a eliminar
 * @throws DaoException error de bdd
 */
public void delete(Libro libro) throws DaoException;

/**
 * Listar todos los elementos
 * @return lista completa de elementos
 * @throws DaoException
 */
public List<Libro> findByAll() throws DaoException;
		
/**
 * Filtrar por nombre,autor,editorial,categoria,acdDesc tendrá 0 ó 1 ó 2
 * 0 ordena acedentemente por precio.
 * 1 ordena descendemente por precio.
 * 2 no hace nada.
 * findByNombre('Arturo Peréz Reverte,null,null,null,2)
 * @param nombre criterio de filtrado
 * @return lista de prodcutos
 * @throws DaoException error de bdd
 */
public List<Libro> findByNeaca(String neaca,int ascDesc) throws DaoException;


/**Busca un libro por id en la BD de libro
 * 
 * @param id
 * @return
 * @throws DaoException
 */
public Libro findById(int id) throws DaoException;
		
}


