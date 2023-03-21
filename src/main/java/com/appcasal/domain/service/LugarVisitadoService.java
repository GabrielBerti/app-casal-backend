package com.appcasal.domain.service;

import com.appcasal.domain.exception.ItemNaoEncontradoException;
import com.appcasal.domain.model.LugarVisitado;
import com.appcasal.domain.repository.LugarVisitadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarVisitadoService {

    @Autowired
    LugarVisitadoRepository repository;

    public List<LugarVisitado> findAll() {
        return repository.findAll();
    }

    public LugarVisitado getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    public LugarVisitado add(LugarVisitado lugarVisitado) {
        return repository.save(lugarVisitado);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException(id);
        }
    }
}