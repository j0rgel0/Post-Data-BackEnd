// console.clear();
let element = document.getElementById("totalPrecio");
let tabla = document.getElementById("tablaListaCompras");
let agregar2 = document.getElementById("btnAgregar");
let contador2 = 0;
let costoTotal = 0;
let total = document.getElementById("precioTotal");
let totalEnProductos = 0;

let botonEnviar = document.querySelector("#botonEnviar");

botonEnviar.addEventListener("click", (event)=> {
    event.preventDefault();
    const token = localStorage.getItem("token");
    if (!token) {
      swal("Mensaje enviado correctamente", "Gracias por tus comentarios", "success"); //SweetAlert
      return;
    } 

    if (localStorage.getItem("elementosCarrito") != null){
    swal({
        title: "¿Proceder con la compra?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((comprar) => {
        if (comprar) {
          swal("¡Compra realizada!", {
            icon: "success",
          }).then(function(){ 
            localStorage.removeItem("carritoAgrupado");
            localStorage.removeItem("contadorProductos");
            localStorage.removeItem("elementosCarrito");
            location.reload();
            })
        } else {
        }
      });
    }else{
        swal("Tu carrito está vacio", "", "warning"); //SweetAlert
    }
    
})
botonLimpiar.addEventListener("click", (event)=> {
    event.preventDefault();
    if (localStorage.getItem("elementosCarrito") != null){
    swal({
        title: "¿Borrar carrito de compras?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((comprar) => {
        if (comprar) {
          swal("¡Carrito borrado!", {
            icon: "success",
          }).then(function(){ 
            localStorage.removeItem("carritoAgrupado");
            localStorage.removeItem("contadorProductos");
            localStorage.removeItem("elementosCarrito");
            location.reload();
            })
        } else {
          
        }
      });
    }else{
        swal("Tu carrito está vacio", "", "warning"); //SweetAlert
    }
    
})

// Arreglo global para almacenar la lista de compras.
let cuerpoTabla = tabla.getElementsByTagName("tbody");

window.addEventListener("load", function () {

    document.getElementById("contadorProductos").innerHTML=contador;
    document.getElementById("productosTotal").innerHTML=contador;

    if (localStorage.getItem("contadorProductosNavBar") != null) {
        contador2 = parseInt(localStorage.getItem("contadorProductos"));
        document.getElementById("contadorProductosNavBar").innerHTML = contador2;
    } // if  contador2Productos

    if (localStorage.getItem("precioTotal")) {
        costoTotal = parseFloat(localStorage.getItem("precioTotal"));
        total.innerHTML = costoTotal;
    } // if precioTotal
    
    const nuevoArreglo = JSON.parse(localStorage.getItem("elementosCarrito"));
    const AgrupayAnade = nuevoArreglo => {
      const nuevoJSON = [];
      nuevoArreglo.forEach(elemento => {
        if (!this[elemento.isbn]) {
          contador2++;
            this[elemento.isbn] = {
               id: contador2,
               autor: elemento.autor,
               img: elemento.img,
               isbn: elemento.isbn,
               nombre: elemento.nombre, 
               precio: elemento.precio, 
               cantidad: 0
            };
            nuevoJSON.push(this[elemento.isbn]);
            localStorage.setItem("carritoAgrupado", JSON.stringify(nuevoJSON));
         };
         this[elemento.isbn].cantidad += +elemento.cantidad;
         localStorage.setItem("carritoAgrupado", JSON.stringify(nuevoJSON));
      }, {});
      return nuevoJSON;
   }
  AgrupayAnade(nuevoArreglo);
  
    if (localStorage.getItem("carritoAgrupado") != null) {
        total = 0;
        indice = 0;
        datos = JSON.parse(localStorage.getItem("carritoAgrupado"));
        datos.forEach((element) => {
            
            cuerpoTabla[0].innerHTML += `<tr>
            <div >
            <th class="text-dark" scope="row" style="
            display: table-cell;
            vertical-align: middle;">${element.id}</th><div>
            <td>
            <section class="contenido">
            <div class="columnas">
              <!-- columna1 -->
              <img id="imagenProductoCarrito" src="${element.img}" />
              <!-- columna1 -->
              </div>

              <div class="columnas">
              <!-- columna2 -->
              <h5 id="nombreCarrito" class="ml-0 mb-0 modalNombre">${element.nombre}</h5>
              <small class="text-muted">${element.autor}</small><br>
              <span class="text-dark" class="modalISBN"><strong>ISBN:</strong> ${element.isbn}</span><br>
              <span id="movilPrecio" class="text-dark"><strong>Precio:</strong>$${element.precio} MXN</span>
              <span id="movilCantidad" class="text-dark"><strong>Cantidad:</strong> ${element.cantidad} </span>
              
            </div>
          </section>
            </td>
            <td id="tdCantidad" class="text-center text-dark">
     
            <input type="number" id="quantity_${indice}" name="quantity" min="1" max="5" value=${element.cantidad} onclick="modifica(${indice})">
            <br/>
            <br/>
            <input type="button" class="btn btn-danger" id="elimina_${indice}" name="elimina" onclick="elimina(${indice})" value="Eliminar">
            


          </td>
            <td id="tdPrecio" class="text-dark text-center">${
                "$ " + element.precio + " MXN"
            }</td>
            </tr> 
            `;
            indice++;
        }
        );

        
        datos.forEach(element => {
            total+=parseFloat(element.cantidad)*parseFloat(element.precio);
        }
        );
        document.getElementById("precioTotal").innerHTML ="$"+ total +" MXN";
    }
});

function modifica(index) {
  console.log(index);
  variable = "quantity_"+index;
  datos = JSON.parse(localStorage.getItem("carritoAgrupado"));
  cantidadd = parseInt(document.getElementById(variable).value);
  contador2++;
  console.log(cantidadd);
  
  total =0;
  let total2=0;
  datos.forEach(element => {
    if (element.id === index+1){
      element.cantidad = cantidadd
    }
    total += element.cantidad;
  })
  datos.forEach(element => {
     total2+=parseFloat(element.cantidad)*parseFloat(element.precio);
  }
  );
  console.log(total);
  document.getElementById("contadorProductos").innerHTML=total;
  document.getElementById("precioTotal").innerHTML ="$"+ total2 +" MXN";
  document.getElementById("productosTotal").innerHTML=total;
  document.getElementById("contadorProductos").innerHTML=total;
  document.getElementById("contadorProductosNavBar").innerHTML=total;
  
  localStorage.setItem("contadorProductos",JSON.stringify(total))
  localStorage.setItem("elementosCarrito", JSON.stringify(datos));
  location.reload();

}

function elimina(index){
  swal({
    title: "¿Eliminar producto de carrito?",
    icon: "warning",
    buttons: true,
    dangerMode: true,
  })
  .then((comprar) => {
    if (comprar) {
      swal("¡Producto eliminado!", {
        icon: "success",
      }).then(function(){ 
      total =0;
      
       datos = JSON.parse(localStorage.getItem("carritoAgrupado"));
      if (datos.length==1){
        localStorage.removeItem("carritoAgrupado");
        localStorage.removeItem("contadorProductos");
        localStorage.removeItem("elementosCarrito");
        location.reload();
      }else{

       nuevo = datos.filter(data => data.id != index+1);
       conta=1;
       nuevo.forEach(element => {
        element.id = conta;
        conta++;
        total += element.cantidad;
      })
        localStorage.setItem("contadorProductos",JSON.stringify(total))
        localStorage.setItem("elementosCarrito", JSON.stringify(nuevo));
        location.reload();
      }
    })
    } 
  });
}