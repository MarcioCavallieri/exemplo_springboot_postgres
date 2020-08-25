package com.educandoweb.curso.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educandoweb.curso.entidades.Produto;
import com.educandoweb.curso.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso {
	
	@Autowired
	ProdutoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> obterTodos() {
		List<Produto> lista = servico.obterTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> obterPorId(@PathVariable Long id) {
		Produto p = servico.ObterPorId(id);
		return ResponseEntity.ok().body(p);
	}
}