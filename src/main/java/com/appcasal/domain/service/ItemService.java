package com.appcasal.domain.service;

import com.appcasal.domain.exception.ItemNaoEncontradoException;
import com.appcasal.domain.model.Item;
import com.appcasal.domain.repository.ItemCustomRepository;
import com.appcasal.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    @Autowired
    ItemCustomRepository repositoryCustom;

    public List<Item> findAll() {
        return repository.findAll();
    }

    public Item getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    public List<Item> filter(
            Integer id,
            String descricao,
            Integer possuiEstoqueDe,
            Integer possuiEstoqueAte){
        return repositoryCustom.filterCustomizado(id, descricao, possuiEstoqueDe, possuiEstoqueAte);
    }

    public Item add(Item item) {
        return repository.save(item);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException(id);
        }
    }
}