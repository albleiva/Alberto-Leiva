package es.arelance.libreriasursl.model.dao;

import es.arelance.libreriasursl.model.TipoUsuario;

public interface TipoUsuarioDao {

	/**
	 * Listado completo
	 * @return lista de usuarios
	 * @throws DaoException error al buscar
	 */
	public Iterable<TipoUsuario> findAll() throws DaoException;
	
}
