package com.postdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libros")

public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	@Column(name ="idlibros", unique =true, nullable= false)
	private Long id;
	@Column(name="titulo")
	private String nombre;
	private String autor; 
	private String editorial;
	private String ISBN;
	@Column(name="urlimagen")
	private	String URL_imagen;
	private String descripcion;
	private double precio;

	public Producto(Long id,String nombre, String autor,
			String editorial, String iSBN, String uRL_imagen, String descripcion,
			double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		ISBN = iSBN; //No lleva this porque tienen diferente nombre
		URL_imagen = uRL_imagen; //No lleva this porque tienen diferente nombre
		this.descripcion = descripcion;
		this.precio = precio;
	}//Hey bob!

	public Producto() {
	}//Hey empty bob!
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getURL_imagen() {
		return URL_imagen;
	}

	public void setURL_imagen(String uRL_imagen) {
		URL_imagen = uRL_imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", ISBN="
				+ ISBN + ", URL_imagen=" + URL_imagen + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}

}//class Producto



