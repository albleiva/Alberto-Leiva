package es.arelance.libreriasursl.service;

import java.util.List;

import es.arelance.libreriasursl.model.Usuario;
import es.arelance.libreriasursl.model.dao.DaoException;



public interface UsuarioSvc{

	/**
	 * Guardar un registro
	 * @param Usuario elemento a guardar
	 * @throws DaoException error de bdd
	 */
	public Usuario buscarByEmail(String pEmail) throws SvcException;
	
	
	/**
	 * Busca por apellidos y nombre
	 * @param p
	 * @throws SvcException
	 */
	public List<Usuario> buscarByApellidosNombre(String apellidos, String nombre) throws SvcException;
	

	/**
	 * Identificar un usuario
	 * @param usuario
	 * @return usuario si lo encuentra, null en caso contrario
	 * @throws SvcException
	 */
	public Usuario identificar(Usuario usuario) throws SvcException; 
	
	/**
	 * Comprobar si un usuario dispone de permisos de acceso
	 * @param usuario usuario a comprobar
	 * @param uri recurso a comprobar
	 * @return true si dispone de permiso
	 * @throws SvcException
	 */
	public boolean comprobar(Usuario usuario, String uri) throws SvcException; 


}

