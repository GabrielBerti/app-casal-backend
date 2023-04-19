package com.appcasal.domain.repository;

import com.appcasal.domain.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
    @Override
    @Query(value = "SELECT * FROM RECEITA ORDER BY NOME", nativeQuery = true)
    List<Receita> findAll();

}
