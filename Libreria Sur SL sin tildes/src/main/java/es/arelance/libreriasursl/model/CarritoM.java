package es.arelance.libreriasursl.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Carrito que contendrá los productos seleccionados
 * @author ajurado
 *
 */
@Component
public class CarritoM {

	private List<Libro> lista;
	
	public CarritoM(){
		this.lista = new ArrayList<Libro>();
	}

	/**
	 * Obtener los libros que contiene el carrito
	 * @return lista de productos del carrito
	 */
	public List<Libro> getLibro() {
		return lista;
	}
	
}
