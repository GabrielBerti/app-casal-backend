package com.appcasal.domain.service;

import com.appcasal.domain.exception.ItemNaoEncontradoException;
import com.appcasal.domain.model.Ingrediente;
import com.appcasal.domain.model.Viagem;
import com.appcasal.domain.repository.IngredienteRepository;
import com.appcasal.domain.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    ViagemRepository repository;

    public List<Viagem> getViagensByNome(String search) {
        if(search != null) {
            return repository.getViagensByNome(search);
        } else {
            return repository.findAll();
        }
    }

    public Viagem getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    public Viagem add(Viagem viagem) {
        return repository.save(viagem);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException(id);
        }
    }
}