package com.appcasal.api.assembler;

import com.appcasal.api.dto.request.Receita2RequestDTO;
import com.appcasal.domain.model.Receita2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receita2RequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Receita2 toDomainObject(Receita2RequestDTO receitaRequestDTO) {
        return modelMapper.map(receitaRequestDTO, Receita2.class);
    }

    public void copyToDomainObject(Receita2RequestDTO receitaRequestDTO, Receita2 receita) {
        modelMapper.map(receitaRequestDTO, receita);
    }
}
