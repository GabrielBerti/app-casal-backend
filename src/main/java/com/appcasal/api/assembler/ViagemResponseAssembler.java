package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.ViagemResponseDTO;
import com.appcasal.domain.model.Viagem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ViagemResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ViagemResponseDTO toDTO(Viagem viagem) {
        return modelMapper.map(viagem, ViagemResponseDTO.class);
    }

    public List<ViagemResponseDTO> toCollectionModel(List<Viagem> viagens) {
        return viagens.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
