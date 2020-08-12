package com.educandoweb.curso.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educandoweb.curso.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll() {
		Usuario u = new Usuario(1L, "Marcio", "Marcio@Marcio", "123456789", "12345");
		return ResponseEntity.ok().body(u);
	}
}