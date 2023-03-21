package com.appcasal.api.controller;

import com.appcasal.api.assembler.IngredienteRequestDisassembler;
import com.appcasal.api.assembler.IngredienteResponseAssembler;
import com.appcasal.api.dto.request.IngredienteRequestDTO;
import com.appcasal.api.dto.response.IngredienteResponseDTO;
import com.appcasal.domain.model.Ingrediente;
import com.appcasal.domain.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ingredientes") // por Default essa sera a URI atendida
public class IngredienteController {

    @Autowired
    private IngredienteService service;

    @Autowired
    private IngredienteResponseAssembler assembler;

    @Autowired
    private IngredienteRequestDisassembler disassembler;

//    @GetMapping
//    public List<IngredienteResponseDTO> findAll() {
//        List<Ingrediente> ingredientes = service.findAll();
//
//        return assembler.toCollectionModel(ingredientes);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IngredienteResponseDTO add(@RequestBody @Valid IngredienteRequestDTO ingredienteRequestDTO) {
        Ingrediente ingrediente = disassembler.toDomainObject(ingredienteRequestDTO);

        ingrediente = service.add(ingrediente);

        return assembler.toDTO(ingrediente);
    }

    @PutMapping("/{id}")
    public IngredienteResponseDTO update(@PathVariable("id") Integer id, @RequestBody @Valid IngredienteRequestDTO ingredienteRequestDTO) {
        Ingrediente ingrediente = service.getById(id);

        disassembler.copyToDomainObject(ingredienteRequestDTO, ingrediente);

        ingrediente = service.add(ingrediente);

        return assembler.toDTO(ingrediente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
