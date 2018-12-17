package es.arelance.libreriasursl.service;


import es.arelance.libreriasursl.model.TipoSexo;


public interface TipoSexoSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<TipoSexo> listar() throws SvcException;

}
