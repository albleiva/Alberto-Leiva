package es.arelance.libreriasursl.service;

import java.util.List;

import es.arelance.libreriasursl.model.Libro;
import es.arelance.libreriasursl.model.dao.DaoException;



public interface LibroSvc{

/**
 * Guardar un registro
 * @param Libro elemento a guardar
 * @throws SvcException error de bdd
 */
public void guardar(Libro libro) throws SvcException;


/**
 * Actualizar un elemento
 * @param libro elemento a actualizar
 * @throws SvcException
 */
public void modificar(Libro libro) throws SvcException;

/**
 * Eliminar un elemento
 * @param libro elemento a eliminar
 * @throws SvcException
 */
public void eliminar(Libro libro) throws SvcException;


/**
 * Filtrar por nombre,autor,editorial,categoria,acdDesc tendrá 0 ó 1 ó 2
 * 0 ordena acedentemente por precio.
 * 1 ordena descendemente por precio.
 * 2 no hace nada.
 * Meto "nombre" en nombre para que la comparación sea distinto de null.
 * findByNombre("nombre",2)
 * findByNaec("autor",2)
 * findByNaec(null,1)
 * @param nombre criterio de filtrado
 * @return lista de productos
 * @throws DaoException error de bdd
 */
public List<Libro> buscarByNeaca(String neaca, int ascDesc) throws SvcException;

/**
 * Lista los libro que hay.
 * @return
 * @throws SvcException
 */
public List<Libro> listar() throws SvcException;

/**
 * Buscar por id
 * @param id criterio de búsqueda
 * @return elemento buscado, null si no lo encuentra
 * @throws SvcException error al buscar
 */
public Libro buscar(Integer id) throws SvcException;

}