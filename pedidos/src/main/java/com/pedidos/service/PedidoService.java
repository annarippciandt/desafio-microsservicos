package com.pedidos.service;

import com.pedidos.dto.PedidoDTO;
import com.pedidos.model.Pedido;

import java.util.List;

public interface PedidoService{

   List<Pedido> getAllPedidos();

   Pedido getPedidoById(Long id) throws Exception;


    void addPedido(PedidoDTO pedido);

    void updatePedido(PedidoDTO pedido, Long id) throws Exception;

    void deletePedidoById(Long id);
}
