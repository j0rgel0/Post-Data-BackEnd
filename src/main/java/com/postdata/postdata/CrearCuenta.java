package com.postdata.postdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class CrearCuenta {
	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	@Column(name ="idusuarios", unique =true, nullable= false)
	private Long idUsuarios;
	@Column(name="roles_idroles")
	private Long idRol;
	private String nombre;
	private String email;
	private String contrasena;
	
	public CrearCuenta(Long idRol, String nombre, String email, String contrasena) {
		super();
		
		this.idRol = idRol;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
	}
	
	public CrearCuenta() {
	}
	public CrearCuenta(String nombre, String email, String contrasena) {
		super();
		
		this.idRol = (long) 1;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
	}
	
	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public Long getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(Long idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "CrearCuenta [idRol=" + idRol + ", idUsuarios=" + idUsuarios + ", nombre=" + nombre + ", email=" + email
				+ ", contrasena=" + contrasena + "]";
	}


}