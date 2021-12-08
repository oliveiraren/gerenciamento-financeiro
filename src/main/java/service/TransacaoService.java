package service;

import model.Transacao;

import java.util.List;

public interface TransacaoService {

    Transacao buscaPorId(Integer id);

    List<Transacao> buscarTodos();

    Transacao salvar(Transacao transacao);

    void remover(Integer id);

    List<Transacao> buscarPorCategoriaId(Integer id);
}
