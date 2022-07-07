package com.postdata.postdata.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.postdata.postdata.CrearCuenta;
import com.postdata.postdata.Producto;

@Service
public class CrearCuentaServices {
	//definir productos //lista constante final
	public final ArrayList<CrearCuenta> lista = new ArrayList<CrearCuenta>();
	CrearCuentaServices(){
		lista.add(new CrearCuenta(0, "Cristobal", "cristobal@gmail.com", "Unapass1"));
		lista.add(new CrearCuenta(0, "Abraham", "abraham@gmail.com","Unapass2"));
		lista.add(new CrearCuenta(0, "Eric","eric@gmail.com","Unapass3"));
		lista.add(new CrearCuenta(0, "Jorge", "jorge@gmail.com", "Unapass4"));
		lista.add(new CrearCuenta(0, "Alma","alma@gmail.com","Unapass5"));
		lista.add(new CrearCuenta(0, "Christofer","christofer@gmail","Unapass6"));
	
	}
	
	public CrearCuenta addCrearCuenta(CrearCuenta crearcuenta) {
		lista.add(crearcuenta);
		return crearcuenta;
	}
	
	
}
