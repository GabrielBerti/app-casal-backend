package com.appcasal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    @SequenceGenerator(name = "seq_ingrediente", sequenceName = "seq_ingrediente")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_ingrediente")
    private Integer id;

    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "marcado")
    private Boolean marcado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_receita")
    private Receita receita;
}
