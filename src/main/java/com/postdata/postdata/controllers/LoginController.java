package com.postdata.postdata.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.postdata.postdata.services.CrearCuentaServices;

public class LoginController {
	// Login
	private final CrearCuentaServices cuentaServices;
	
	@PostMapping("/request")
    public ResponseEntity postController(
      @RequestBody LoginForm loginForm) {
     
        //exampleService.fakeAuthenticate(loginForm);
        return ResponseEntity.ok(HttpStatus.OK);
        }
}