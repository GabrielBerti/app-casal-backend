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
@Table(name = "meta")
public class Meta {

//    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_meta", sequenceName = "seq_meta")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_meta")
    private Integer id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "concluido", nullable = false)
    private Boolean concluido;

}
