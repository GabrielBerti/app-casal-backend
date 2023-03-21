package com.appcasal.api.assembler;

import com.appcasal.api.dto.request.TransacaoRequestDTO;
import com.appcasal.domain.model.Transacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Transacao toDomainObject(TransacaoRequestDTO transacaoRequestDTO) {
        return modelMapper.map(transacaoRequestDTO, Transacao.class);
    }

    public void copyToDomainObject(TransacaoRequestDTO transacaoRequestDTO, Transacao transacao) {
        modelMapper.map(transacaoRequestDTO, transacao);
    }
}
