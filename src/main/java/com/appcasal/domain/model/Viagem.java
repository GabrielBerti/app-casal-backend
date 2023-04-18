package com.appcasal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "viagem")
public class Viagem {

//    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_meta", sequenceName = "seq_meta")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_meta")
    private Integer id;

    @Column(name = "local", nullable = false)
    private String local;
    @Column(name = "dataInicio")
    @Temporal(TemporalType.DATE)
    private Calendar dataInicio;

    @Column(name = "dataFim")
    @Temporal(TemporalType.DATE)
    private Calendar dataFim;

    @Column(name = "nota")
    private Double nota;

    @OneToMany(mappedBy = "viagem", cascade = CascadeType.REMOVE)
    private List<GastoViagem> gastosViagens = new ArrayList<>();

    @OneToMany(mappedBy = "viagem", cascade = CascadeType.REMOVE)
    private List<LugarVisitado> lugaresVisitados = new ArrayList<>();

}
