package com.postdata.postdata;

public class Producto {
	private String nombre;
	private String autor; 
	private String editorial;
	private String ISBN;
	private	String URL_imagen;
	private String descripcion;
	private double precio;
	private int id;
	private static int total = 0;
	
	public Producto(String nombre, String autor,
			String editorial, String iSBN, String uRL_imagen, String descripcion,
			double precio) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		ISBN = iSBN;
		URL_imagen = uRL_imagen;
		this.descripcion = descripcion;
		this.precio = precio;
		total++;
		this.id = total;
	}//Hey bob!
	
	public Producto() {
		total++;
		this.id = total;
	}//Hey empty bob!
	

	public int getId() {
		return id;
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
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		Producto.total = total;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", ISBN=" + ISBN
				+ ", URL_imagen=" + URL_imagen + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
}//class Producto
