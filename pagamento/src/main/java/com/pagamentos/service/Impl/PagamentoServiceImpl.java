package com.pagamentos.service.Impl;

import com.pagamentos.dto.PagamentoDTO;
import com.pagamentos.model.Pagamento;
import com.pagamentos.repository.PagamentoRepository;
import com.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository repository;


    @Override
    public List<Pagamento> getAllPagamentos() {
        return (List<Pagamento>) repository.findAll();
    }

    @Override
    public Pagamento getPagamentoById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addPagamento(PagamentoDTO newPagamento) {

        final Pagamento pagamento = Pagamento.builder()
                .nome(newPagamento.getNome())
                .numero(newPagamento.getNumero())
                .expiracao(newPagamento.getExpiracao())
                .codigo(newPagamento.getCodigo())
                .status(newPagamento.getStatus())
                .formaDePagamento(newPagamento.getFormaDePagamento())
                .pedidoId(newPagamento.getPedidoId())
                .build();

        repository.save(pagamento);
    }

    @Override
    public void updateValorPagamento(PagamentoDTO newPagamento) {

        final Pagamento pagamento = Pagamento.builder()
                .nome(newPagamento.getNome())
                .numero(newPagamento.getNumero())
                .expiracao(newPagamento.getExpiracao())
                .codigo(newPagamento.getCodigo())
                .status(newPagamento.getStatus())
                .formaDePagamento(newPagamento.getFormaDePagamento())
                .pedidoId(newPagamento.getPedidoId())
                .build();

        repository.save(pagamento);
    }

    @Override
    public void deletePagamento(Long id) {
        repository.deleteById(id);
    }
}
