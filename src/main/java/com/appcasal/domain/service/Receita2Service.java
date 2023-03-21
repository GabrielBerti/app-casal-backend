package com.appcasal.domain.service;

import com.appcasal.domain.exception.ReceitaNaoEncontradaException;
import com.appcasal.domain.model.Receita2;
import com.appcasal.domain.repository.ReceitaCustomRepository;
import com.appcasal.domain.repository.Receita2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class Receita2Service {

    @Autowired
    Receita2Repository repository;

    @Autowired
    ReceitaCustomRepository repositoryCustom;

    public List<Receita2> findAll(){
        return repository.findAll();
    }

    public Receita2 getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ReceitaNaoEncontradaException(id));    }

    public Receita2 add(Receita2 receita){
        //receita.setId(null);
        return repository.save(receita);
    }

    public List<Receita2> filter(Integer id,
                                 String descricao,
                                 BigDecimal valorDe,
                                 BigDecimal valorAte){
        return repositoryCustom.filterCustomizado(id, descricao, valorDe, valorAte);
    }

    public void delete(Integer id){
        try {
            Receita2 receita = repository.getById(id);
            repository.delete(receita);
        } catch (EmptyResultDataAccessException e) {
            throw new ReceitaNaoEncontradaException(id);
        }
    }

}
