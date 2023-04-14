package com.appcasal.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViagemResponseDTO {
    private Integer id;
    @NotBlank
    private String local;
    private String dataInicio;
    private String dataFim;
    private Double nota;
    private ArrayList<LugarVisitadoResponseDTO> lugaresVisitados;
    private ArrayList<GastoViagemResponseDTO> gastosViagem;
}
