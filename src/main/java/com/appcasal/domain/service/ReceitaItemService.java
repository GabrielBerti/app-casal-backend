package com.appcasal.domain.service;

import com.appcasal.domain.model.ReceitaItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceitaItemService {

    //@Autowired
    //ReceitaItemRepository repository;

    public List<ReceitaItem> findAll(){
        //return repository.findAll();
        return new ArrayList<>();
    }

    public ReceitaItem add(ReceitaItem receitaItem){
        //return repository.save(receitaItem);
        return new ReceitaItem();
    }

}
