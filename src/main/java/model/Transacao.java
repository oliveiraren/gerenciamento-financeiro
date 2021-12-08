package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valor;
    private String tipoValor;
    private BigDecimal saldo = BigDecimal.valueOf(0);
    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    public Transacao(BigDecimal valor, Categoria categoria) {
        this.saldo = saldo;
    }

    protected Transacao() {
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
