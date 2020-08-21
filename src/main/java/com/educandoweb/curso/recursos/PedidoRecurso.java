package com.educandoweb.curso.recursos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educandoweb.curso.entidades.Pedido;
import com.educandoweb.curso.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {
	
	@Autowired
	PedidoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> obterTodos() {
		List<Pedido> lista = servico.obterTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> obterPorId(@PathVariable Long id) {
		Pedido u = servico.ObterPorId(id);
		return ResponseEntity.ok().body(u);
	}
}