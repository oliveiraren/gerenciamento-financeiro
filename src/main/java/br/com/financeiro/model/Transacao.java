package br.com.financeiro.model;

import br.com.financeiro.enumeration.TransacaoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valor;
    private TransacaoEnum tipo;
    private LocalDate data = LocalDate.now();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    public Transacao(BigDecimal valor, TransacaoEnum tipo, Categoria categoria) {
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    protected Transacao() {
    }

    public Integer getId() {
        return id;
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

    public Categoria getCategoria() {
        return categoria;
    }

}
