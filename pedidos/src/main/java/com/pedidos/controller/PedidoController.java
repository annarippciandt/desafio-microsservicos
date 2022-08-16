package com.pedidos.controller;

import com.pedidos.dto.PedidoDTO;
import com.pedidos.model.Pedido;
import com.pedidos.service.impl.PedidoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoServiceImpl service;

    @GetMapping("/list")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> getAllPedidos(){
        return service.getAllPedidos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Pedido getPedidoById(@PathVariable Long id){
        return service.getPedidoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPedido(@RequestBody PedidoDTO pedido){
        service.addPedido(pedido);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedido){
        service.updatePedido(pedido, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePedido(@PathVariable Long id){
        service.deletePedidoById(id);
    }

}
