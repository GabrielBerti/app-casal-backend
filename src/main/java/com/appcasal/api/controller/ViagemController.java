package com.appcasal.api.controller;

import com.appcasal.api.assembler.ViagemRequestDisassembler;
import com.appcasal.api.assembler.ViagemResponseAssembler;
import com.appcasal.api.dto.request.ViagemRequestDTO;
import com.appcasal.api.dto.response.ViagemResponseDTO;
import com.appcasal.domain.model.Viagem;
import com.appcasal.domain.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/viagens") // por Default essa sera a URI atendida
public class ViagemController {

    @Autowired
    private ViagemService service;

    @Autowired
    private ViagemResponseAssembler assembler;

    @Autowired
    private ViagemRequestDisassembler disassembler;

    @GetMapping
    public List<ViagemResponseDTO> findAll() {
        List<Viagem> viagens = service.findAll();

        return assembler.toCollectionModel(viagens);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViagemResponseDTO add(@RequestBody @Valid ViagemRequestDTO viagemRequestDTO) {
        Viagem viagem = disassembler.toDomainObject(viagemRequestDTO);

        viagem = service.add(viagem);

        return assembler.toDTO(viagem);
    }

    @PutMapping("/{id}")
    public ViagemResponseDTO update(@PathVariable("id") Integer id, @RequestBody @Valid ViagemRequestDTO viagemRequestDTO) {
        Viagem viagem = service.getById(id);

        disassembler.copyToDomainObject(viagemRequestDTO, viagem);

        viagem = service.add(viagem);

        return assembler.toDTO(viagem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
