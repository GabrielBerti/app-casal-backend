package com.appcasal.domain.repository;

import com.appcasal.domain.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}
