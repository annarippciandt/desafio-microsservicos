package com.pagamentos.dto;

import com.pagamentos.model.FormaDePagamento;
import com.pagamentos.model.Status;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Builder
@Data
public class PagamentoDTO {

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotBlank
    @Max(100)
    private String nome;

    @NotBlank
    @Max(100)
    private String numero;

    private String expiracao;

    @NotBlank
    @Size(min = 3, max = 3)
    private String codigo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    private Long pedidoId;

    private FormaDePagamento formaDePagamento;
}
