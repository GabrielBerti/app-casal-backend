package com.appcasal.api.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReceitaRequestDTO {
    private Integer id;
    @NotBlank
    private String nome;
    private String descricao;
}
