package com.appcasal.domain.service;

import com.appcasal.domain.exception.ItemNaoEncontradoException;
import com.appcasal.domain.model.Receita;
import com.appcasal.domain.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository repository;

    public List<Receita> findAll() {
        return repository.findAll();
    }

    public List<Receita> getReceitas(String search) {
        if(search != null) {
            return repository.getReceitaByNome(search);
        } else {
            return repository.findAll();
        }
    }

    public Receita getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    public Receita add(Receita receita) {
        return repository.save(receita);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException(id);
        }
    }
}