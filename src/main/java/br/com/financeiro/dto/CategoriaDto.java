package br.com.financeiro.dto;

import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Categoria;

public class CategoriaDto {

    private String nome;

    public CategoriaDto(String nome) {
        this.nome = nome;
    }

    protected CategoriaDto() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converte() {
        return new Categoria(nome);
    }
}
