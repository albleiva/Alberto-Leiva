package es.arelance.libreriasursl.service;

import es.arelance.libreriasursl.model.CarritoM;
import es.arelance.libreriasursl.model.Libro;

public interface CarritoSvc {
	
	/**
	 * Agregar al carrito
	 * @throws SvcException error al guardar
	 */
	public void agregar(CarritoM c, Libro p) throws SvcException;
	
	/**
	 * Calcular el precio total
	 * @param lista lista de productos
	 * @return precio total
	 */
	public double total(CarritoM c);
}
