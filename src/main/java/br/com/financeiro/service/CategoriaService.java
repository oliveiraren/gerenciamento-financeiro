package br.com.financeiro.service;

import br.com.financeiro.dto.CategoriaDto;
import br.com.financeiro.model.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria buscarPorId(Integer id);

    List<Categoria> buscarTodos();

    Categoria cadastrar(CategoriaDto CategoriaDto);

    void remover(Integer id);

}
