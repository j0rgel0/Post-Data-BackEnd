package com.postdata.services;

import java.util.Optional;
import com.postdata.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//				alias	nombre clase		nombreColumnaMySQL
	@Query("SELECT u From Usuario u WHERE u.username=?1")
	Optional<Usuario> findByUsername (String username);
	//Query para buscar el nombre y evitar que se repita
}

