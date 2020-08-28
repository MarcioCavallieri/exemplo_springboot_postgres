package com.educandoweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entidades.Usuario;
import com.educandoweb.curso.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> obterTodos() {
		return repositorio.findAll();
	}
	
	public Usuario ObterPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
}
