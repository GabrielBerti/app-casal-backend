package com.appcasal.domain.repository;

import com.appcasal.domain.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;


public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    @Override
    @Query(value = "SELECT * FROM TRANSACAO ORDER BY DATA DESC, DESCRICAO", nativeQuery = true)
    List<Transacao> findAll();

    @Query(value = "SELECT SUM(VALOR) FROM TRANSACAO WHERE TIPO = ?1", nativeQuery = true)
    BigDecimal getValorTransacaoByType(Integer tipo);

}
