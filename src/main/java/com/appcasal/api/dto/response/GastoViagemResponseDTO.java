package com.appcasal.api.dto.response;

import com.appcasal.domain.model.Viagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GastoViagemResponseDTO {
    private Integer id;
    private BigDecimal valor;
    private String descricao;
}
