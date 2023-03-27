package com.appcasal.domain.repository;

import com.appcasal.domain.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    @Query(value = "SELECT * FROM INGREDIENTE WHERE FK_RECEITA = ?1", nativeQuery = true)
    List<Ingrediente> getIngredientesByReceita(Integer fkReceita);
}
