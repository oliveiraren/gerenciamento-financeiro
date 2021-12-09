package service;

import model.Transacao;
import org.springframework.stereotype.Service;
import repository.TransacaoRepository;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public Transacao buscaPorId(Integer id) {
        return null;
    }

    @Override
    public List<Transacao> buscarTodos() {
        return null;
    }

    @Override
    public Transacao salvar(Transacao transacao) {
        return null;
    }

    @Override
    public void remover(Integer id) {

    }

    @Override
    public List<Transacao> buscarPorCategoriaId(Integer id) {
        return null;
    }
}
