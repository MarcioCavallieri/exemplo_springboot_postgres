package com.educandoweb.curso.servicos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.curso.entidades.Produto;
import com.educandoweb.curso.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> obterTodos() {
		return repositorio.findAll();
	}
	
	public Produto ObterPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
}
