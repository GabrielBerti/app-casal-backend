package com.appcasal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @SequenceGenerator(name = "seq_receita", sequenceName = "seq_receita")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_receita")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "descricao")
    private String descricao;

   @OneToMany(mappedBy = "receita", cascade = CascadeType.REMOVE)
    private List<Ingrediente> Ingredientes = new ArrayList<>();
}
