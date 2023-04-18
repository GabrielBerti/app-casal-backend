package com.appcasal.api.dto.request;

import com.appcasal.domain.model.Tipo;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Calendar;

@Data
public class TransacaoRequestDTO {
    private Integer id;
    @NotNull
    private BigDecimal valor;
    @NotBlank
    private String descricao;
    @NotNull
    private Tipo tipo;
    @NotNull
    private Calendar data;
}
