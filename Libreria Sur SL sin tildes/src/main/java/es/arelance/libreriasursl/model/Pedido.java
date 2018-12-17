package es.arelance.libreriasursl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="pedido")

public class Pedido {
	private int id;
	private Date fechaCompra;
	private int cantidad;
	private float importe;
	private Usuario usuario;
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechacompra) {
		this.fechaCompra = fechacompra;
	}
	@NotNull
	@Range(min=0, max=1000)
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@NotNull
	@Range(min=0, max=10000)
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	@ManyToOne
	@JoinColumn(name="usuarioId")	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
