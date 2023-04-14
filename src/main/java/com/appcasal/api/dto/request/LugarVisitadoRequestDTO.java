package com.appcasal.api.dto.request;

import com.appcasal.domain.model.Viagem;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LugarVisitadoRequestDTO {
    private Integer id;
    @NotBlank
    private String nome;
    private Double nota;
    @NotNull
    private Viagem viagem;
}
