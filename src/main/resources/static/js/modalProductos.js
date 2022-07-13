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
    datosCarrito = JSON.parse(localStorage.getItem('elementosCarrito')) || [];
    datos = JSON.parse(localStorage.getItem("productos")) ;
    datosObjeto = JSON.parse(localStorage.getItem('objeto')) || [];
    datos.forEach(element => {
        contador2++;
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
        console.log(contador2);
        let objeto = `{
            "id" : "${contador2}"
        }`; 
        datosObjeto.forEach(element => { 
            if(element.id == contador2){
                console.log("Ya existe");
            }
        })
        datosObjeto.push(JSON.parse(objeto));
        datosCarrito.push(JSON.parse(elemento));
        localStorage.setItem("elementosCarrito", JSON.stringify(datosCarrito));
        localStorage.setItem("objeto", JSON.stringify(datosObjeto));
        swal("Producto añadido correctamente", "", "success"); //SweetAlert
       
    }
    });
  }