package es.arelance.libreriasursl.model.dao;

import java.util.List;

import es.arelance.libreriasursl.model.Pedido;



	public interface PedidoDao {

		/**
		 * Guardar un registro
		 * @param  Pedido a guardar
		 * @throws DaoException error de bdd
		 */
		public void save(Pedido pedido) throws DaoException;
		
		/** Busca todos los pedidos de un usuario
		 * 
		 * @param idUsuario identificador de usuario
		 * @return lista de todos pedidos de un usuario
		 * @throws DaoException error de bdd
		 */
		public List<Pedido> findById(int idUsuario) throws DaoException;
		
		
		/**
		 * Busca por apellidos y nombre de usuario y muestra los pedidos que tiene.
		 * @param apellidos
		 * @param nombre
		 * @return
		 * @throws DaoException
		 */
		public List<Pedido> findByApellidosNombre(String apellidos,String nombre) throws DaoException;

	}


