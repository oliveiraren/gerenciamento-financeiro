package br.com.financeiro.repository;

import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value = "SELECT c.nome FROM Categoria c WHERE c.id = :id")
    String nomeCategoriaId(Integer id);

}
