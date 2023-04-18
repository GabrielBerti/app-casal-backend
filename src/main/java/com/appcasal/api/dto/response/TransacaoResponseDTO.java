package com.appcasal.api.dto.response;

import com.appcasal.domain.model.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Calendar;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoResponseDTO {
    private Integer id;
    private BigDecimal valor;
    private String descricao;
    private Tipo tipo;
    private Calendar data;
}
