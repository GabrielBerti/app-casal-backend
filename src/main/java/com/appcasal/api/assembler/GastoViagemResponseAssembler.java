package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.GastoViagemResponseDTO;
import com.appcasal.domain.model.GastoViagem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GastoViagemResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public GastoViagemResponseDTO toDTO(GastoViagem gastoViagem) {
        return modelMapper.map(gastoViagem, GastoViagemResponseDTO.class);
    }

    public List<GastoViagemResponseDTO> toCollectionModel(List<GastoViagem> gastoViagens) {
        return gastoViagens.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
