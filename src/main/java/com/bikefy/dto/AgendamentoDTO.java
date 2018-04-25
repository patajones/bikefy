package com.bikefy.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AgendamentoDTO {
	
    private Integer ponto_retirada_id;
    private Integer ponto_devolucao_id;
    private LocalDate data_retirada;
    private LocalDate data_devolucao;
    private LocalTime hora_retirada;
    private LocalTime hora_devolucao;
    
}
