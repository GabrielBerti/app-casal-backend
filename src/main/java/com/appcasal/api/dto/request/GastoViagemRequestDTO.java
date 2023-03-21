package com.appcasal.api.dto.request;

import com.appcasal.domain.model.Viagem;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class GastoViagemRequestDTO {
    private Integer id;
    @NotNull
    private BigDecimal valor;
    @NotBlank
    private String descricao;
    @NotNull
    private Viagem viagem;
}
