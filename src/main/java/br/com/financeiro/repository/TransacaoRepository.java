package br.com.financeiro.repository;

import br.com.financeiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    @Query(value = "SELECT p FROM Produto p JOIN p.categoria c WHERE p.categoria.id = :id")
    List<Transacao> findAllByCategoriaId(Integer id);
}
