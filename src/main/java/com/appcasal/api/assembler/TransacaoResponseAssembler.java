package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.TransacaoResponseDTO;
import com.appcasal.domain.model.Transacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransacaoResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public TransacaoResponseDTO toDTO(Transacao transacao) {
        return modelMapper.map(transacao, TransacaoResponseDTO.class);
    }

    public List<TransacaoResponseDTO> toCollectionModel(List<Transacao> transacoes) {
        return transacoes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
