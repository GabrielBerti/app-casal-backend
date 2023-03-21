package com.appcasal;

import com.appcasal.domain.model.*;
import com.appcasal.domain.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppCasalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppCasalApplication.class, args);
    }

    @Bean
    CommandLineRunner cargaInicial(
            MetaRepository metaRepository,
            TransacaoRepository transacaoRepository,
            ViagemRepository viagemRepository,
            GastoViagemRepository gastoViagemRepository,
            LugarVisitadoRepository lugarVisitadoRepository,
            ReceitaRepository receitaRepository,
            IngredienteRepository ingredienteRepository) {
//        System.out.println("Carga de mock");
//
//        metaRepository.deleteAll();
//        transacaoRepository.deleteAll();
//        viagemRepository.deleteAll();
//        gastoViagemRepository.deleteAll();
//        lugarVisitadoRepository.deleteAll();
//        receitaRepository.deleteAll();
//        ingredienteRepository.deleteAll();
//
//        //
//        // Inserindo receitas e ingredientes
//        Receita strogronoff = Receita.builder().nome("Strogonoff").build();
//
//        Ingrediente frango = Ingrediente.builder()
//                .descricao("Frango")
//                .marcado(false)
//                .receita(strogronoff)
//                .build();
//
//        Ingrediente cogumelo = Ingrediente.builder()
//                .descricao("cogumelo")
//                .marcado(false)
//                .receita(strogronoff)
//                .build();
//
//        receitaRepository.save(strogronoff);
//        ingredienteRepository.save(frango);
//        ingredienteRepository.save(cogumelo);
//        //
//        //
//        Receita macarrao = Receita.builder().nome("Macarrao").build();
//
//        Ingrediente carne = Ingrediente.builder()
//                .descricao("Carne")
//                .marcado(true)
//                .receita(macarrao)
//                .build();
//
//        receitaRepository.save(macarrao);
//        ingredienteRepository.save(carne);
//
//        //
//        // Inserindo transacoes
//
//        Transacao transacao1 = Transacao.builder()
//                .descricao("festa")
//                .data("21/03/2023")
//                .tipo(Tipo.BIEL)
//                .valor(BigDecimal.valueOf(11.89))
//                .build();
//
//        Transacao transacao2 = Transacao.builder()
//                .descricao("mercado")
//                .data("22/03/2023")
//                .tipo(Tipo.MARI)
//                .valor(BigDecimal.valueOf(102))
//                .build();
//
//        Transacao transacao3 = Transacao.builder()
//                .descricao("role")
//                .data("23/03/2023")
//                .tipo(Tipo.BIEL)
//                .valor(BigDecimal.valueOf(78.90))
//                .build();
//
//        transacaoRepository.save(transacao1);
//        transacaoRepository.save(transacao2);
//        transacaoRepository.save(transacao3);
//
//        //
//        // Inserindo metas
//        Meta meta1 = Meta.builder().descricao("Viajar").concluido(true).build();
//        Meta meta2 = Meta.builder().descricao("Andar de cavalo").concluido(false).build();
//        metaRepository.save(meta1);
//        metaRepository.save(meta2);
//
//        //
//        // Inserindo viagens, lugares conhecidos e gastos da viagem
//        Viagem portoAlegre = Viagem.builder()
//                .local("Porto Alegre")
//                .nota(4.5)
//                .dataInicio("02/06/2023")
//                .dataFim("11/06/2023")
//                .build();
//
//        GastoViagem chocolate = GastoViagem.builder()
//                .descricao("Chocolate Gramado")
//                .valor(BigDecimal.valueOf(120.00))
//                .viagem(portoAlegre)
//                .build();
//
//        GastoViagem estadio = GastoViagem.builder()
//                .descricao("Jogo Inter").
//                valor(BigDecimal.valueOf(30.00)).
//                viagem(portoAlegre).
//                build();
//
//        LugarVisitado gramado = LugarVisitado.builder()
//                .nome("Gramado")
//                .nota(5)
//                .viagem(portoAlegre)
//                .build();
//
//        LugarVisitado beiraRio = LugarVisitado.builder()
//                .nome("Beira Rio")
//                .nota(3.5)
//                .viagem(portoAlegre)
//                .build();
//
//        viagemRepository.save(portoAlegre);
//        gastoViagemRepository.save(chocolate);
//        gastoViagemRepository.save(estadio);
//        lugarVisitadoRepository.save(gramado);
//        lugarVisitadoRepository.save(beiraRio);
//        //
//        //
//
//        Viagem brotas = Viagem.builder()
//                .local("Brotas")
//                .nota(4.5)
//                .dataInicio("02/06/2023")
//                .dataFim("11/06/2023")
//                .build();
//
//        GastoViagem cachacaria = GastoViagem.builder()
//                .descricao("Cachacaria")
//                .valor(BigDecimal.valueOf(45.00))
//                .viagem(brotas)
//                .build();
//        LugarVisitado pizzaria = LugarVisitado.builder()
//                .nome("Pizzaria")
//                .nota(2.5)
//                .viagem(brotas)
//                .build();
//
//        viagemRepository.save(brotas);
//        gastoViagemRepository.save(cachacaria);
//        lugarVisitadoRepository.save(pizzaria);

        return null;
    }

}
