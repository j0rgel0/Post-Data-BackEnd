package com.postdata.controllers;


import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import com.postdata.jwt.config.JwtFilter;
import com.postdata.model.Token;
import com.postdata.model.Usuario;
import com.postdata.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public LoginController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	// objeto del tipo Token es la clase que vamos a crear
	@PostMapping
	public Token login (@RequestBody Usuario usuario) throws ServletException {
		if(usuarioService.validateUsuario(usuario)) {
			return new Token(generateToken(usuario.getUsername()));
		}
		throw new ServletException("Nombre de usuario o contrase�a incorrectos.");
	}
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();  // fecha y hora actual
		calendar.add(Calendar.HOUR, 10);  // para que expire el token en 10 horas
		return Jwts.builder().setSubject(username).claim("role", "user")  // se genera web token
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())  // va a expirar dentro de...
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();  // lo vas a firmar con este alhoritmo
	}// generateToken


}

