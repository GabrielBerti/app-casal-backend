package com.appcasal.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaItemResponseDTO {

    private Receita2ResponseDTO receita;

    private ItemResponseDTO item;
}
