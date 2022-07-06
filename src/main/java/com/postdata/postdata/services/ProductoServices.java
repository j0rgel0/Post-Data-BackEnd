package com.postdata.postdata.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.postdata.postdata.Producto;

@Service
public class ProductoServices {
	//definir productos //lista constante final
	public final ArrayList<Producto> lista = new ArrayList<Producto>();
	ProductoServices(){
		lista.add(new Producto("La estafa maestra: La historia del desfalco", 
				"Manuel Ureste Cava", 
				"Planeta M�xico", 
				"9786070787126",
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9786070787126_b19c.jpg",
				"La ma�ana del 13 de agosto de 2019, la historia pol�tica modernade M�xico cambi�. Por primera vez en nuestro pa�s, una secretaria de Estado era encarcelada a ra�z de una investigaci�n period�stica. Rosario Robles ingres� al penal de Santa Martha Acatitlaacusada de ejercicio indebido de la funci�n p�blica y, hasta lafecha, sigue presa. La Estafa Maestra �Premio Nacional de Periodismo 2017 y Premio Ortega y Gasset 2018� devel� el multimillonario desfalco de dinero p�blico bajo un esquema de corrupci�n que involucraba a miembros del gabinete del expresidente Pe�a Nieto, universidades p�blicas y empresas fantasma. De todos los altos mandos involucrados solo Robles, exsecretaria de la Sedesol y de la Sedatu y una vieja adversaria del presidente L�pez Obrador, ha sido encarcelada y paga un castigo que asoma oscuros motivos pol�ticos. A partir de entrevistas in�ditas, un minucioso seguimiento de la investigaci�n a tres a�os de la publicaci�n original y una implacable cobertura de los juicios, los periodistas Nayeli Rold�n y Manuel Ureste relatan, a manera de thriller pol�tico, la historia detr�s de La Estafa Maestra y dan a conocer a los orquestadores de uno de los peores desfalcos que M�xico ha conocido y cuya maquinaria contin�a intacta para seguir operando.",
				268.00));
		lista.add(new Producto("El infinito en un junco",
				"Irene Vallejo", 
				"Debolsillo",
				"9786073804332",
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9786073804332_695a.jpg",
				"La historia de los libros, el alfabeto, las bibliotecas... contada con erudici�n y amenidad,sentido del humor y elegancia, bhaciendo paralelismos con el presente.Laura Freixas. En esta obra exquisita sobre los or�genes del libro, Irene Vallejo recorre la historia del asombroso artefacto que naci� hace cinco milenios, cuando los egipcios descubrieron el potencial de un junco al que llamaron papiro. Con gran sensibilidad y soltura narrativa, la autora se remonta a los campos de batalla de Alejandro, los palacios de Cleopatra, las primeras librer�as y los talleres de copia manuscrita, pero tambi�n visita las hogueras donde ardieron c�dices prohibidos, la biblioteca de Sarajevo y el laberinto subterr�neo de Oxford en el a�o 2000. Los tiempos se funden en la aventura colectiva de quienes solo han concebido la vida en compa��a de la palabra escrita. Y este ensayo acaba prolongando el di�logo infinito del que tan magistralmente nos habla. Un relato po�tico y preciso de cuando los libros eran j�venes y todo suced�a por primera vez. H�ctor Abad Faciolince El infinito en un junco nos permite volver a tener esperanza en nosotros mismos y en nuestra imaginaci�n. La gran empresa del libro es una de nuestras grandes conquistas como especie.",
				399.00));
		lista.add(new Producto("Los juegos del hambre: En llamas",
				"Suzanne Collins",
				"Molino", 
				"9786073807852", 
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9786073807852_ddec.jpg", "El mundo estar� observando.Katniss Everdeen sobrevivi� a Los Juegos del Hambre, pero el Capitolio quiere venganza.Contra todo pron�stico, Katniss Everdeen y Peeta Mellark siguen vivos.",
				359.00));
		lista.add(new Producto("Contemporary Japanese Architecture", 
				"Philip Jodidio", 
				"TASCHEN",
				"9783836575119",
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9783836575119_7f0d.jpg", 
				"Un estudio de ",
				1649.00));
		lista.add(new Producto("�ltimos d�as de mis padres",
				"M�nica Lav�n",
				"Planeta M�xico",
				"9786070787300",
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9786070787300_4c53.jpg",
				"Cuando el padre de la narradora muere, lejos est� de imaginar que tan solo un a�o despu�s tendr�a que enfrentar tambi�n la p�rdida de su madre. A partir de este golpe tan doloroso como real, los recuerdos y las emociones ir�n tejiendo un texto donde la fuerza de la sinceridad da paso a una prosa �ntima y poderosa, que indaga sobre la orfandad y la necesidad de reconstruir el origen: qui�nes fueron los padres, los distintos exilios por los que pasaron para encontrarse en la Ciudad de M�xico, las penurias que marcaron sus infancias, las vacaciones familiares, la separaci�n y el rencuentro final.   M�nica Lav�n nos ofrece su obra m�s personal y emotiva, reafirm�ndose como una de las escritoras m�s talentosas de su generaci�n. Frente a la pena de la ausencia, en �ltimos d�as de mis padres queda el recuerdo de lo vivido, el aprendizaje de un camino recorrido y, por �ltimo, la literatura como una forma de celebrar la vida.", 
				268.00));
	}//bob
	
	public ArrayList<Producto> getProductos(){
		return lista;
	}
	public Producto getProducto(int id) {
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if(producto.getId()==id) {
				tmpProd=producto;
				break;
			}
		}//foreach
		return tmpProd;
	}//getProducto
	
	
	
	public Producto deleteProducto(int id) {
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if(producto.getId()==id) {
				tmpProd=lista.remove(lista.indexOf(producto));
				break;
			}
		}//foreach
		return tmpProd;
	}//deleteProducto
	public Producto addProducto(Producto producto) {
		lista.add(producto);
		return producto;
	}
	public Producto updateProducto(int id, String nombre,String autor, 
			String editorial, String ISBN, String URL_imagen,String descripcion, Double precio) {
		Producto tmpProd = null;
		for(Producto producto : lista) {
			if(producto.getId()==id) {
				if(nombre!=null)producto.setNombre(nombre);
				if(autor!=null)producto.setAutor(autor);
				if(editorial!=null)producto.setEditorial(editorial);
				if(ISBN!=null)producto.setISBN(ISBN);
				if(URL_imagen!=null)producto.setURL_imagen(URL_imagen);
				if(descripcion!=null)producto.setDescripcion(descripcion);
				if(precio!=null)producto.setPrecio(precio.doubleValue());
				tmpProd = producto;
				break;
			}
		}
		return tmpProd;
	}
	
}//class ProductoServices