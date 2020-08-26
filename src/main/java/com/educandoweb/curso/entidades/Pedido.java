package com.educandoweb.curso.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.educandoweb.curso.entidades.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Sem essa notação, no banco, o horario ficará com 3 hs a menos porque o banco está com o fusohorário do Brasil >> GMT -3
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;	
	
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	
	//fetch = FetchType.EAGER que fez o @JsonIgnore da classe ItemPedido funcionar dessa vez...
	@OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER)
	private Set<ItemPedido> itens = new HashSet<ItemPedido>();
	
	public Pedido() {		
	}	

	public Pedido(Long id, Instant data, PedidoStatus status, Usuario cliente) {
		this.id = id;
		this.data = data;
		setStatus(status); 
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public Instant getData() {
		return data;
	}
	
	public PedidoStatus getStatus() {
		return PedidoStatus.valorDe(status);
	}

	public Usuario getCliente() {
		return cliente;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setData(Instant data) {
		this.data = data;
	}
	
	public void setStatus(PedidoStatus status) {
		if (status != null) {
			this.status = status.getCodigo();
		}
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
