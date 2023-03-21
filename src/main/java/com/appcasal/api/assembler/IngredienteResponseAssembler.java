package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.IngredienteResponseDTO;
import com.appcasal.domain.model.Ingrediente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredienteResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public IngredienteResponseDTO toDTO(Ingrediente ingrediente) {
        return modelMapper.map(ingrediente, IngredienteResponseDTO.class);
    }

    public List<IngredienteResponseDTO> toCollectionModel(List<Ingrediente> ingredientes) {
        return ingredientes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
