package com.appcasal.api.dto.request;

import com.appcasal.domain.model.Receita;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class IngredienteRequestDTO {
    private Integer id;
    @NotBlank
    private String descricao;
    private Boolean marcado;
    @NotNull
    private Receita receita;
}
