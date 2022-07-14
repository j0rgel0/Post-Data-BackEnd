let botonEnviar = document.querySelector("#botonEnviar");
let txtNombre = document.getElementById("nombre");
let txtEmail = document.getElementById("email");
let txtContrasena = document.getElementById("contrasena");
let txtContrasenaConfirma = document.getElementById("contrasenaConfirma");
let datos=[];

botonEnviar.addEventListener("click", (event)=> {
    event.preventDefault();
    const validaciones=[];
    validaciones.nombre=validarNombre(txtNombre.value);
    validaciones.email=validarEmail(txtEmail.value);
    validaciones.contraseña=validarContraseña(txtContrasena.value);
    validaciones.contraseniaValidada=validarConfirmaTuContrasena(txtContrasena.value,txtContrasenaConfirma.value);
            if (Object.values(validaciones).every((value) => value === true) ){

                let elemento =  `
                {"nombre" : "${txtNombre.value}",
                "username" : "${txtEmail.value}",
                "password" : "${txtContrasena.value}",
                "roles": 1
                }`;
      createCuenta(elemento);
      txtNombre.value = "";
      txtNombre.focus();

            }
});

const createCuenta = (cuenta) => {
   fetch('http://127.0.0.1:8087/api/user/',
      {
         body: cuenta,
         method: 'POST',
         headers: { "Content-type": "application/json; charset=UTF-8"}
      })
      .then(response => {
         if (response.status != 200) {
            swal("Ocurrio un error al registrar la cuenta", "", "danger");
         } else {
            swal("Cuenta añadida correctamente", "", "success");
         }
      })
      .catch(error => {
         swal("Ocurrio un error al registrar el usuario", "", "danger");
      });
}