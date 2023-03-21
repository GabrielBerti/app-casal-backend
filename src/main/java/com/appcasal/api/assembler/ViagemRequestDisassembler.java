package com.appcasal.api.assembler;

import com.appcasal.api.dto.request.ViagemRequestDTO;
import com.appcasal.domain.model.Viagem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ViagemRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Viagem toDomainObject(ViagemRequestDTO viagemRequestDTO) {
        return modelMapper.map(viagemRequestDTO, Viagem.class);
    }

    public void copyToDomainObject(ViagemRequestDTO viagemRequestDTO, Viagem viagem) {
        modelMapper.map(viagemRequestDTO, viagem);
    }
}
