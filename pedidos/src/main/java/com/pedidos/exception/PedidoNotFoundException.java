package com.pedidos.exception;

public class PedidoNotFoundException extends IllegalArgumentException {
    private static final String mensagem = "Pedido não encontrado.";
    public PedidoNotFoundException() {
        super(mensagem);
    }
}
