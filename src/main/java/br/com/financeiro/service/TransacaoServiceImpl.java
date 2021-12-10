package br.com.financeiro.service;

import br.com.financeiro.model.Transacao;
import org.springframework.stereotype.Service;
import br.com.financeiro.repository.TransacaoRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public Transacao buscarPorId(Integer id) {
        return transacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transacao de id " + id + " não encontrado"));
    }

    @Override
    public List<Transacao> buscarTodos() {
        return transacaoRepository.findAll();
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

        return transacaoRepository.findAllByCategoriaId(id);
    }
}
