package com.postdata.postdata;

public class Login {

	class LoginForm {
        private String correo;
        private String contrasena;
		public LoginForm(String correo, String contrasena) {
			super();
			this.correo = correo;
			this.contrasena = contrasena;
		}
		public LoginForm() {}
		
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getContrasena() {
			return contrasena;
		}
		public void setPassword(String contrasena) {
			this.contrasena = contrasena;
		}
		@Override
		public String toString() {
			return "LoginForm [correo=" + correo + ", contrasena=" + contrasena + "]";
		}
	
	}

}
