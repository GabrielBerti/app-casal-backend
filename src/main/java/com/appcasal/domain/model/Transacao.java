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
@Table(name = "transacao")
public class Transacao {

    @Id
    @SequenceGenerator(name = "seq_transacao", sequenceName = "seq_transacao")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_transacao")
    private Integer id;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tipo", nullable = false)
    private Tipo tipo;

    @Column(name = "data", nullable = false)
    private String data;
}
