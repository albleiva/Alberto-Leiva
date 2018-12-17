package es.arelance.libreriasursl.model.dao;
import java.util.List;

import es.arelance.libreriasursl.model.Usuario;

	public interface UsuarioDao {

		/**
		 * Guardar un registro
		 * @param Usuario elemento a guardar
		 * @throws DaoException error de bdd
		 */
		public void save(Usuario usuario) throws DaoException;
		
		/**
		 * Filtrar por nombre
		 * @param nombre criterio de filtrado
		 * @return lista de prodcutos
		 * @throws DaoException error de bdd
		 */
		public Usuario findByEmail(String email) throws DaoException;
		
		/**
		 * 
		 * @param apellidos
		 * @param nombre
		 * @return Busca por apellidos y nombre devolviendo un usuario.
		 * @throws DaoException
		 */
		public List<Usuario> findByApellidosNombre (String apellidos, String nombre) throws DaoException; 

		/**
		 * Buscar por email y password
		 * @param usuario
		 * @param clave
		 * @return
		 */
		public Usuario findByEmailAndPassword(String email, String password) throws DaoException;
	}
	


