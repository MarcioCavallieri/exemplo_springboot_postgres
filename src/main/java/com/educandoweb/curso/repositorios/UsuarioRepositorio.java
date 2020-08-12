package com.educandoweb.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educandoweb.curso.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
}
