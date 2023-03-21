package com.appcasal.api.controller;

import com.appcasal.api.assembler.TransacaoRequestDisassembler;
import com.appcasal.api.assembler.TransacaoResponseAssembler;
import com.appcasal.api.dto.request.TransacaoRequestDTO;
import com.appcasal.api.dto.response.TransacaoResponseDTO;
import com.appcasal.domain.model.Tipo;
import com.appcasal.domain.model.Transacao;
import com.appcasal.domain.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transacoes") // por Default essa sera a URI atendida
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @Autowired
    private TransacaoResponseAssembler assembler;

    @Autowired
    private TransacaoRequestDisassembler disassembler;

    @GetMapping
    public List<TransacaoResponseDTO> findAll() {
        List<Transacao> transacoes = service.findAll();

        return assembler.toCollectionModel(transacoes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoResponseDTO add(@RequestBody @Valid TransacaoRequestDTO transacaoRequestDTO) {
        Transacao transacao = disassembler.toDomainObject(transacaoRequestDTO);

        transacao = service.add(transacao);

        return assembler.toDTO(transacao);
    }

    @PutMapping("/{id}")
    public TransacaoResponseDTO update(@PathVariable("id") Integer id, @RequestBody @Valid TransacaoRequestDTO transacaoRequestDTO) {
        Transacao transacao = service.getById(id);

        disassembler.copyToDomainObject(transacaoRequestDTO, transacao);

        transacao = service.add(transacao);

        return assembler.toDTO(transacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    @DeleteMapping("deleteAll")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        service.deleteAll();
    }

}
