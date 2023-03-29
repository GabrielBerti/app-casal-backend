package com.appcasal.domain.repository;

import com.appcasal.domain.model.GastoViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GastoViagemRepository extends JpaRepository<GastoViagem, Integer> {
    @Query(value = "SELECT * FROM GASTO_VIAGEM WHERE FK_VIAGEM = ?1", nativeQuery = true)
    List<GastoViagem> getGastosViagemByViagem(Integer fkViagem);
}
