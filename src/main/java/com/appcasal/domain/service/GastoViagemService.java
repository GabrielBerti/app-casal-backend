package com.appcasal.domain.service;

import com.appcasal.domain.exception.ItemNaoEncontradoException;
import com.appcasal.domain.model.GastoViagem;
import com.appcasal.domain.repository.GastoViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoViagemService {

    @Autowired
    GastoViagemRepository repository;

    public List<GastoViagem> getGastosViagemByViagem(Integer fkViagem) {
        return repository.getGastosViagemByViagem(fkViagem);
    }

    public GastoViagem getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    public GastoViagem add(GastoViagem gastoViagem) {
        return repository.save(gastoViagem);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException(id);
        }
    }
}