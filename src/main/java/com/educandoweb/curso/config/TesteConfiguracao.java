package com.educandoweb.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.educandoweb.curso.entidades.Usuario;
import com.educandoweb.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner{ //Isso é executado assim que o serviço rodar
	
	@Autowired
	private UsuarioRepositorio ur; //Serviço dependendo de outro: @Autowired define uma injeção de dependência 'fraca'.Tem como fazer isso manualmente também (set, construtor...) 
 
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Marcio", "marcio@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Thaina", "thaina@gmail.com", "977777777", "123456");
		
		ur.saveAll(Arrays.asList(u1, u2));		
	}

}