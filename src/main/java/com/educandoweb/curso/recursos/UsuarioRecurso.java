package com.educandoweb.curso.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educandoweb.curso.entidades.Usuario;
import com.educandoweb.curso.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obterTodos() {
		List<Usuario> lista = servico.obterTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> obterPorId(@PathVariable Long id) {
		Usuario u = servico.ObterPorId(id);
		return ResponseEntity.ok().body(u);
	}
}