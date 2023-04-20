package com.appcasal.domain.repository;

        import com.appcasal.domain.model.Meta;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;

        import java.util.List;

public interface MetaRepository extends JpaRepository<Meta, Integer> {

    @Override
    @Query(value = "SELECT * FROM META ORDER BY DESCRICAO", nativeQuery = true)
    List<Meta> findAll();

    @Query(value = "SELECT * FROM META WHERE CONCLUIDO = ?1 and UPPER(DESCRICAO) LIKE CONCAT('%', UPPER(?2), '%') ORDER BY DESCRICAO", nativeQuery = true)
    List<Meta> getMetas(Boolean tipoFiltroMeta, String search);

    @Query(value = "SELECT * FROM META WHERE CONCLUIDO = ?1 ORDER BY DESCRICAO", nativeQuery = true)
    List<Meta> getMetasByConcluido(Boolean tipoFiltroMeta);

    @Query(value = "SELECT * FROM META WHERE UPPER(DESCRICAO) LIKE CONCAT('%', UPPER(?1), '%') ORDER BY DESCRICAO", nativeQuery = true)
    List<Meta> getMetasByDescricao(String search);
}

