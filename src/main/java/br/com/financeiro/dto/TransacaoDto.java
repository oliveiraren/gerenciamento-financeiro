package br.com.financeiro.dto;

import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoDto {

    private BigDecimal valor;
    private LocalDate data;
    private BigDecimal saldo;
//    private Categoria categoria;
    private Integer categoriaId;
    public TransacaoDto(BigDecimal valor, Integer categoriaId) {
        this.valor = valor;
        this.categoriaId = categoriaId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoria) {
        this.categoriaId = categoriaId;
    }

//    public Transacao converte() {
//            return new Transacao(valor, categoriaId);
//    }

}
