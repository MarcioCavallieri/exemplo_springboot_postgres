package com.educandoweb.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.educandoweb.curso.entidades.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
	
}
