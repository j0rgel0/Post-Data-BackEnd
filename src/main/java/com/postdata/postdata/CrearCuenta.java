package com.postdata.postdata;

public class CrearCuenta {
	
	private int idRol;
	private int idUsuarios;
	private String nombre;
	private String email;
	private String contrasena;
	private static int total = 0;
	
	public CrearCuenta(int idRol, String nombre, String email, String contrasena) {
		super();
		
		this.idRol = idRol;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
		total ++;
        this.idUsuarios=total;
	}
	
	public CrearCuenta() {
		total ++;
        this.idUsuarios=total;	
	}
	public CrearCuenta(String nombre, String email, String contrasena) {
		super();
		
		this.idRol = 1;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
		total ++;
        this.idUsuarios=total;
	}
	
	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public int getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
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