package com.appcasal.api.dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MetaRequestDTO {
    private Integer id;
    @NotBlank
    private String descricao;
    @NotNull
    private Boolean concluido;
}
