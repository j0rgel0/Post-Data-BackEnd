package com.postdata.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.postdata.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	//	Producto es de Producto.java
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	Optional<Producto> findByNombre(String nombre);
}