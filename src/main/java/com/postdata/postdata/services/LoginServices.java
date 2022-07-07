package com.postdata.postdata.services;

import com.postdata.postdata.CrearCuenta;

public class LoginServices {
	//Selecciona un producto dos
    public CrearCuenta getCrearCuenta(String correo, String contrasena) {
    	CrearCuenta crearcuenta = null;
    	
        for (CrearCuenta cuenta:lista) {

            if(CrearCuenta.getEmail()==correo && CrearCuenta.getContrasena().equals(contrasena)) {
                crearcuenta = cuenta;
                break;
            }// if
        }//foreach
    	return crearcuenta;
    }
//	public  getProducto(String correo, String contrasena) {
//        Producto tmpProd = null;
//        System.out.println(id+" "+nombre);
//        for (Producto producto:lista) {
//
//            if(producto.getId()==id && producto.getNombre().equals(nombre)) {
//                tmpProd = producto;
//                break;
//            }// if
//        }//foreach
//        System.out.println(tmpProd);
//        return tmpProd;
//    }// getProducto
}
