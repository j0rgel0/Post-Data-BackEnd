const botonBuscar = document.querySelector("#botonBuscar");
const txtId = document.getElementById("IdLibro");
const itemsContainer = document.getElementById("list-items");

const token = localStorage.getItem("token");

botonBuscar.addEventListener("click", (event) => {
    event.preventDefault();

    if (!txtId.value) {
        swal("Debe colocar un valor correcto", "", "danger");
    } else {
        if (!token) {
            swal("Favor de iniciar sesión", "", "danger");
        } else {
            searchProduct(txtId.value);
        }
    }

    /*
        const cadenaProductos = localStorage.getItem('productos');
        if (cadenaProductos && cadenaProductos.length > 0) {
            const productos = JSON.parse(cadenaProductos);
            let producto = null;
            for (let i = 0; i < productos.length; i++) {
                const recuperado = productos[i];
                if (recuperado["isbn"] == txtId.value) {
                    producto = recuperado;
                    break;
                }
            }
            if (producto) {
                addItem(producto);
            } else {
                console.log('No existe el producto.');
                itemsContainer.innerHTML = null;
            }
            txtId.value = null;
        }*/

});


function showItem(item) {
    const itemHTML =
        `<div id="contenedorProducto" class="col-md-5 col-lg-3 col-xl-2">
        <img id="imagenProducto" class="card-img-top p-3" src="${item.url_imagen}"/>
        <div class="card-text">
            <div class="text-center">
                <h5>${item.nombre}</h5>
                <p>$${item.precio}</p>
            </div>
        </div>
           <a id="botonAnadir" href="#" onclick="deleteProduct(${item.id})">
            Eliminar
            </a>
        </div>
        `;
    itemsContainer.innerHTML = itemHTML;
}

const deleteProduct = (id) => {
    if (!token) {
        swal("Favor de iniciar sesión", "", "danger");
    } else {
        txtId.value = null;
        fetch(`http://127.0.0.1:8087/api/products/${id}`,
            {
                method: 'DELETE',
                headers: { "Content-type": "application/json; charset=UTF-8", "authorization": `Bearer: ${token}` }
            })
            .then(response => response.json())
            .then(response => {
                if (response.status && response.status != 200) {
                    swal("Ocurrio un error al borrar el libro", "", "danger");
                } else {
                    swal("Se borro el libro exitosamente.", "", "success");
                    itemsContainer.innerHTML = null;
                }
            })
            .catch(error => {
                swal("Ocurrio un error al borrar el producto", "", "danger");
            });
    }
}

const searchProduct = (isbn) => {
    fetch(`http://127.0.0.1:8087/api/products/${isbn}`,
        {
            method: 'GET',
            headers: { "Content-type": "application/json; charset=UTF-8", "authorization": `Bearer: ${token}` }
        })
        .then(response => response.json())
        .then(response => {
            if (response.status && response.status != 200) {
                swal("No existe el Libro!!", "", "danger");
            } else {
                showItem(response);
            }
        })
        .catch(error => {
            swal("Ocurrio un error al buscar el producto", "", "danger");
        });
}