package com.educandoweb.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.educandoweb.curso.entidades.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
