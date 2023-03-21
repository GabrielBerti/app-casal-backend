package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.ReceitaResponseDTO;
import com.appcasal.domain.model.Receita;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceitaResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ReceitaResponseDTO toDTO(Receita receita) {
        return modelMapper.map(receita, ReceitaResponseDTO.class);
    }

    public List<ReceitaResponseDTO> toCollectionModel(List<Receita> receitas) {
        return receitas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
