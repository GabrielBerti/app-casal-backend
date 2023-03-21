package com.appcasal.api.assembler;

import com.appcasal.api.dto.request.IngredienteRequestDTO;
import com.appcasal.domain.model.Ingrediente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredienteRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Ingrediente toDomainObject(IngredienteRequestDTO ingredienteRequestDTO) {
        return modelMapper.map(ingredienteRequestDTO, Ingrediente.class);
    }

    public void copyToDomainObject(IngredienteRequestDTO ingredienteRequestDTO, Ingrediente ingrediente) {
        modelMapper.map(ingredienteRequestDTO, ingrediente);
    }
}
