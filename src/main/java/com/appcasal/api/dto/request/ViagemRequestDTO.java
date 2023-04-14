package com.appcasal.api.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ViagemRequestDTO {
    private Integer id;
    @NotBlank
    private String local;
    private String dataInicio;
    private String dataFim;
    private Double nota;
}
