package com.appcasal.api.controller;

import com.appcasal.api.assembler.GastoViagemRequestDisassembler;
import com.appcasal.api.assembler.GastoViagemResponseAssembler;
import com.appcasal.api.dto.request.GastoViagemRequestDTO;
import com.appcasal.api.dto.response.GastoViagemResponseDTO;
import com.appcasal.domain.model.GastoViagem;
import com.appcasal.domain.service.GastoViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/gastos-viagem") // por Default essa sera a URI atendida
public class GastoViagemController {

    @Autowired
    private GastoViagemService service;

    @Autowired
    private GastoViagemResponseAssembler assembler;

    @Autowired
    private GastoViagemRequestDisassembler disassembler;

    @RequestMapping(value = "/{viagemId}", method = RequestMethod.GET)
    public List<GastoViagemResponseDTO> getGastosViagemByViagem(@PathVariable("viagemId") Integer viagemId) {
        List<GastoViagem> gastoViagens = service.getGastosViagemByViagem(viagemId);

        return assembler.toCollectionModel(gastoViagens);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GastoViagemResponseDTO add(@RequestBody @Valid GastoViagemRequestDTO gastoViagemRequestDTO) {
        GastoViagem gastoViagem = disassembler.toDomainObject(gastoViagemRequestDTO);

        gastoViagem = service.add(gastoViagem);

        return assembler.toDTO(gastoViagem);
    }

    @PutMapping("/{id}")
    public GastoViagemResponseDTO update(@PathVariable("id") Integer id, @RequestBody @Valid GastoViagemRequestDTO gastoViagemRequestDTO) {
        GastoViagem gastoViagem = service.getById(id);

        disassembler.copyToDomainObject(gastoViagemRequestDTO, gastoViagem);

        gastoViagem = service.add(gastoViagem);

        return assembler.toDTO(gastoViagem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
