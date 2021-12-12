package br.com.financeiro.service;

import br.com.financeiro.dto.CategoriaDto;
import br.com.financeiro.model.Categoria;
import br.com.financeiro.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria de id " + id + " não encontrado"));
    }

    @Override
    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria cadastrar(CategoriaDto CategoriaDto) {
        Categoria Categoria = CategoriaDto.converte();
        return categoriaRepository.save(Categoria);
    }

    @Override
    public void remover(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
