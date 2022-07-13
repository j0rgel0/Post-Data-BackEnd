package com.postdata.controllers;

import java.util.List;

import com.postdata.model.ChangePassword;
import com.postdata.model.Usuario;
import com.postdata.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/user/")
public class UsuarioController {
	
	private final UsuarioService usuarioService;  // se est� usando el objeto no la clase

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return usuarioService.getUsuarios();
	}
	
	@GetMapping(path="{userId}")
	public Usuario getUsuario(@PathVariable("userId") Long userId) {
		return usuarioService.getUsuario(userId);
	}
	
	@DeleteMapping(path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userId") Long userId) {
		return usuarioService.deleteUsuario(userId);
	}
	
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}	
	
	// con request param se vetria contras�a
	
	@PutMapping(path="{userId}")
	public Usuario updateUsuario(@PathVariable("userId") Long userId,
			@RequestBody ChangePassword changePassword) {
		return usuarioService.updateUsuario(userId, changePassword.getPassword(), changePassword.getNewPassword());
	}

	
	
}
