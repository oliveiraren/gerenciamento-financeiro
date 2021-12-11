package br.com.financeiro.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoDtoInput {

    private BigDecimal valor;
    private LocalDate data = LocalDate.now();
    private Integer categoriaId;

    public TransacaoDtoInput(BigDecimal valor, Integer categoriaId) {
        this.valor = valor;
        this.categoriaId = categoriaId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }
}
