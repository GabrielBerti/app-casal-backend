package com.appcasal.api.dto.response;

import com.appcasal.domain.model.Receita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteResponseDTO {
    private Integer id;
    private String descricao;
    private Boolean marcado;
}
