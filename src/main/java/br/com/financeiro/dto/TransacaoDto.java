package br.com.financeiro.dto;

import br.com.financeiro.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoDto {

    private Integer id;
    private BigDecimal valor;
    private LocalDate data;
    private BigDecimal saldo;
    private CategoriaDto categoria;

    public TransacaoDto(Integer id, BigDecimal valor, LocalDate data, BigDecimal saldo, CategoriaDto categoria) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.saldo = saldo;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
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

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public static TransacaoDto converte(Transacao transacao) {
        return new TransacaoDto(transacao.getId(), transacao.getValor(), transacao.getData(), transacao.getSaldo(),
                CategoriaDto.converte(transacao.getCategoria()));
    }

}
