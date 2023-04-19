package com.appcasal.domain.repository;

import com.appcasal.domain.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetaRepository extends JpaRepository<Meta, Integer> {

    @Override
    @Query(value = "SELECT * FROM META ORDER BY DESCRICAO", nativeQuery = true)
    List<Meta> findAll();

    @Query(value = "SELECT * FROM META WHERE CONCLUIDO = ?1", nativeQuery = true)
    List<Meta> getMetasByType(Boolean tipoFiltroMeta);
}
