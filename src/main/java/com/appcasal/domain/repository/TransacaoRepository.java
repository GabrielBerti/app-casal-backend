package com.appcasal.domain.repository;

import com.appcasal.domain.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;


public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    @Query(value = "SELECT SUM(VALOR) FROM TRANSACAO WHERE TIPO = ?1", nativeQuery = true)
    BigDecimal getValorTransacaoByType(Integer tipo);

}
