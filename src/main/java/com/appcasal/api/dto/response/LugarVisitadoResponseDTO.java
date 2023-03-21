package com.appcasal.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LugarVisitadoResponseDTO {
    private Integer id;
    private String nome;
    private double nota;
}
