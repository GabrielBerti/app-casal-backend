package com.appcasal.api.controller;

import com.appcasal.api.assembler.IngredienteRequestDisassembler;
import com.appcasal.api.assembler.IngredienteResponseAssembler;
import com.appcasal.api.dto.request.IngredienteRequestDTO;
import com.appcasal.api.dto.response.IngredienteResponseDTO;
import com.appcasal.domain.model.Ingrediente;
import com.appcasal.domain.service.IngredienteService;
import com.appcasal.domain.service.ReceitaService;
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
    private ReceitaService receitaService;

    @Autowired
    private IngredienteResponseAssembler assembler;

    @Autowired
    private IngredienteRequestDisassembler disassembler;

    @RequestMapping(value = "/{receitaId}", method = RequestMethod.GET)
    public List<IngredienteResponseDTO> getIngredientesByReceita(@PathVariable("receitaId") Integer receitaId) {
        List<Ingrediente> ingredientes = service.getIngredientesByReceita(receitaId);

        return assembler.toCollectionModel(ingredientes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IngredienteResponseDTO add(@RequestBody @Valid List<IngredienteRequestDTO> ingredientesRequestDTO) {

        Ingrediente ingrediente = null;

        for (IngredienteRequestDTO ingredienteRequestDTO : ingredientesRequestDTO) {
            ingrediente = disassembler.toDomainObject(ingredienteRequestDTO);
            ingrediente = service.add(ingrediente);
        }

        return assembler.toDTO(ingrediente);
    }

    @PutMapping("/{id}")
    public IngredienteResponseDTO update(@PathVariable("id") Integer id, @RequestBody @Valid IngredienteRequestDTO ingredienteRequestDTO) {
        Ingrediente ingrediente = service.getById(id);

        disassembler.copyToDomainObject(ingredienteRequestDTO, ingrediente);

        ingrediente = service.add(ingrediente);

        return assembler.toDTO(ingrediente);
    }

    @PutMapping("marcou/{id}/{marcado}")
    public void marcou(@PathVariable("marcado") Boolean marcado, @PathVariable("id") Integer id) {
        Ingrediente ingrediente = service.getById(id);
        ingrediente.setMarcado(marcado);
        service.add(ingrediente);
    }

    @PutMapping("desmarcarTodos/{receitaId}")
    public void desmarcarTodos(@PathVariable("receitaId") Integer receitaId) {
        List<Ingrediente> ingredientes = receitaService.getById(receitaId).getIngredientes();

        for (Ingrediente ingrediente : ingredientes) {
            ingrediente.setMarcado(false);
            service.add(ingrediente);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
