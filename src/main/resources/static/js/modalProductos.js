  function cargarModal(isbn){
  fetch('http://127.0.0.1:8087/api/products/')  
  .then(res => res.json())  
  .then((out) => {  
    console.log(out);  
    out.forEach(element => {
         if(element.isbn == isbn){
             document.getElementsByClassName("modalImagen")[0].src = element.url_imagen;
             document.getElementsByClassName("modalNombre")[0].innerHTML = element.nombre;
             document.getElementsByClassName("modalAutor")[0].innerHTML = "de " + element.autor;
             document.getElementsByClassName("modalISBN")[0].innerHTML = "<strong>ISBN:</strong> " + element.isbn;
             document.getElementsByClassName("modalISBNhide")[0].value = element.isbn;
             document.getElementsByClassName("modalDescripcion")[0].innerHTML ="<strong>Sinopsis: </strong>"+element.descripcion;
             document.getElementsByClassName("modalPrecio")[0].innerHTML = "$ "+element.precio+" MXN";
             }
     });
  })  
  .catch(err => {  
    throw err  
  });
 }
 
 function cargarCarrito(isbn){
    let contador2=0;
    contador2++;
    
    datosCarrito = JSON.parse(localStorage.getItem('elementosCarrito')) || [];
   
   fetch('http://127.0.0.1:8087/api/products/')  
  .then(res => res.json())  
  .then((out) => {  
    console.log("cargar carrito",out);  
        
    out.forEach(element => {

          if(element.isbn == isbn){
           let elemento = `{
            "img" : "${element.url_imagen}",
            "nombre" : "${element.nombre}",
            "cantidad" : 1, 
            "autor" : "${element.autor}",
            "isbn" : "${element.isbn}",
            "precio" : "${element.precio}",
            "id" : "${contador2}"
        }`; 

        datosCarrito.push(JSON.parse(elemento));
        localStorage.setItem("elementosCarrito", JSON.stringify(datosCarrito));
        
        swal("Producto añadido correctamente", "", "success"); //SweetAlert
       
    }


     });
  })  
  .catch(err => {  
    throw err  
  });
 
  }