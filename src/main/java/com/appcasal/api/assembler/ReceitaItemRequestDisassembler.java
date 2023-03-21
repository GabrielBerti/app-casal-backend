package com.appcasal.api.assembler;

import com.appcasal.api.dto.request.ReceitaItemRequestDTO;
import com.appcasal.domain.model.ReceitaItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceitaItemRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public ReceitaItem toDomainObject(ReceitaItemRequestDTO receitaItemRequestDTO){
        return modelMapper.map(receitaItemRequestDTO, ReceitaItem.class);
    }

    public void copyToDomainObject(ReceitaItemRequestDTO receitaItemRequestDTO, ReceitaItem receitaItem){
        modelMapper.map(receitaItemRequestDTO, receitaItem);
    }
}
