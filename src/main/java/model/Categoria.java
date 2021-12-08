package model;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    @OneToMany (mappedBy = "categoria")
    private Transacao transacao;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Transacao getCarteira() {
        return transacao;
    }
}
