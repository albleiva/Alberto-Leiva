package es.arelance.libreriasursl.service;

import es.arelance.libreriasursl.model.TipoUsuario;

public interface TipoUsuarioSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<TipoUsuario> listar() throws SvcException;

}
