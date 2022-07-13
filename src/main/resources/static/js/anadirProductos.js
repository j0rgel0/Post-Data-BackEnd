let rowProds = document.getElementById("list-items");

function doProduct(item){
rowProds.innerHTML+=`<div id="contenedorProducto" class="d-flex flex-column card-deck col-md-5 col-lg-3 col-xl-2" data-toggle="modal" data-target="#isbn" onclick="cargarModal(${item.isbn})">
         <img id="imagenProducto" class="card-img-top mt-2" src=${item.url_imagen}>
 
             <div class="card-body">
                 <div class="text-center">
                     <h5>${item.nombre}</h5>
                     <h6 class="text-muted"> de ${item.autor}</h6>
                 </div>
             </div>
 
             <div class="card-footer text-muted mx-auto">
                 <div class="text-center">
                     <h6>$${item.precio} MXN</h6>        
                 </div>
                 <button type="button" class="btn btn-outline-dark mt-auto">Ver</button>
             </div>
        </div>`;
}//doProduct

fetch('http://127.0.0.1:8087/api/products/', {
    method: "GET"
// Funcion anonima o de flecha.
// En este caso, función flecha.
}).then( (response) => {
    response.json().then((data) => {
        data.forEach(element => {
            doProduct(element);
                console.log(data);
                console.log(element);
        });
    // Error en el servidor, DNS están mal, no tienes conexión
    }).catch((err)=> {
        console.log("catch request "+ err);
    });
// Encontró el servidor, pero no existe el dato.
}).catch((err)=> {
    console.log("catch request "+ err);
});
