package com.appcasal.domain.service;

import com.appcasal.domain.exception.ItemNaoEncontradoException;
import com.appcasal.domain.model.Meta;
import com.appcasal.domain.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {

    @Autowired
    MetaRepository repository;

    public List<Meta> findAll() {
        return repository.findAll();
    }

    public Meta getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    public Meta add(Meta meta) {
        return repository.save(meta);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException(id);
        }
    }
}