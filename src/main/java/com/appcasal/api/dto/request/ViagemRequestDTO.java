package com.appcasal.api.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Calendar;

@Data
public class ViagemRequestDTO {
    private Integer id;
    @NotBlank
    private String local;
    private Calendar dataInicio;
    private Calendar dataFim;
    private Double nota;
}
