package com.educandoweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entidades.Usuario;
import com.educandoweb.curso.repositorios.UsuarioRepositorio;
import com.educandoweb.curso.servicos.excecoes.DatabaseException;
import com.educandoweb.curso.servicos.excecoes.ResourceNotFoundException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> obterTodos() {
		return repositorio.findAll();
	}
	
	public Usuario ObterPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		
		//Faz o .Get, mas se não tiver objeto no Optional, ele lançará a Exceção ResourceNotFound personalizada
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletar(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id); 
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario atualizar(Long id, Usuario obj) {
		try {
			Usuario entidade = repositorio.getOne(id);
			atualizarDados(entidade, obj);
			
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());		
	}
}
