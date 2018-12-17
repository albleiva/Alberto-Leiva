package es.arelance.libreriasursl.model.dao;

import es.arelance.libreriasursl.model.TipoSexo;

public interface TipoSexoDao {

	/**
	 * Listado completo
	 * @return lista de usuarios
	 * @throws DaoException error al buscar
	 */
	public Iterable<TipoSexo> findAll() throws DaoException;
	
}
