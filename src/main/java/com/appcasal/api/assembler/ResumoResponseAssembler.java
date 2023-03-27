package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.ResumoResponseDTO;
import com.appcasal.domain.model.Resumo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumoResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ResumoResponseDTO toDTO(Resumo resumo) {
        return modelMapper.map(resumo, ResumoResponseDTO.class);
    }
}
