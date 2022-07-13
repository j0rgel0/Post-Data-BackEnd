package com.postdata.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.postdata.model.Producto;
import com.postdata.services.ProductoServices;

@RestController
@RequestMapping (path="/api/products/")
@CrossOrigin(origins = "*")
public class ProductoController {

	///////////////////////////////////
	// Se manda a llamar al servicio //
	///////////////////////////////////
	private final ProductoServices productoServices;

	@Autowired
	public ProductoController(ProductoServices productoServices) {
		this.productoServices = productoServices;
	}//constructor

	///////////////////////////////////
	//     CRUD                      //
	///////////////////////////////////
	@GetMapping
	public List<Producto> getAllProducts() {
		return productoServices.getProductos();
	}//getAllProducts

	@GetMapping (path="{prodId}")
	public Producto getProduct(@PathVariable("prodId") Long id) {
		return productoServices.getProducto(id);
	}

	@DeleteMapping (path="{prodId}")
	public Producto deleteProduct(@PathVariable("prodId") Long id) {
		return productoServices.deleteProducto(id);
	}
	@PostMapping
	public Producto addProduct(@RequestBody Producto producto) {
		return productoServices.addProducto(producto);
	}
	@PutMapping (path="{prodId}")
	public Producto updateProduct (@PathVariable("prodId") Long id,
			@RequestParam (required = false)String nombre,
			@RequestParam (required = false)String autor,
			@RequestParam (required = false)String editorial,
			@RequestParam (required = false)String ISBN,
			@RequestParam (required = false)String URL_imagen,
			@RequestParam (required = false)String descripcion,
			@RequestParam (required = false)Double precio) {
		return productoServices.updateProducto(id, nombre,
				autor, editorial, ISBN, URL_imagen,descripcion,precio);
	}
}
