package com.appcasal.api.assembler;

import com.appcasal.api.dto.response.ItemResponseDTO;
import com.appcasal.api.dto.response.ReceitaItemResponseDTO;
import com.appcasal.api.dto.response.Receita2ResponseDTO;
import com.appcasal.domain.model.ReceitaItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceitaItemResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

//    public ReceitaItemResponseDTO toDTO(ReceitaItem receitaItem){
//        return modelMapper.map(receitaItem, ReceitaItemResponseDTO.class);
//    }

    public ReceitaItemResponseDTO toDTO(ReceitaItem receitaItem){
        return ReceitaItemResponseDTO.builder()
                .receita(Receita2ResponseDTO.builder()
                        .id(receitaItem.getId().getReceitaId().getId())
                        .descricao(receitaItem.getId().getReceitaId().getDescricao())
                        .valor(receitaItem.getId().getReceitaId().getValor())
                        .imagem(receitaItem.getId().getReceitaId().getImagem())
                        .build())
                .item(ItemResponseDTO.builder()
                        .id(receitaItem.getId().getItemId().getId())
                        .descricao(receitaItem.getId().getItemId().getDescricao())
                        .imagem(receitaItem.getId().getItemId().getImagem())
                        .possuiEstoque(receitaItem.getId().getItemId().getPossuiEstoque())
                        .obs(receitaItem.getId().getItemId().getObs())
                        .build())
                .build();
//                return modelMapper.map(receitaItem, ReceitaItemResponseDTO.class);
    }

    public List<ReceitaItemResponseDTO> toCollectionModel(List<ReceitaItem> receitaItens){
        return receitaItens.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }



}
