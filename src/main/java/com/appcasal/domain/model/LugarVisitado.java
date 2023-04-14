package com.appcasal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lugar_visitado")
public class LugarVisitado {

    @Id
    @SequenceGenerator(name = "seq_lugar_visitado", sequenceName = "seq_lugar_visitado")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_lugar_visitado")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "nota")
    private Double nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_viagem")
    private Viagem viagem;
}
