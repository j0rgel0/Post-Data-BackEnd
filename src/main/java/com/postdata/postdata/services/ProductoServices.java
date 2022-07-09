package com.postdata.postdata.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.postdata.postdata.Producto;

@Service
public class ProductoServices {
	//definir productos //lista constante final
	private final ProductoRepository productoRepository;

	@Autowired
	public ProductoServices(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public List<Producto> getProductos(){
		return productoRepository.findAll();
	}
	public Producto getProducto(Long id) {
		return productoRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El producto con el id"+ id + " no existe."));
	}	
	public Producto deleteProducto(Long id) {
		Producto tmpProd = null;
		if (productoRepository.existsById(id)) {
			tmpProd= productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}
		return tmpProd;
	}
	public Producto addProducto(Producto producto) {
		Producto tmpProd = null;
		Optional<Producto> prodByName = productoRepository.findByNombre(producto.getNombre());
		
		if (prodByName.isPresent()) {
			throw new IllegalArgumentException("El producto con el nombre [" + producto.getNombre() + "] ya existe");
		}else {
			productoRepository.save(producto);
			tmpProd=producto;
		}
		return tmpProd;
	}
	public Producto updateProducto(Long id, String nombre,String autor, 
			String editorial, String ISBN, String URL_imagen,String descripcion, Double precio) {
		Producto tmpProd = null;
		if(productoRepository.existsById(id)) {
				tmpProd = productoRepository.findById(id).get();
				if(nombre!=null)tmpProd.setNombre(nombre);
				if(autor!=null)tmpProd.setAutor(autor);
				if(editorial!=null)tmpProd.setEditorial(editorial);
				if(ISBN!=null)tmpProd.setISBN(ISBN);
				if(URL_imagen!=null)tmpProd.setURL_imagen(URL_imagen);
				if(descripcion!=null)tmpProd.setDescripcion(descripcion);
				if(precio!=null)tmpProd.setPrecio(precio.doubleValue());
				productoRepository.save(tmpProd);
		}else {
			System.out.println("El producto con el id"+ id + "no existe.");
		}
		return tmpProd;
	}
	
	
}//class ProductoServices