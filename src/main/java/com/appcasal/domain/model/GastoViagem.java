package com.appcasal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gasto_viagem")
public class GastoViagem {

    @Id
    @SequenceGenerator(name = "seq_gasto_viagem", sequenceName = "seq_gasto_viagem")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gasto_viagem")
    private Integer id;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_viagem")
    private Viagem viagem;
}
