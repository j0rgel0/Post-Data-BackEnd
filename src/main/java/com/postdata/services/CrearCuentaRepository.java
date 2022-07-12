package com.postdata.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.postdata.model.CrearCuenta;
import com.postdata.model.Producto;

public interface CrearCuentaRepository extends JpaRepository<CrearCuenta, Long>{
	
	@Query("SELECT p FROM CrearCuenta p WHERE p.email=?1")
	Optional<CrearCuenta> findByEmail(String email);

	@Query("SELECT t FROM CrearCuenta t WHERE t.email=?1 AND t.contrasena=?2")
	Optional<CrearCuenta> findByEmailAndContrasena(String email, String contrasena);

}
