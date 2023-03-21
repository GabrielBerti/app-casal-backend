package com.appcasal.api.controller;

import com.appcasal.api.assembler.ReceitaRequestDisassembler;
import com.appcasal.api.assembler.ReceitaResponseAssembler;
import com.appcasal.api.dto.request.ReceitaRequestDTO;
import com.appcasal.api.dto.response.ReceitaResponseDTO;
import com.appcasal.domain.model.Receita;
import com.appcasal.domain.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/receitas") // por Default essa sera a URI atendida
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @Autowired
    private ReceitaResponseAssembler assembler;

    @Autowired
    private ReceitaRequestDisassembler disassembler;

    @GetMapping
    public List<ReceitaResponseDTO> findAll() {
        List<Receita> receitas = service.findAll();

        return assembler.toCollectionModel(receitas);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReceitaResponseDTO add(@RequestBody @Valid ReceitaRequestDTO receitaRequestDTO) {
        Receita receita = disassembler.toDomainObject(receitaRequestDTO);

        receita = service.add(receita);

        return assembler.toDTO(receita);
    }

    @PutMapping("/{id}")
    public ReceitaResponseDTO update(@PathVariable("id") Integer id, @RequestBody @Valid ReceitaRequestDTO receitaRequestDTO) {
        Receita receita = service.getById(id);

        disassembler.copyToDomainObject(receitaRequestDTO, receita);

        receita = service.add(receita);

        return assembler.toDTO(receita);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
