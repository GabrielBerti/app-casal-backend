package com.appcasal.api.dto.response;

import com.appcasal.domain.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaResponseDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private ArrayList<IngredienteResponseDTO> ingredientes;
}
