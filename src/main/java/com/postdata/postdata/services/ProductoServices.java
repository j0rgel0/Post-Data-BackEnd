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
				"Planeta México", 
				"9786070787126",
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9786070787126_b19c.jpg",
				"La mañana del 13 de agosto de 2019, la historia política modernade México cambió. Por primera vez en nuestro país, una secretaria de Estado era encarcelada a raíz de una investigación periodística. Rosario Robles ingresó al penal de Santa Martha Acatitlaacusada de ejercicio indebido de la función pública y, hasta lafecha, sigue presa. La Estafa Maestra —Premio Nacional de Periodismo 2017 y Premio Ortega y Gasset 2018— develó el multimillonario desfalco de dinero público bajo un esquema de corrupción que involucraba a miembros del gabinete del expresidente Peña Nieto, universidades públicas y empresas fantasma. De todos los altos mandos involucrados solo Robles, exsecretaria de la Sedesol y de la Sedatu y una vieja adversaria del presidente López Obrador, ha sido encarcelada y paga un castigo que asoma oscuros motivos políticos. A partir de entrevistas inéditas, un minucioso seguimiento de la investigación a tres años de la publicación original y una implacable cobertura de los juicios, los periodistas Nayeli Roldán y Manuel Ureste relatan, a manera de thriller político, la historia detrás de La Estafa Maestra y dan a conocer a los orquestadores de uno de los peores desfalcos que México ha conocido y cuya maquinaria continúa intacta para seguir operando.",
				268.00));
		lista.add(new Producto("El infinito en un junco",
				"Irene Vallejo", 
				"Debolsillo",
				"9786073804332",
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9786073804332_695a.jpg",
				"La historia de los libros, el alfabeto, las bibliotecas... contada con erudición y amenidad,sentido del humor y elegancia, bhaciendo paralelismos con el presente.Laura Freixas. En esta obra exquisita sobre los orígenes del libro, Irene Vallejo recorre la historia del asombroso artefacto que nació hace cinco milenios, cuando los egipcios descubrieron el potencial de un junco al que llamaron papiro. Con gran sensibilidad y soltura narrativa, la autora se remonta a los campos de batalla de Alejandro, los palacios de Cleopatra, las primeras librerías y los talleres de copia manuscrita, pero también visita las hogueras donde ardieron códices prohibidos, la biblioteca de Sarajevo y el laberinto subterráneo de Oxford en el año 2000. Los tiempos se funden en la aventura colectiva de quienes solo han concebido la vida en compañía de la palabra escrita. Y este ensayo acaba prolongando el diálogo infinito del que tan magistralmente nos habla. Un relato poético y preciso de cuando los libros eran jóvenes y todo sucedía por primera vez. Héctor Abad Faciolince El infinito en un junco nos permite volver a tener esperanza en nosotros mismos y en nuestra imaginación. La gran empresa del libro es una de nuestras grandes conquistas como especie.",
				399.00));
		lista.add(new Producto("Los juegos del hambre: En llamas",
				"Suzanne Collins",
				"Molino", 
				"9786073807852", 
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9786073807852_ddec.jpg", "El mundo estará observando.Katniss Everdeen sobrevivió a Los Juegos del Hambre, pero el Capitolio quiere venganza.Contra todo pronóstico, Katniss Everdeen y Peeta Mellark siguen vivos.",
				359.00));
		lista.add(new Producto("Contemporary Japanese Architecture", 
				"Philip Jodidio", 
				"TASCHEN",
				"9783836575119",
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9783836575119_7f0d.jpg", 
				"Un estudio de ",
				1649.00));
		lista.add(new Producto("Últimos días de mis padres",
				"Mónica Lavín",
				"Planeta México",
				"9786070787300",
				"https://www.gandhi.com.mx/media/catalog/product/9/7/9786070787300_4c53.jpg",
				"Cuando el padre de la narradora muere, lejos está de imaginar que tan solo un año después tendría que enfrentar también la pérdida de su madre. A partir de este golpe tan doloroso como real, los recuerdos y las emociones irán tejiendo un texto donde la fuerza de la sinceridad da paso a una prosa íntima y poderosa, que indaga sobre la orfandad y la necesidad de reconstruir el origen: quiénes fueron los padres, los distintos exilios por los que pasaron para encontrarse en la Ciudad de México, las penurias que marcaron sus infancias, las vacaciones familiares, la separación y el rencuentro final.   Mónica Lavín nos ofrece su obra más personal y emotiva, reafirmándose como una de las escritoras más talentosas de su generación. Frente a la pena de la ausencia, en Últimos días de mis padres queda el recuerdo de lo vivido, el aprendizaje de un camino recorrido y, por último, la literatura como una forma de celebrar la vida.", 
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