package com.educandoweb.curso.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educandoweb.curso.entidades.Categoria;
import com.educandoweb.curso.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {
	
	@Autowired
	CategoriaServico servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> obterTodos() {
		List<Categoria> lista = servico.obterTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> obterPorId(@PathVariable Long id) {
		Categoria c = servico.ObterPorId(id);
		return ResponseEntity.ok().body(c);
	}
}