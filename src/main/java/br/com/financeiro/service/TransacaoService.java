package br.com.financeiro.service;

import br.com.financeiro.model.Transacao;

import java.util.List;

public interface TransacaoService {

    Transacao buscarPorId(Integer id);

    List<Transacao> buscarTodos();

    Transacao salvar(Transacao transacao);

    void remover(Integer id);

    List<Transacao> buscarPorCategoriaId(Integer id);
}
