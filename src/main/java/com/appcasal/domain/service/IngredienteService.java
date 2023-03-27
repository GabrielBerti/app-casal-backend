package com.appcasal.domain.service;

import com.appcasal.domain.exception.ItemNaoEncontradoException;
import com.appcasal.domain.model.Ingrediente;
import com.appcasal.domain.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    IngredienteRepository repository;

    public List<Ingrediente> findAll() {
        return repository.findAll();
    }

    public List<Ingrediente> getIngredientesByReceita(Integer fkReceita) {
        return repository.getIngredientesByReceita(fkReceita);
    }

    public Ingrediente getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    public Ingrediente add(Ingrediente ingrediente) {
        return repository.save(ingrediente);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException(id);
        }
    }
}