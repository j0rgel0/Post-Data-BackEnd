package com.postdata.services;

import java.util.List;
import java.util.Optional;

import com.postdata.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuariorepository) {
		this.usuarioRepository = usuariorepository;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Usuario con el id " + id + " no existe.")
				);
	}
	
	public Usuario deleteUsuario(Long id) {
		Usuario tmpUsuario= null;
		if (usuarioRepository.existsById(id)) {
			tmpUsuario = usuarioRepository.findById(id).get();  //return optional
			usuarioRepository.deleteById(id);  // delete no regresa, o�solo elimina
		}		
		return tmpUsuario;
	}
	
	public Usuario addUsuario(Usuario usuario) {
		Usuario tmpUsuario = null;
		Optional<Usuario> userByUsername = usuarioRepository.findByUsername(usuario.getUsername());
		if(userByUsername.isPresent()) {  // no se puede repetir con esto
			throw new IllegalStateException("El Usuario con el nombre [" + usuario.getUsername() + "] YA existe.");
		} else {
			usuarioRepository.save(usuario);
			tmpUsuario = usuario;
		}
		return tmpUsuario;
	}
	
	public Usuario updateUsuario(Long id, String password, String newPassword) {
		Usuario tmpUsuario= null;
		if (usuarioRepository.existsById(id)) {
			tmpUsuario = usuarioRepository.findById(id).get();
			if (tmpUsuario.getPassword().equals(password)) { //comparando con la contrase�a anterior
				tmpUsuario.setPassword(newPassword);
				usuarioRepository.save(tmpUsuario);
			} else {
				System.out.println("Error al comparar las contrase�as...");
			}
				//if equals password
			}
		return tmpUsuario;
	} //if

	public boolean validateUsuario(Usuario usuario) {
		boolean res = false;
		Optional<Usuario> userByUsername = usuarioRepository.findByUsername(usuario.getUsername());
		if (userByUsername.isPresent()) {
			Usuario u = userByUsername.get();
			if (u.getPassword().equals(usuario.getPassword())) {
				res = true;
			}
		}
		return res;
	}
	
	
}