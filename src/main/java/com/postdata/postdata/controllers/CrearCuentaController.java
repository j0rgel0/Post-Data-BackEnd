package com.postdata.postdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postdata.postdata.CrearCuenta;
import com.postdata.postdata.services.CrearCuentaServices;
import com.postdata.postdata.services.ProductoServices;

@RestController
@RequestMapping (path="/api/usuario")
public class CrearCuentaController {
	private final CrearCuentaServices cuentaServices;
	
	
	@Autowired //Inicializar una variable que no esta Inicializado
	public CrearCuentaController(CrearCuentaServices cuentaServices) {
	this.cuentaServices = cuentaServices;
	}//constructor

	
	@PostMapping
	public CrearCuenta addCrearCuenta(@RequestBody CrearCuenta crearcuenta){
		return cuentaServices.addCrearCuenta(crearcuenta);
	}

}