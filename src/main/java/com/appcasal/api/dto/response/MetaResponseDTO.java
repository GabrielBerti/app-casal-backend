package com.appcasal.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetaResponseDTO {
    private Integer id;
    private String descricao;
    private Boolean concluido;
}
