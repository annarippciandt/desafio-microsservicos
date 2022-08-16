package com.pagamentos.service;

import com.pagamentos.dto.PagamentoDTO;
import com.pagamentos.model.Pagamento;

import java.util.List;

public interface PagamentoService {

    List<Pagamento> getAllPagamentos();

    Pagamento getPagamentoById(Long id);

    void addPagamento(PagamentoDTO newPagamento);

    void updateValorPagamento(PagamentoDTO pagamento);

    void deletePagamento(Long id);


}
