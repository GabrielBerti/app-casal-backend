package com.appcasal.api.controller;


import com.appcasal.api.assembler.ItemResponseAssembler;
import com.appcasal.api.assembler.ReceitaItemResponseAssembler;
import com.appcasal.api.dto.request.ReceitaItemRequestDTO;
import com.appcasal.api.dto.response.ReceitaItemListResponseDTO;
import com.appcasal.api.dto.response.ReceitaItemResponseDTO;
import com.appcasal.domain.model.Item;
import com.appcasal.domain.model.Receita2;
import com.appcasal.domain.model.ReceitaItem;
import com.appcasal.domain.model.ReceitaItemPK;
import com.appcasal.domain.service.ItemService;
import com.appcasal.domain.service.ReceitaItemService;
import com.appcasal.domain.service.Receita2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/receitas-itens")
public class ReceitaItemController {

    @Autowired
    ReceitaItemService receitaItemService;

    @Autowired
    Receita2Service receitaService;

    @Autowired
    ItemService itemService;

    @Autowired
    private ReceitaItemResponseAssembler assembler;

    @Autowired
    private ItemResponseAssembler itemAssembler;

    @GetMapping
    public List<ReceitaItemResponseDTO> findAll(){
        List<ReceitaItem> receitaItems = receitaItemService.findAll();

        return assembler.toCollectionModel(receitaItems);
    }

    @GetMapping("/{receitaId}/itens")
    public ReceitaItemListResponseDTO getItemList(){
        List<Item> itemList = itemService.filter(null, "a", null, null);

        ReceitaItemListResponseDTO receitaItemList = ReceitaItemListResponseDTO.builder()
                .receitaItens(itemAssembler.toCollectionModel(itemList))
                .build();

        return receitaItemList;
    }

    @PostMapping
    public ReceitaItemResponseDTO add(@RequestBody @Valid ReceitaItemRequestDTO request){
        Receita2 receita = receitaService.getById(request.getReceitaId());

        Item item = itemService.getById(request.getItemId());

        ReceitaItemPK receitaItemPK = ReceitaItemPK.builder()
                .receitaId(receita)
                .itemId(item)
                .build();

        ReceitaItem receitaItem = ReceitaItem.builder()
                .id(receitaItemPK)
                .build();

        receitaItem = receitaItemService.add(receitaItem);

        return assembler.toDTO(receitaItem);
    }

}
