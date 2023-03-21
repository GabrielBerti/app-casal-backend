package com.appcasal.domain.repository;

import com.appcasal.domain.model.ReceitaItem;
import com.appcasal.domain.model.ReceitaItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaItemRepository extends JpaRepository<ReceitaItem, ReceitaItemPK> {

}
