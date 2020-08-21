package com.educandoweb.curso.entidades.enums;

public enum PedidoStatus {
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static PedidoStatus valorDe(int codigo) {
		for (PedidoStatus s : PedidoStatus.values())
			if (s.getCodigo() == codigo) {
				return s;
			}
	
		throw new IllegalArgumentException("Código de status inválido."); 
	}
}
