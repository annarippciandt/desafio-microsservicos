package com.pagamentos.repository;

import com.pagamentos.model.Pagamento;
import org.springframework.data.repository.CrudRepository;


public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
}
