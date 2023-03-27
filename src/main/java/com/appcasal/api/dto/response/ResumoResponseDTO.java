package com.appcasal.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumoResponseDTO {
    private BigDecimal saldoBiel;
    private BigDecimal saldoMari;
}
