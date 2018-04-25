package com.bikefy.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Agendamento {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NonNull @NotNull
    @ManyToOne
    private Ponto pontoRetirada;
    
    @ManyToOne
    private Ponto pontoDevolucao;    
        
    @NonNull @NotNull
    private LocalDate data_retirada;

	private LocalDate data_devolucao;
	
	@NonNull @NotNull
    private LocalTime hora_retirada;
    
    private LocalTime hora_devolucao;
    
}

