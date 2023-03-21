package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.MetaResponseDTO;
import com.appcasal.domain.model.Meta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MetaResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public MetaResponseDTO toDTO(Meta meta) {
        return modelMapper.map(meta, MetaResponseDTO.class);
    }

    public List<MetaResponseDTO> toCollectionModel(List<Meta> metas) {
        return metas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
