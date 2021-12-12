package br.com.financeiro.dto;

import br.com.financeiro.enumeration.TransacaoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoDto {

    private BigDecimal valor;
    private TransacaoEnum tipo;
    private LocalDate data;
    private Integer categoriaId;

    public TransacaoDto(BigDecimal valor, TransacaoEnum tipo, Integer categoriaId) {
        this.valor = valor;
        this.tipo = tipo;
        this.categoriaId = categoriaId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoEnum getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

}
