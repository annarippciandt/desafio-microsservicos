package com.pedidos.service.impl;

import com.pedidos.dto.ItemPedidoDTO;
import com.pedidos.dto.PedidoDTO;
import com.pedidos.exception.PedidoNotFoundException;
import com.pedidos.model.ItemPedido;
import com.pedidos.model.Pedido;
import com.pedidos.repository.PedidoRepository;
import com.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;

    public List<Pedido> getAllPedidos() {
        return (List<Pedido>) repository.findAll();
    }

    public Pedido getPedidoById(Long id) throws PedidoNotFoundException {
        return repository.findById(id).orElseThrow(PedidoNotFoundException::new);
    }

    public void addPedido(PedidoDTO pedido) {
        var newPedido = Pedido
                .builder()
                .dataHora(pedido.getDataHora())
                .status(pedido.getStatus())
                .itens(itensProvider(pedido.getItens()))
                .build();
        repository.save(newPedido);
    }

    public void updatePedido(PedidoDTO pedido, Long id) throws PedidoNotFoundException {
        repository.findById(id).orElseThrow(PedidoNotFoundException::new);
        var pedidoUpdate = Pedido
                .builder()
                .status(pedido.getStatus())
                .build();
        repository.save(pedidoUpdate);
    }

    public void deletePedidoById(Long id) {
        repository.findById(id).orElseThrow(PedidoNotFoundException::new);
        repository.deleteById(id);
    }

    private ItemPedido itemProvider(ItemPedidoDTO itemPedidoDTO) {
        var itemPedido = ItemPedido.builder()
                .quantidade(itemPedidoDTO.getQuantidade())
                .descricao(itemPedidoDTO.getDescricao())
                .build();

        return itemPedido;
    }

    private Set<ItemPedido> itensProvider(Set<ItemPedidoDTO> itens) {
        Set<ItemPedido> itensList = new HashSet<>();

        for (ItemPedidoDTO itemPedidoDTO : itens) {
            var item = itemProvider(itemPedidoDTO);
            itensList.add(item);
        }
        return itensList;
    }
}
