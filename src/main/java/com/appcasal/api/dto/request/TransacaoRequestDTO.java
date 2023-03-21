package com.appcasal.api.dto.request;

import com.appcasal.domain.model.Tipo;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TransacaoRequestDTO {
    private Integer id;
    @NotNull
    private BigDecimal valor;
    @NotBlank
    private String descricao;
    @NotNull
    private Tipo tipo;
    @NotBlank
    private String data;
}
