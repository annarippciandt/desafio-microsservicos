package com.pagamentos.controller;

import com.pagamentos.dto.PagamentoDTO;
import com.pagamentos.model.Pagamento;
import com.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public final List<Pagamento> getAllPagamentos(){
        return service.getAllPagamentos();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public final Pagamento getPagamentoById(@PathVariable Long id){
        return service.getPagamentoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPagamento(@RequestBody PagamentoDTO newPagamento){
        service.addPagamento(newPagamento);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateValorPagamento(@RequestBody PagamentoDTO pagamento, @PathVariable Long id){
        service.updateValorPagamento(pagamento);
    }

    public void deletePagamento(Long id){
        service.deletePagamento(id);
    }
}
