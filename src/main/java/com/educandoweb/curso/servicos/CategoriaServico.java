package com.educandoweb.curso.servicos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.curso.entidades.Categoria;
import com.educandoweb.curso.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> obterTodos() {
		return repositorio.findAll();
	}
	
	public Categoria ObterPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
}
