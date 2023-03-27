package com.appcasal.domain.service;

import com.appcasal.domain.exception.ItemNaoEncontradoException;
import com.appcasal.domain.model.Resumo;
import com.appcasal.domain.model.Transacao;
import com.appcasal.domain.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository repository;

    public List<Transacao> findAll() {
        return repository.findAll();
    }

    public Transacao getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ItemNaoEncontradoException(id));
    }

    public Resumo getValorTransacaoByType() {
        BigDecimal saldoBiel = repository.getValorTransacaoByType(0);
        BigDecimal saldoMari = repository.getValorTransacaoByType(1);

        return new Resumo(saldoBiel, saldoMari);
    }

    public Transacao add(Transacao transacao) {
        return repository.save(transacao);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException(id);
        }
    }

    public void deleteAll() {
        try {
            repository.deleteAll();
        } catch (EmptyResultDataAccessException e) {
            throw new ItemNaoEncontradoException("Erro ao remover todos lançamentos");
        }
    }
}