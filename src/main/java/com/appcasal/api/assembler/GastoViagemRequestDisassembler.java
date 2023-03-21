package com.appcasal.api.assembler;

import com.appcasal.api.dto.request.GastoViagemRequestDTO;
import com.appcasal.domain.model.GastoViagem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GastoViagemRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public GastoViagem toDomainObject(GastoViagemRequestDTO gastoViagemRequestDTO) {
        return modelMapper.map(gastoViagemRequestDTO, GastoViagem.class);
    }

    public void copyToDomainObject(GastoViagemRequestDTO gastoViagemRequestDTO, GastoViagem gastoViagem) {
        modelMapper.map(gastoViagemRequestDTO, gastoViagem);
    }
}
