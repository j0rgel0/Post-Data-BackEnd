package com.postdata.postdata;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.postdata.model.Producto;
import com.postdata.model.Usuario;

@SpringBootTest
@AutoConfigureMockMvc
class PostdataApplicationTests {
	@Autowired  // para instanciar de forma automática al momento de ejecutar la prueba
	private MockMvc mockMvc;
	
	@Test
	@Disabled
	public void pruebaPOST() throws Exception {
		Producto p=new Producto();
		p.setNombre("Un libro");
		p.setAutor("Una descripcion");
		p.setEditorial("Una editorial");
		p.setISBN("1234567890");
		p.setURL_imagen("unaimagen.com");
		p.setDescripcion("Una descripcion");
		p.setPrecio(55.50);
		
		this.mockMvc.perform( post("/api/products/")
				.contentType(MediaType.APPLICATION_JSON)  //tipo de contenidoi
				.content(asJsonString(p)) // objeto convertiod a json string
				)
		   .andDo( print() )
		   .andExpect( status().isOk() ) /// status 200
		   .andExpect( content().string(containsString("libro") ) );
	}//prueba POST producto	
	public static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString
	
	@Test
	@Disabled
	public void pruebaPOSTUser() throws Exception {
		Usuario u=new Usuario();
		u.setNombre("Un nombre");
		u.setUsername("nombre@gmail.com");
		u.setPassword("contrasena");
		u.setRoles((long) 2);
		
		this.mockMvc.perform( post("/api/user/")
				.contentType(MediaType.APPLICATION_JSON)  //tipo de contenidoi
				.content(asJsonString(u)) // objeto convertiod a json string
				)
		   .andDo( print() )
		   .andExpect( status().isOk() ) /// status 200
		   .andExpect( content().string(containsString("nombre") ) );
	}//prueba POSTUser
	public static String asJsonString2(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString
	
	
	@Test
	@Disabled
	public void pruebaDELETEProd() throws Exception {
		this.mockMvc.perform( delete("/api/products/7") )
		   .andDo( print() )
		   .andExpect( status().isOk() ) /// status 200
		   .andExpect( content().string(containsString("libro") ) );
	}//prueba Delete producto
	
	@Test
	@Disabled
	public void pruebaDELETEUser() throws Exception {
		this.mockMvc.perform( delete("/api/user/6") )
		   .andDo( print() )
		   .andExpect( status().isOk() ) /// status 200
		   .andExpect( content().string(containsString("nombre") ) );
	}//prueba Delete producto
	
	
	@Test
	@Disabled
	public void pruebaPUTProd() throws Exception {
		this.mockMvc.perform(put("/api/products/2")
		.queryParam("nombre", "La super estafa maestra: La historia del desfalco"))
		.andDo( print() )
		.andExpect( status().isOk() ) /// status 200
		.andExpect( content().string(containsString("maestra") ) ); //pregunta si contiene estas palabras
		
		this.mockMvc.perform(put("/api/products/4")
				.queryParam("nombre", "El super infinito en un junco"))
				.andDo( print() )
				.andExpect( status().isOk() ) /// status 200
				.andExpect( content().string(containsString("junco") ) ); //pregunta si contiene estas palabras
	}//prueba put productos
	
	@Test
	public void pruebaPUTUser() throws Exception {
		this.mockMvc.perform(put("/api/user/1")
		.queryParam("password", "A.abc.123")
		.queryParam("newPassword", "jorgemod")
//		.header("Authorization", "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYnJhaGFtQGdtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNjU3NzY5ODk4LCJleHAiOjE2NTc4MDU4OTh9.y4x8I1UZm-ACND2x7x5kK8rFY8oJaQNxnzX4ORm19N4")
				)
		.andDo( print() )
		.andExpect( status().isOk() ) /// status 200
		.andExpect( content().string(containsString("Jorge") ) ); //pregunta si contiene estas palabras
		
//		this.mockMvc.perform(put("/api/user/2")
//				.queryParam("password", "Almamod"))
//				.andDo( print() )
//				.andExpect( status().isOk() ) /// status 200
//				.andExpect( content().string(containsString("Alma") ) ); //pregunta si contiene estas palabras
	}//prueba put productos
	
	
	@Test
	@Disabled
	public void pruebaGETProd() throws Exception {
	   this.mockMvc.perform( get("/api/products/4") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("junco") ) );
	   
	   this.mockMvc.perform( get("/api/products/2") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("estafa") ) );
	}//prueba GET productos

	@Test
	public void pruebaGETUser() throws Exception {
	   this.mockMvc.perform( get("/api/user/1") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("Jorge") ) );
	   
	   this.mockMvc.perform( get("/api/user/2") )
	   .andDo( print() )
	   .andExpect( status().isOk() ) /// status 200
	   .andExpect( content().string(containsString("alma") ) );
	}//prueba GET usuarios

}

