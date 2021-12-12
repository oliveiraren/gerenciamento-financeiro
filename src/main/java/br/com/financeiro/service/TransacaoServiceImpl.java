package br.com.financeiro.service;

import br.com.financeiro.dto.TransacaoDto;
import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Transacao;
import br.com.financeiro.repository.CategoriaRepository;
import br.com.financeiro.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

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
    public Transacao cadastrar(TransacaoDto transacaoDto) {

        Categoria categoria = categoriaRepository.getOne(transacaoDto.getCategoriaId());
        Transacao transacao = new Transacao((transacaoDto.getValor()), transacaoDto.getTipo(), categoria);
        return transacaoRepository.save(transacao);
    }

    @Override
    public void remover(Integer id) {
        transacaoRepository.deleteById(id);
    }

    @Override
    public List<Transacao> buscarPorCategoriaId(Integer id) {

        return transacaoRepository.findAllByCategoriaId(id);
    }
}
