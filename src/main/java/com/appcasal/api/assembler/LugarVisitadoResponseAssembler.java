package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.LugarVisitadoResponseDTO;
import com.appcasal.domain.model.LugarVisitado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LugarVisitadoResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public LugarVisitadoResponseDTO toDTO(LugarVisitado lugarVisitado) {
        return modelMapper.map(lugarVisitado, LugarVisitadoResponseDTO.class);
    }

    public List<LugarVisitadoResponseDTO> toCollectionModel(List<LugarVisitado> lugaresVisitados) {
        return lugaresVisitados.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
