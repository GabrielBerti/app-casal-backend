package com.appcasal.api.assembler;

import com.appcasal.api.dto.request.LugarVisitadoRequestDTO;
import com.appcasal.domain.model.LugarVisitado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LugarVisitadoRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public LugarVisitado toDomainObject(LugarVisitadoRequestDTO lugarVisitadoRequestDTO) {
        return modelMapper.map(lugarVisitadoRequestDTO, LugarVisitado.class);
    }

    public void copyToDomainObject(LugarVisitadoRequestDTO lugarVisitadoRequestDTO, LugarVisitado lugarVisitado) {
        modelMapper.map(lugarVisitadoRequestDTO, lugarVisitado);
    }
}
