package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.educandoweb.curso.entidades.Pedido;
import com.educandoweb.curso.entidades.Usuario;
import com.educandoweb.curso.entidades.enums.PedidoStatus;
import com.educandoweb.curso.repositorios.PedidoRepositorio;
import com.educandoweb.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner{ //Isso é executado assim que o serviço rodar
	
	@Autowired
	private UsuarioRepositorio ur; //Serviço dependendo de outro: @Autowired define uma injeção de dependência 'fraca'.Tem como fazer isso manualmente também (set, construtor...) 
	@Autowired
	private PedidoRepositorio pr; //Serviço dependendo de outro: @Autowired define uma injeção de dependência 'fraca'.Tem como fazer isso manualmente também (set, construtor...)
 
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Marcio", "marcio@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Thaina", "thaina@gmail.com", "977777777", "123456");		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.PAGO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		
		ur.saveAll(Arrays.asList(u1, u2));
		pr.saveAll(Arrays.asList(p1, p2, p3));
	}

}