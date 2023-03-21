package com.appcasal.api.controller;

import com.appcasal.api.assembler.MetaRequestDisassembler;
import com.appcasal.api.assembler.MetaResponseAssembler;
import com.appcasal.api.dto.request.MetaRequestDTO;
import com.appcasal.api.dto.response.MetaResponseDTO;
import com.appcasal.domain.model.Meta;
import com.appcasal.domain.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/metas") // por Default essa sera a URI atendida
public class MetaController {

    @Autowired
    private MetaService service;

    @Autowired
    private MetaResponseAssembler assembler;

    @Autowired
    private MetaRequestDisassembler disassembler;

    @GetMapping
    public List<MetaResponseDTO> findAll() {
        List<Meta> metas = service.findAll();

        return assembler.toCollectionModel(metas);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MetaResponseDTO add(@RequestBody @Valid MetaRequestDTO metaRequestDTO) {
        Meta meta = disassembler.toDomainObject(metaRequestDTO);

        meta = service.add(meta);

        return assembler.toDTO(meta);
    }

    @PutMapping("/{id}")
    public MetaResponseDTO update(@PathVariable("id") Integer id, @RequestBody @Valid MetaRequestDTO metaRequestDTO) {
        Meta meta = service.getById(id);

        disassembler.copyToDomainObject(metaRequestDTO, meta);

        meta = service.add(meta);

        return assembler.toDTO(meta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
