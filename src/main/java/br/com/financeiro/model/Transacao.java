package br.com.financeiro.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valor;
    private LocalDate data = LocalDate.now();
    private BigDecimal saldo = BigDecimal.valueOf(0);
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Transacao(BigDecimal valor, Categoria categoria) {
        this.saldo = saldo;
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

    public LocalDate getData() {return data; }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

}
