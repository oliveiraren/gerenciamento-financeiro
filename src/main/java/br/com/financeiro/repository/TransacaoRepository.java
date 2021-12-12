package br.com.financeiro.repository;

import br.com.financeiro.dto.TransacaoDto;
import br.com.financeiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    @Query(value = "SELECT t FROM Transacao t JOIN t.categoria c WHERE t.categoria.id = :id")
    List<Transacao> findAllByCategoriaId(Integer id);

    @Query(value = "SELECT sum(t.valor) FROM Transacao t JOIN Categoria WHERE categoria_id = :id")
    BigDecimal limiteCategoriaLazer(Integer id);


}
