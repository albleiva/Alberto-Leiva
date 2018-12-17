package es.arelance.libreriasursl.service;

import java.util.List;

import es.arelance.libreriasursl.model.Pedido;

public interface PedidoSvc{

/**
 * Muestra un lista de pedido por un identificador de usuario.
 * @param idUsuario
 * @return List<Pedido>
 */
public List<Pedido> buscarById(int idUsuario) throws SvcException;

/**
 * Guarda un pedido en la BD de pedido.
 * @param pedido
 * @throws SvcException
 */
public void guardar(Pedido pedido) throws SvcException;

/**
 * Busca por apellidos y nombre de un usuario los pedidos que tiene.
 * @param apellidos
 * @param nombre
 * @return
 */
public List<Pedido> buscarByApellidosNombre(String apellidos,String nombre) throws SvcException;


}
