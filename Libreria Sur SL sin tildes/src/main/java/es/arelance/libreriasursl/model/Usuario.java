package es.arelance.libreriasursl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="usuario")
public class Usuario {
		
		private Integer id;
		private String nombre;
		private String apellidos;
		private String direccion;
		private Integer cp;
		private String poblacion;
		private Integer movil;
		private String email;
		private String password;
		private Date fechaAlta;
		private TipoSexo sexo;
		private TipoUsuario tipoUsuario;
				
		@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		@NotEmpty
		@Column(name = "nombre", columnDefinition = "varchar(50) COLLATE utf8_bin")
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		@NotEmpty
		@Column(name = "apellidos", columnDefinition = "varchar(75) COLLATE utf8_bin")
		public String getApellidos() {
			return apellidos;
		}		
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		@NotEmpty
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		@NotNull
		@Range(min=0, max=9999)
		public Integer getCp() {
			return cp;
		}
		public void setCp(Integer cp) {
			this.cp = cp;
		}
		@NotEmpty
		public String getPoblacion() {
			return poblacion;
		}
		public void setPoblacion(String poblacion) {
			this.poblacion = poblacion;
		}
		@NotNull
		@Range(min=0, max=800000000)
		public Integer getMovil() {
			return movil;
		}
		public void setMovil(Integer movil) {
			this.movil = movil;
		}
		@NotEmpty
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@NotEmpty
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@NotNull
		@Temporal(TemporalType.DATE)
		public Date getFechaAlta() {
			return fechaAlta;
		}
		public void setFechaAlta(Date fechaAlta) {
			this.fechaAlta = fechaAlta;
		}
		@ManyToOne
		@JoinColumn(name="tipoSexo")
		public TipoSexo getSexo() {
			return sexo;
		}
		public void setSexo(TipoSexo sexo) {
			this.sexo = sexo;
		}
		@ManyToOne
		@JoinColumn(name="tipoId")		
		public TipoUsuario getTipoUsuario() {
			return tipoUsuario;
		}
		public void setTipoUsuario(TipoUsuario tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}
}
