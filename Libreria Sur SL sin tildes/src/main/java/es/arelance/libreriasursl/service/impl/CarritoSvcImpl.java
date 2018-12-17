package es.arelance.libreriasursl.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.arelance.libreriasursl.model.CarritoM;
import es.arelance.libreriasursl.model.Libro;
import es.arelance.libreriasursl.service.CarritoSvc;
import es.arelance.libreriasursl.service.SvcException;

@Service
@Transactional
public class CarritoSvcImpl implements CarritoSvc{

	@Override
	public void agregar(CarritoM c, Libro l) throws SvcException {
		c.getLibro().add(l);		
	}

	@Override
	public double total(CarritoM c) {
		double res = 0.0f;
		
		for (Libro l: c.getLibro()){
			res = res + l.getPrecio() - l.getDescuento();
		}
		
		return res;
	}

}
