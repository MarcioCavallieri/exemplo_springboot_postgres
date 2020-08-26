package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.educandoweb.curso.entidades.Categoria;
import com.educandoweb.curso.entidades.ItemPedido;
import com.educandoweb.curso.entidades.Pedido;
import com.educandoweb.curso.entidades.Produto;
import com.educandoweb.curso.entidades.Usuario;
import com.educandoweb.curso.entidades.enums.PedidoStatus;
import com.educandoweb.curso.repositorios.CategoriaRepositorio;
import com.educandoweb.curso.repositorios.ItemPedidoRepositorio;
import com.educandoweb.curso.repositorios.PedidoRepositorio;
import com.educandoweb.curso.repositorios.ProdutoRepositorio;
import com.educandoweb.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner{ //Isso é executado assim que o serviço rodar
	
	//Serviço dependendo de outro: @Autowired define uma injeção de dependência 'fraca'.Tem como fazer isso manualmente também (set, construtor...)
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;  
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;  
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio; 
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ItemPedidoRepositorio itemPedidoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Marcio", "marcio@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Thaina", "thaina@gmail.com", "977777777", "123456");
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.PAGO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3));
		
		Categoria c1 = new Categoria(null, "Eletrônicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");
		
		categoriaRepositorio.saveAll(Arrays.asList(c1, c2, c3));
		
		Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
				
		produtoRepositorio.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));
		
		pr1.getCategorias().add(c2);
		pr2.getCategorias().add(c1);
		pr2.getCategorias().add(c3);
		pr3.getCategorias().add(c3);
		pr4.getCategorias().add(c3);
		pr5.getCategorias().add(c2);
				
		produtoRepositorio.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));
		
		ItemPedido ip1 = new ItemPedido(p1, pr1, 2, pr1.getPreco());
		ItemPedido ip2 = new ItemPedido(p1, pr3, 1, pr3.getPreco());
		ItemPedido ip3 = new ItemPedido(p2, pr3, 2, pr3.getPreco());
		ItemPedido ip4 = new ItemPedido(p3, pr5, 2, pr5.getPreco());
		
		itemPedidoRepositorio.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
	}
}