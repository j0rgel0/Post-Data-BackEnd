package com.postdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postdata.services.CrearCuentaServices;
@RestController
@RequestMapping (path="/api/request")
public class LoginController {
	// Login
	private final CrearCuentaServices cuentaServices;
	
	@Autowired //
	public LoginController(CrearCuentaServices cuentaServices) {
	this.cuentaServices = cuentaServices;
	}//constructor
	
	@PostMapping
	public boolean login(
		@RequestParam(required = true) String correo,
		@RequestParam(required = true) String contrasena){
		return cuentaServices.login(correo,contrasena);		
	}//login
}