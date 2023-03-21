package com.appcasal.api.assembler;

import com.appcasal.api.dto.request.MetaRequestDTO;
import com.appcasal.domain.model.Meta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetaRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Meta toDomainObject(MetaRequestDTO metaRequestDTO) {
        return modelMapper.map(metaRequestDTO, Meta.class);
    }

    public void copyToDomainObject(MetaRequestDTO metaRequestDTO, Meta meta) {
        modelMapper.map(metaRequestDTO, meta);
    }
}
