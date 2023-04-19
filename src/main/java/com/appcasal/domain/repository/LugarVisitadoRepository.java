package com.appcasal.domain.repository;

import com.appcasal.domain.model.LugarVisitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LugarVisitadoRepository extends JpaRepository<LugarVisitado, Integer> {

    @Query(value = "SELECT * FROM LUGAR_VISITADO WHERE FK_VIAGEM = ?1 ORDER BY NOME", nativeQuery = true)
    List<LugarVisitado> getLugaresVisitadosByViagem(Integer fkViagem);
}
