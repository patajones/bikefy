package com.bikefy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Ponto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@NotNull
	private Double lat;

	@NonNull
	@NotNull
	private Double lon;

	@NonNull
	@NotNull(message = "'nome' do ponto não pode ser nulo.")
	@NotBlank(message = "'nome' do ponto não pode ser vazio.")
	private String nome;

	@NonNull
	@Default
	private String endereco = "";

	@NonNull
	@NotNull
	@Builder.Default
	private Integer qtd_bikes = 0;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ponto_atual")
	private final List<Bike> bikes = new ArrayList<Bike>();

	public void addBike(Bike bike) {
		bike.setPonto_atual(this);
		bikes.add(bike);
	}

}
