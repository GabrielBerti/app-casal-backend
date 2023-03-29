package com.appcasal.api.controller;

import com.appcasal.api.assembler.LugarVisitadoRequestDisassembler;
import com.appcasal.api.assembler.LugarVisitadoResponseAssembler;
import com.appcasal.api.dto.request.LugarVisitadoRequestDTO;
import com.appcasal.api.dto.response.LugarVisitadoResponseDTO;
import com.appcasal.domain.model.LugarVisitado;
import com.appcasal.domain.service.LugarVisitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lugares-visitados") // por Default essa sera a URI atendida
public class LugarVisitadoController {

    @Autowired
    private LugarVisitadoService service;

    @Autowired
    private LugarVisitadoResponseAssembler assembler;

    @Autowired
    private LugarVisitadoRequestDisassembler disassembler;

    @RequestMapping(value = "/{viagemId}", method = RequestMethod.GET)
    public List<LugarVisitadoResponseDTO> getLugaresVisitadosByViagem(@PathVariable("viagemId") Integer viagemId) {
        List<LugarVisitado> lugaresVisitados = service.getLugaresVisitadosByViagem(viagemId);

        return assembler.toCollectionModel(lugaresVisitados);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LugarVisitadoResponseDTO add(@RequestBody @Valid LugarVisitadoRequestDTO lugarVisitadoRequestDTO) {
        LugarVisitado lugarVisitado = disassembler.toDomainObject(lugarVisitadoRequestDTO);

        lugarVisitado = service.add(lugarVisitado);

        return assembler.toDTO(lugarVisitado);
    }

    @PutMapping("/{id}")
    public LugarVisitadoResponseDTO update(@PathVariable("id") Integer id, @RequestBody @Valid LugarVisitadoRequestDTO lugarVisitadoRequestDTO) {
        LugarVisitado lugarVisitado = service.getById(id);

        disassembler.copyToDomainObject(lugarVisitadoRequestDTO, lugarVisitado);

        lugarVisitado = service.add(lugarVisitado);

        return assembler.toDTO(lugarVisitado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
