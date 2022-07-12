package com.postdata.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postdata.model.CrearCuenta;

@Service
public class CrearCuentaServices {
	//definir productos //lista constante final
	private final CrearCuentaRepository crearCuentaRepository;
	
	@Autowired
	public CrearCuentaServices(CrearCuentaRepository crearCuentaRepository) {
		this.crearCuentaRepository = crearCuentaRepository;
	}
	
	public CrearCuenta addCrearCuenta(CrearCuenta crearcuenta) {
		CrearCuenta tmpProd = null;
		Optional<CrearCuenta> prodByName = crearCuentaRepository.findByEmail(crearcuenta.getEmail());
		
		if (prodByName.isPresent()) {
			throw new IllegalArgumentException("El correo" +
					crearcuenta.getEmail() + "] ya está registrado");
		}else {
			crearCuentaRepository.save(crearcuenta);
			tmpProd=crearcuenta;
		}
		return tmpProd;
	}
	
	public boolean login (String correo, String contrasena) {
		boolean autorizacion = false;
		Optional<CrearCuenta>prodByLogin = crearCuentaRepository.findByEmailAndContrasena(correo,contrasena);
		if(prodByLogin.isPresent()) {
			autorizacion = true;
			System.out.println("Inicio de sesión exitoso");
		}else {
			System.out.println("Inicio de sesión fallido");
		}
		return autorizacion;
	}//login
	
	
}