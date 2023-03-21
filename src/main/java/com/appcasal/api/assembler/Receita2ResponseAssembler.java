package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.Receita2ResponseDTO;
import com.appcasal.domain.model.Receita2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Receita2ResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public Receita2ResponseDTO toDTO(Receita2 receita) {
        return modelMapper.map(receita, Receita2ResponseDTO.class);
    }

    public List<Receita2ResponseDTO> toCollectionModel(List<Receita2> receitas) {
        return receitas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
