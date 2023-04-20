package com.appcasal.domain.repository;

import com.appcasal.domain.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViagemRepository extends JpaRepository<Viagem, Integer> {
    @Override
    @Query(value = "SELECT * FROM VIAGEM ORDER BY DATA_INICIO", nativeQuery = true)
    List<Viagem> findAll();

    @Query(value = "SELECT * FROM VIAGEM WHERE UPPER(LOCAL) LIKE CONCAT('%', UPPER(?1), '%') ORDER BY DATA_INICIO", nativeQuery = true)
    List<Viagem> getViagensByNome(String search);

}
